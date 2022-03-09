package com.master.myssm.basedao;

/**
 * 这是一个自定义的DAO异常类
 * 将DAO相关代码运行时产生的各种异常转换为自定义异常抛出，方便后续处理
 * @author master
 */
public class DAOException extends RuntimeException{
    public DAOException(String msg) {
        super(msg);
    }
}
