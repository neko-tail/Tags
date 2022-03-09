package com.master.myssm.myspringmvc;

/**
 * 自定义的中央管理器异常
 * @author master
 */
public class DispatcherServletException extends RuntimeException {
    public DispatcherServletException(String msg) {
        super(msg);
    }
}
