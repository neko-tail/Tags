package com.master.tags.dao;

import com.master.tags.pojo.User;

import java.util.List;

public interface UserDAO {
    public int insert(User user);
    
    public int update(User user);
    
    public int delete(User user);
    
    public int deleteById(Long id);
    
    public User selectOneById(Long id);
    
    public User selectOneByUsername(String username);
    
    public User selectOneByLogin(String username, String password);
    
    public List<User> selectList();
    
    public List<User> selectListByNickname(String nickname);
    
    public List<User> selectListByGroupId(Long groupId);
    
    public List<User> selectListByEmail(String email);
}
