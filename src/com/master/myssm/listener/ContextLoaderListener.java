package com.master.myssm.listener;


import com.master.myssm.ioc.BeanFactory;
import com.master.myssm.ioc.ClassPathXmlApplicationContext;
import com.master.myssm.ioc.UrlAddress;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 上下文 装载 监听器
 * 监听上下文启动，在上下文启动时创建IOC容器，然后保存到application作用域中
 * 后面中央控制器再从application作用域中获取IOC容器
 * @author master
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    /**
     * 上下文启动时
     * 创建一个IOC容器，并保存进application作用域
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //获取上下文对象
        ServletContext application = servletContextEvent.getServletContext();
        //获取上下文的初始化参数
        String path = application.getInitParameter("contextConfigLocation");
        //创建IOC容器 通过上文获取到的参数
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(path);
        String urlAdressPath = application.getInitParameter("urlAdressPath");
        UrlAddress urlAddress = new UrlAddress(urlAdressPath);
        //将IOC容器保存到application作用域中
        application.setAttribute("beanFactory", beanFactory);
        application.setAttribute("urlAddress", urlAddress);
    }
    
    /**
     * 上下文关闭时
     * 什么都不做
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    
    }
}
