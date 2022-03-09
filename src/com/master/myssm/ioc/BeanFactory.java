package com.master.myssm.ioc;

/**
 * bean工厂接口
 * @author master
 */
public interface BeanFactory {
    /**
     * 通过id获取一个bean对象
     * @param id bean的id
     * @return 一个bean对象
     */
    Object getBean(String id);
}
