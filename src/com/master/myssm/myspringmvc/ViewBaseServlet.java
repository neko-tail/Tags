package com.master.myssm.myspringmvc;


import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Thymeleaf解析
 * @author master
 */
public class ViewBaseServlet extends HttpServlet {
    /**
     * 模板引擎
     */
    private TemplateEngine templateEngine;
    
    /**
     * 对模板解析器和模板引擎进行一系列设置
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        
        //1.获取ServletContext对象
        ServletContext servletContext = this.getServletContext();
        
        //2.创建Thymeleaf解析器对象
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
        
        //3.给解析器对象设置参数
        // -1 HTML是默认模式，明确设置是为了让代码更容易理解
        templateResolver.setTemplateMode(TemplateMode.HTML);
        // -2 设置前缀
        String viewPrefix = servletContext.getInitParameter("view-prefix");
        templateResolver.setPrefix(viewPrefix);
        // -3 设置后缀
        String viewSuffix = servletContext.getInitParameter("view-suffix");
        templateResolver.setSuffix(viewSuffix);
        // -4 设置缓存过期时间（毫秒）
        templateResolver.setCacheTTLMs(60000L);
        // -5 设置是否缓存
        templateResolver.setCacheable(true);
        // -6 设置服务器编码方式
        templateResolver.setCharacterEncoding("utf-8");
        
        //4.创建模板引擎对象
        templateEngine = new TemplateEngine();
        
        //5.给模板引擎对象设置模板解析器
        templateEngine.setTemplateResolver(templateResolver);
    }
    
    /**
     * 处理模板数据
     * @param templateName
     * @param request
     * @param response
     * @throws IOException
     */
    protected void processTemplate(String templateName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.设置响应体内容类型和字符集
        response.setContentType("text/html;charset=UTF-8");
        
        //2.创建WebContext对象
        WebContext webContext = new WebContext(request, response, getServletContext());
        
        //3.处理模板数据
        templateEngine.process(templateName, webContext, response.getWriter());
        
    }
}
