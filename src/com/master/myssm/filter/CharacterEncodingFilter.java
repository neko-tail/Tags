package com.master.myssm.filter;


import com.master.myssm.util.StringUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
/**
 * 这个注解表示拦截所有以.do结尾的请求，并添加一个初始化参数encoding: UTF-8
 */
/**
 * 一个用于拦截所有请求的设置编码用的过滤器
 * @author master
 */
@WebFilter(urlPatterns = {"/"}, initParams = @WebInitParam(name = "encoding", value = "UTF-8"))
public class CharacterEncodingFilter implements Filter {
    
    private String encoding = "UTF-8";
    
    /**
     * 这是初始化方法
     * 如初始化参数中 encoding 的值不为空，则覆盖掉成员变量 encoding，确保初始化参数的高优先级
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String encodingStr = filterConfig.getInitParameter("encoding");
        if (!StringUtil.isEmpty(encodingStr)) {
            encoding = encodingStr;
        }
    }
    
    /**
     * 这是执行过滤方法
     * 在过滤之前，统一设置编码
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //设置编码
        ((HttpServletRequest) servletRequest).setCharacterEncoding(encoding);
        //执行过滤
        filterChain.doFilter(servletRequest, servletResponse);
    }
    
    /**
     * 这是关闭方法
     * 不做修改
     */
    @Override
    public void destroy() {
    
    }
}
