package com.master.tags.dao;

import com.master.tags.pojo.Admin;

import java.util.List;

/**
 * @author master
 */
public interface AdminDAO {
    
    /**
     * 向数据库中添加一个Admin
     * @param admin Admin对象
     * @return 修改行数
     */
    public int insert(Admin admin);
    
    /**
     * 修改admin
     * @param admin 新的Admin
     * @return 修改行数
     */
    public int update(Admin admin);
    
    /**
     * 删除admin
     * @param admin admin
     * @return 修改行数
     */
    public int delete(Admin admin);
    
    /**
     * 通过id来删除admin
     * @param id admin的id
     * @return 修改行数
     */
    public int deleteById(Long id);
    
    /**
     * 通过Admin的Id获取一个Admin对象
     * @param id Adminid
     * @return 一个Admin对象
     */
    public Admin selectOneById(Long id);
    
    /**
     * 通过用户名和密码的组合获取一个Admin对象
     * @param username 用户名
     * @param password 密码
     * @return 一个Admin对象
     */
    public Admin selectOneByLogin(String username, String password);
    
    /**
     * 获取所有Admin
     * @return 所有Admin
     */
    public List<Admin> selectList();
    
    /**
     * 通过权限id获取该权限Admin
     * @param powerId 权限id
     * @return 该权限Admin
     */
    public List<Admin> selectListByPowerId(Long powerId);
}
