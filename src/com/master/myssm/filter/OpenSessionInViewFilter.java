package com.master.myssm.filter;

import com.master.myssm.trans.TransactionManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 进行数据库事务管理的过滤器
 * 对经过的每一次请求都能进行事务管理
 * @author master
 */
@WebFilter("/")
public class OpenSessionInViewFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    
    }
    
    
    /**
     * 进行事务管理
     * 确保当发生错误时，能够对所有数据库操作进行回滚
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            //开启事务
            TransactionManager.beginTrans();
            //过滤
            filterChain.doFilter(servletRequest, servletResponse);
            //如一切正常，提交事务
            TransactionManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //当发生报错时，回滚事务
                // 这样可以确保无论是哪一个地方出了问题，都能全部回滚
                TransactionManager.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void destroy() {
    
    }
}
