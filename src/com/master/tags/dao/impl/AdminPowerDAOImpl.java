package com.master.tags.dao.impl;

import com.master.myssm.basedao.BaseDAO;
import com.master.tags.dao.AdminPowerDAO;
import com.master.tags.pojo.AdminPower;

import java.util.List;

public class AdminPowerDAOImpl extends BaseDAO<AdminPower> implements AdminPowerDAO {
    
    @Override
    public int insert(AdminPower adminPower) {
        String sql = "INSERT INTO t_admin_power(t_admin_power.id, t_admin_power.`name`, t_admin_power" +
                ".isProjectManager, t_admin_power.isTagManager, t_admin_power.isUserManager, t_admin_power" +
                ".isAnnouncementManager) VALUES(?, ?, ?, ?, ?, ?);";
        return super.executeUpdate(sql, null, adminPower.getName(), adminPower.isProjectManager(),
                adminPower.isTagManager(), adminPower.isUserManager(), adminPower.isAnnouncementManager());
    }
    
    @Override
    public int update(AdminPower adminPower) {
        String sql = "UPDATE t_admin_power SET t_admin_power.`name` = ?, t_admin_power.isProjectManager = ?, " +
                "t_admin_power.isTagManager = ?, t_admin_power.isUserManager = ?, t_admin_power.isAnnouncementManager" +
                " = ? WHERE t_admin_power.id = ?;";
        return super.executeUpdate(sql, adminPower.getName(), adminPower.isProjectManager(),
                adminPower.isTagManager(), adminPower.isUserManager(), adminPower.isAnnouncementManager(),
                adminPower.getId());
    }
    
    @Override
    public int delete(AdminPower adminPower) {
        String sql = "DELETE FROM t_admin_power WHERE t_admin_power.id = ?;";
        return super.executeUpdate(sql, adminPower.getId());
    }
    
    @Override
    public int deleteById(Long id) {
        String sql = "DELETE FROM t_admin_power WHERE t_admin_power.id = ?;";
        return super.executeUpdate(sql, id);
    }
    
    @Override
    public AdminPower selectOneById(Long id) {
        String sql = "SELECT t_admin_power.id, t_admin_power.`name`, t_admin_power.isProjectManager, t_admin_power.isTagManager, t_admin_power" +
                ".isUserManager, t_admin_power.isAnnouncementManager FROM t_admin_power WHERE t_admin_power.id = ?;";
        return super.load(sql, id);
    }
    
    @Override
    public AdminPower selectOneByName(String name) {
        String sql = "SELECT t_admin_power.id, t_admin_power.`name`, t_admin_power.isProjectManager, t_admin_power.isTagManager, t_admin_power" +
                ".isUserManager, t_admin_power.isAnnouncementManager FROM t_admin_power WHERE t_admin_power.`name` = ?;";
        return super.load(sql, name);
    }
    
    @Override
    public List<AdminPower> selectList() {
        String sql = "SELECT t_admin_power.id, t_admin_power.`name`, t_admin_power.isProjectManager, t_admin_power.isTagManager, t_admin_power" +
                ".isUserManager, t_admin_power.isAnnouncementManager FROM t_admin_power;";
        return super.executeQuery(sql);
    }
}
