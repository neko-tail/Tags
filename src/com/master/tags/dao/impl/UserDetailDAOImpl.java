package com.master.tags.dao.impl;

import com.master.myssm.basedao.BaseDAO;
import com.master.tags.dao.UserDetailDAO;
import com.master.tags.pojo.User;
import com.master.tags.pojo.UserDetail;

import java.util.List;

public class UserDetailDAOImpl extends BaseDAO<UserDetail> implements UserDetailDAO {
    
    @Override
    public int insert(UserDetail userDetail) {
        String sql = "INSERT INTO t_user_detail(t_user_detail.id, t_user_detail.gender, t_user_detail.birthday) VALUES(?, ?, ?);";
        return super.executeUpdate(sql, userDetail.getId(), userDetail.getGender(), userDetail.getBirthday());
    }
    
    @Override
    public int update(UserDetail userDetail) {
        String sql = "UPDATE t_user_detail SET t_user_detail.gender = ?, t_user_detail.birthday = ? WHERE t_user_detail.id = ?;";
        return super.executeUpdate(sql, userDetail.getGender(), userDetail.getBirthday(), userDetail.getId());
    }
    
    @Override
    public int delete(UserDetail userDetail) {
        String sql = "DELETE FROM t_user_detail WHERE t_user_detail.id = ?;";
        return super.executeUpdate(sql, userDetail.getId());
    }
    
    @Override
    public int deleteById(Long id) {
        String sql = "DELETE FROM t_user_detail WHERE t_user_detail.id = ?;";
        return super.executeUpdate(sql, id);
    }
    
    @Override
    public UserDetail selectOneById(Long id) {
        String sql = "SELECT t_user_detail.id, t_user_detail.gender, t_user_detail.birthday FROM t_user_detail WHERE t_user_detail.id = ?;";
        return super.load(sql, id);
    }
    
    @Override
    public List<UserDetail> selectList() {
        String sql = "SELECT t_user_detail.id, t_user_detail.gender, t_user_detail.birthday FROM t_user_detail;";
        return super.executeQuery(sql);
    }
    
    @Override
    public List<UserDetail> selectListByGender(String gender) {
        String sql = "SELECT t_user_detail.id, t_user_detail.gender, t_user_detail.birthday FROM t_user_detail WHERE t_user_detail.gender = ?;";
        return super.executeQuery(sql, gender);
    }
}
