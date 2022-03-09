package com.master.tags.dao;

import com.master.myssm.basedao.BaseDAO;
import com.master.tags.pojo.Admin;
import com.master.tags.pojo.AdminPower;

import java.util.List;

/**
 * @author master
 */
public interface AdminPowerDAO {
    /**
     * 插入新的一条记录
     * @param adminPower adminPower对象
     * @return 修改行数
     */
    public int insert(AdminPower adminPower);
    
    /**
     * 修改一条记录
     * @param adminPower adminPower对象
     * @return 修改行数
     */
    public int update(AdminPower adminPower);
    
    /**
     * AdminPower
     * @param adminPower adminPower
     * @return 修改行数
     */
    public int delete(AdminPower adminPower);
    
    /**
     * 通过id删除一条记录
     * @param id adminPower的id
     * @return 修改行数
     */
    public int deleteById(Long id);
    
    /**
     * 通过id获取一个对象
     * @param id id
     * @return 一个adminpower对象
     */
    public AdminPower selectOneById(Long id);
    
    /**
     * 通过name获取一个对象
     * @param name name
     * @return 一个adminpower对象
     */
    public AdminPower selectOneByName(String name);
    
    /**
     * 获取所有的对象组成的list
     * @return 所有的adminPower对象的list
     */
    public List<AdminPower> selectList();
}
