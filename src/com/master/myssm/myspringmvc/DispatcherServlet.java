package com.master.myssm.myspringmvc;

import com.master.myssm.ioc.BeanFactory;
import com.master.myssm.ioc.UrlAddress;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;

/**
 * @author master
 */
@WebServlet("/")
public class DispatcherServlet extends ViewBaseServlet {
    
    /**
     * bean工厂字段
     */
    private BeanFactory beanFactory;
    
    /**
     * 感觉这样写有些奇怪，但暂且先通过这个类获取对应关系
     */
    private UrlAddress urlAddress;
    
    public DispatcherServlet() {
    
    }
    
    /**
     * 初始化方法
     * 在执行完父级的初始化方法之后，获取IOC容器
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        super.init();
        //从application作用域中获取IOC容器
        ServletContext application = getServletContext();
        Object beanFactoryObj = application.getAttribute("beanFactory");
        if (beanFactoryObj != null) {
            beanFactory = (BeanFactory) beanFactoryObj;
        } else {
            throw new DispatcherServletException("IOC容器获取失败");
        }

        Object urlAddressObj = application.getAttribute("urlAddress");
        if (urlAddressObj != null) {
            urlAddress = (UrlAddress) urlAddressObj;
        } else {
            throw new DispatcherServletException("urlAddress容器获取失败");
        }
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //我的计划是：
        //通过urladdressing.xml文件，将url和方法的对应关系保存在map中，通过UrlAddressing获取
        //获取servletPath ==> /index
        String servletPath = req.getRequestURI();
        //获取对应类名和方法名
        Map<String, String> funcMap = urlAddress.getBean(servletPath);
        //获取对应类
        Object controllerBeanObj = beanFactory.getBean(funcMap.get("class"));

        try {
            //获取所有方法
            Method[] methods = controllerBeanObj.getClass().getDeclaredMethods();
            //一一对应找到方法
            for (Method method : methods) {
                //找到对应方法
                if (method.getName().equals(funcMap.get("func"))) {
                    //获取参数
                    Parameter[] parameters = method.getParameters();
                    //获取参数值
                    Object[] parameterValues = new Object[parameters.length];
                    for (int i = 0; i < parameters.length; i++) {
                        Parameter parameter = parameters[i];
                        String parameterName = parameter.getName();
                        //排除req,resp,session
                        if ("req".equals(parameterName)) {
                            parameterValues[i] = req;
                        } else if ("resp".equals(parameterName)) {
                            parameterValues[i] = resp;
                        } else if ("session".equals(parameterName)) {
                            parameterValues[i] = req.getSession();
                        } else {
                            //从req中获取参数值
                            String parameterValue = req.getParameter(parameterName);
                            String typeName = parameter.getType().getName();
                            //默认直接存入字符串类型的参数值
                            Object parameterObj = parameterValue;
                            //获取到的参数值是字符串，可根据typename转为其他类型
                            if (parameterObj != null) {
                                if ("java.lang.Integer".equals(typeName)) {
                                    parameterObj = Integer.parseInt(parameterValue);
                                }
                            }
                            //放入数组中
                            parameterValues[i] = parameterObj;
                        }
                    }
                    //调用方法
                    method.setAccessible(true);
                    Object returnObj = method.invoke(controllerBeanObj, parameterValues);
                    //视图处理
                    String methodReturnStr = (String) returnObj;
                    if (methodReturnStr.startsWith("redirect:")) {
                        //重定向处理
                        String redirectStr = methodReturnStr.substring("redirect:".length());
                        resp.sendRedirect(redirectStr);
                    }  else {
                        //调用父级方法 for thymeleaf
                        super.processTemplate(methodReturnStr, req, resp);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DispatcherServletException("DispatcherServlet出错了");
        }
    }
}
