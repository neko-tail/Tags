package com.master.myssm.trans;

import com.master.myssm.basedao.ConnUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库事务管理类
 * 用于将数据库的事务管理应用到 service 层，并将具体方法从中抽取出来
 * @author master
 */
public class TransactionManager {
    
    /**
     * 开启事务
     * 将数据库连接的自动提交关闭
     * @throws SQLException
     */
    public static void beginTrans() throws SQLException {
        ConnUtil.getConn().setAutoCommit(false);
    }
    
    /**
     * 提交事务
     * 执行数据库连接的提交方法，提交后关闭数据库连接
     * @throws SQLException
     */
    public static void commit() throws SQLException {
        Connection conn = ConnUtil.getConn();
        conn.commit();
        ConnUtil.closeConn();
    }
    
    /**
     * 回滚事务
     * 执行数据库连接的回滚方法，提交后关闭数据库连接
     * @throws SQLException
     */
    public static void rollback() throws SQLException {
        Connection conn = ConnUtil.getConn();
        conn.rollback();
        ConnUtil.closeConn();
    }
}
