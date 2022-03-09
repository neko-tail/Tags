package com.master.myssm.basedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 这里是数据库连接工具类，将和数据库连接有关的代码从 BaseDAO 中抽取
 * @author master
 */
public class ConnUtil {
    private  static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/tags_db?useUnicode=true&characterEncoding=UTF8&useSSL=false";
    public static final String USER = "root";
    public static final String PWD = "master";
    
    /**
     * 生成一个数据库连接
     * 加载驱动，并使用驱动管理器生成数据库连接，使用类中定义好的成员变量
     * @return 一个数据库连接
     */
    private static Connection createConn() {
        try {
            //加载驱动
            Class.forName(DRIVER);
            //通过驱动管理器获取连接对象
            return DriverManager.getConnection(URL, USER, PWD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 获取一个数据库连接
     * 确保 threadLocal 中存在数据库连接，如不存在就使用 createConn 方法获取一个并放入 threadLocal
     * @return threadLocal中保存的数据库连接
     */
    public static Connection getConn() {
        Connection conn = threadLocal.get();
        if (conn == null) {
            conn = createConn();
            threadLocal.set(conn);
        }
        return threadLocal.get();
    }
    
    /**
     * 关闭数据库连接
     * 关闭后确保 threadLocal 中保存置为 null
     * @throws SQLException
     */
    public static void closeConn() throws SQLException {
        Connection conn = threadLocal.get();
        if (conn == null) {
            return;
        }
        if (!conn.isClosed()) {
            conn.close();
            threadLocal.set(null);
        }
    }
}
