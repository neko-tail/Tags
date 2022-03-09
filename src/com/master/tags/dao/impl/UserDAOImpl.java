package com.master.tags.dao.impl;

import com.master.myssm.basedao.BaseDAO;
import com.master.tags.dao.UserDAO;
import com.master.tags.pojo.User;

import java.util.List;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {
    @Override
    public int insert(User user) {
        String sql = "INSERT INTO t_user(t_user.id, t_user.username, t_user.`password`, t_user.email, t_user.nickname, t_user.avatar, t_user" +
                ".createTime) VALUES(?, ?, ?, ?, ?, ?, ?);";
        return super.executeUpdate(sql, user.getId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getNickname(), user.getAvatar()
                , user.getCreateTime());
    }
    
    @Override
    public int update(User user) {
        String sql = "UPDATE t_user SET t_user.username = ?, t_user.`password` = ?, t_user.email = ?, t_user.nickname = ?, t_user" +
                ".avatar = ?, t_user.createTime = ? WHERE t_user.id = ?;";
        return super.executeUpdate(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getNickname(), user.getAvatar()
                , user.getCreateTime(), user.getId());
    }
    
    @Override
    public int delete(User user) {
        String sql = "DELETE FROM t_user WHERE t_user.id = ?;";
        return super.executeUpdate(sql, user.getId());
    }
    
    @Override
    public int deleteById(Long id) {
        String sql = "DELETE FROM t_user WHERE t_user.id = ?;";
        return super.executeUpdate(sql, id);
    }
    
    @Override
    public User selectOneById(Long id) {
        String sql = "SELECT t_user.id, t_user.username, t_user.`password`, t_user.email, t_user.nickname, t_user.avatar, t_user" +
                ".createTime FROM t_user WHERE t_user.id = ?;";
        return super.load(sql, id);
    }
    
    @Override
    public User selectOneByUsername(String username) {
        String sql = "SELECT t_user.id, t_user.username, t_user.`password`, t_user.email, t_user.nickname, t_user.avatar, t_user" +
                ".createTime FROM t_user WHERE t_user.username = ?;";
        return super.load(sql, username);
    }
    
    @Override
    public User selectOneByLogin(String username, String password) {
        String sql = "SELECT t_user.id, t_user.username, t_user.`password`, t_user.email, t_user.nickname, t_user.avatar, t_user" +
                ".createTime FROM t_user WHERE t_user.username = ? AND t_user.password = ?;";
        return super.load(sql, username, password);
    }
    
    @Override
    public List<User> selectList() {
        String sql = "SELECT t_user.id, t_user.username, t_user.`password`, t_user.email, t_user.nickname, t_user.avatar, t_user" +
                ".createTime FROM t_user;";
        return super.executeQuery(sql);
    }
    
    @Override
    public List<User> selectListByNickname(String nickname) {
        String sql = "SELECT t_user.id, t_user.username, t_user.`password`, t_user.email, t_user.nickname, t_user.avatar, t_user" +
                ".createTime FROM t_user WHERE t_user.nickname = ?;";
        return super.executeQuery(sql, nickname);
    }
    
    @Override
    public List<User> selectListByGroupId(Long groupId) {
        String sql = "SELECT t_user.id, t_user.username, t_user.`password`, t_user.email, t_user.nickname, t_user.avatar, t_user" +
                ".createTime FROM t_user WHERE t_user.groupId = ?;";
        return super.executeQuery(sql, groupId);
    }
    
    @Override
    public List<User> selectListByEmail(String email) {
        String sql = "SELECT t_user.id, t_user.username, t_user.`password`, t_user.email, t_user.nickname, t_user.avatar, t_user" +
                ".createTime FROM t_user WHERE t_user.email = ?;";
        return super.executeQuery(sql, email);
    }
}
