package com.master.myssm.basedao;


import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * 这是一个基础DAO类，用于将连接数据库和进行查询等功能从其他DAO中剥离
 * @author master
 *
 */
public class BaseDAO<T> {
    /**
     * 数据库相关
     */
    protected Connection conn;
    protected PreparedStatement ps;
    protected ResultSet rs;

    /**
     * 泛型T的实体类对象
     */
    private Class entityClass;
    
    /**
     * 这里是BaseDAO的无参构造方法
     * 具体的DAOImpl类最终会调用这个方法
     */
    public BaseDAO() {
        //当创建 **DAOImpl 的实例时，会调用父级的无参构造方法，即当前 baseDAO() 方法
        //此时我们使用 getClass() 方法获取的是 **DAOImpl 的class
        //为了获取 BaseDAO 的class，我们使用 getGenericSuperclass() 方法
        Type genericType = getClass().getGenericSuperclass();
        //ParameterizedType 参数化类型
        Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
        //获取 <T> 中的真实类型
        Type actualType = actualTypeArguments[0];
    
        try {
            entityClass = Class.forName(actualType.getTypeName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            //这里将异常转化为我们自定义的异常来抛出
            throw new DAOException("BaseDAO 构造方法出错，可能是没有指定泛型<>中的类型");
        }
    }
    
    /**
     * 获取一个数据库连接
     * @return 数据库连接
     */
    protected Connection getConn() {
        return ConnUtil.getConn();
    }
    
    /**
     * 关闭数据库连接，现已停用
     * @param rs 即为 ResultSet
     * @param ps 即为 PreparedStatement
     * @param conn 即为 Connection
     */
    protected void close(ResultSet rs, PreparedStatement ps, Connection conn) {
    
    }
    
    /**
     * 给预处理命令对象设置参数
     * @param ps 即为 PreparedStatement
     * @param params 参数数组，用于存放替换SQL语句中问号的那些参数
     * @throws SQLException
     */
    private void setParams(PreparedStatement ps, Object... params) throws SQLException {
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1, params[i]);
            }
        }
    }
    
    /**
     * 执行更新语句，返回影响行数或执行插入语句，返回主键id
     * @param sql 要执行的SQL语句
     * @param params 要替换的参数数组
     * @return 受影响的行数 或 主键id
     */
    protected int executeUpdate(String sql, Object... params) {
        //是否为插入语句
        boolean insertFlag = false;
        insertFlag = sql.trim().toUpperCase(Locale.ROOT).startsWith("INSERT");
        //执行SQL语句
        conn = getConn();
        try {
            if (insertFlag) {
                //如果是插入语句，则使用 Statement.RETURN_GENERATED_KEYS 获取主键id
                ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            } else {
                ps = conn.prepareStatement(sql);
            }
            setParams(ps, params);
            //正常执行，返回影响行数
            int count = ps.executeUpdate();
            //如果为插入语句，则获取主键id并返回
            if (insertFlag) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return ((Long)rs.getLong(1)).intValue();
                }
            }
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("BaseDAO executeUpdate出错了");
        }
    }
    
    /**
     * 使用反射技术给对象的属性赋值
     * @param obj 要赋值的对象
     * @param property 对象的属性
     * @param propertyValue 属性的值
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private void setValue(Object obj, String property, Object propertyValue) throws NoSuchFieldException, IllegalAccessException {
        //获取对象的类
        Class clazz = obj.getClass();
        
        //通过属性的属性名来获取对象的对应属性，并进行赋值
        Field field = clazz.getDeclaredField(property);
        if (field != null) {
            //禁用安全检查
            field.setAccessible(true);
            field.set(obj, propertyValue);
        }
    }
    
    
    /**
     * 执行复杂查询，返回查询结果
     * @param sql sql语句
     * @param params 参数数组
     * @return 结果数组
     */
    protected Object[] executeComplexQuery(String sql, Object... params) {
        //执行SQL语句
        conn = getConn();
        try {
            ps = conn.prepareStatement(sql);
            setParams(ps, params);
            rs = ps.executeQuery();
            
            //通过rs获取结果集的元数据（即结果集的列名，类型等）
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取列数
            int columnCount = rsmd.getColumnCount();
            Object[] columnValueArr = new Object[columnCount];
            //解析rs
            if (rs.next()) {
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    columnValueArr[i] = columnValue;
                }
                return columnValueArr;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("BaseDAO executeComplexQuery出错了");
        }
    }
    
    /**
     * 执行查询，返回单个实体对象
     * @param sql SQL语句
     * @param params 参数数组
     * @return 单个实体对象
     */
    protected T load(String sql, Object... params) {
        conn = getConn();
        try {
            ps = conn.prepareStatement(sql);
            setParams(ps, params);
            rs = ps.executeQuery();
    
            //通过rs获取结果集的元数据（即结果集的列名，类型等）
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取列数
            int columnCount = rsmd.getColumnCount();
            Object[] columnValueArr = new Object[columnCount];
            //解析rs
            if (rs.next()) {
                //要返回的那个对象
                T entity = (T) entityClass.newInstance();
                //依次赋值
                for (int i = 0; i < columnCount; i++) {
                    String columnName = rsmd.getColumnName(i + 1);
                    Object columnValue = rs.getObject(i + 1);
                    setValue(entity, columnName, columnValue);
                }
                return entity;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("BaseDAO load出错了");
        }
        return null;
    }
    
    /**
     * 执行查询，返回实体对象list
     * @param sql SQL语句
     * @param params 参数数组
     * @return 实体对象list
     */
    protected List<T> executeQuery(String sql, Object... params) {
        //保存实体对象的list
        List<T> list = new ArrayList<>();
        conn = getConn();
        try {
            ps = conn.prepareStatement(sql);
            setParams(ps, params);
            rs = ps.executeQuery();
            
            //通过rs获取结果集的元数据（即结果集的列名，类型等）
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取列数
            int columnCount = rsmd.getColumnCount();
            Object[] columnValueArr = new Object[columnCount];
            //解析rs
            while (rs.next()) {
                //要返回的那个对象
                T entity = (T) entityClass.newInstance();
                //依次赋值
                for (int i = 0; i < columnCount; i++) {
                    String columnName = rsmd.getColumnName(i + 1);
                    Object columnValue = rs.getObject(i + 1);
                    setValue(entity, columnName, columnValue);
                }
                //由直接返回改为添加进list中
                list.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("BaseDAO executeQuery()出错了");
        }
        return list;
    }
}
