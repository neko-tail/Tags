package com.master.tags.dao.impl;

import com.master.myssm.basedao.BaseDAO;
import com.master.tags.dao.AdminDAO;
import com.master.tags.pojo.Admin;

import java.util.List;

/**
 * @author master
 */
public class AdminDAOImpl extends BaseDAO<Admin> implements AdminDAO {
    @Override
    public int insert(Admin admin) {
        String sql = "INSERT INTO t_admin(t_admin.id, t_admin.username, t_admin.`password`, t_admin.powerId) VALUES(?, ?, ?, ?);";
        return super.executeUpdate(sql, null, admin.getUsername(), admin.getPassword(), admin.getPowerId());
    }
    
    @Override
    public int update(Admin admin) {
        String sql = "UPDATE t_admin SET t_admin.username = ?, t_admin.`password` = ?, t_admin.powerId = ? WHERE t_admin.id = ?;";
        return super.executeUpdate(sql, admin.getUsername(), admin.getPassword(), admin.getPowerId(), admin.getId());
    }
    
    @Override
    public int delete(Admin admin) {
        String sql = "DELETE FROM t_admin WHERE t_admin.id = ?;";
        return super.executeUpdate(sql, admin.getId());
    }
    
    @Override
    public int deleteById(Long id) {
        String sql = "DELETE FROM t_admin WHERE t_admin.id = ?;";
        return super.executeUpdate(sql, id);
    }
    
    @Override
    public Admin selectOneById(Long id) {
        String sql = "SELECT * FROM t_admin WHERE t_admin.id = ?;";
        return super.load(sql, id);
    }
    
    @Override
    public Admin selectOneByLogin(String username, String password) {
        String sql = "SELECT * FROM t_admin WHERE t_admin.username = ? AND t_admin.`password` = ?;";
        return super.load(sql, username, password);
    }
    
    
    @Override
    public List<Admin> selectList() {
        String sql = "SELECT * FROM t_admin;";
        return super.executeQuery(sql);
    }
    
    @Override
    public List<Admin> selectListByPowerId(Long powerId) {
        String sql = "SELECT * FROM t_admin WHERE t_admin.powerId = ?;";
        return super.executeQuery(sql, powerId);
    }
}
