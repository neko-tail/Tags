package com.master.tags.dao;

import com.master.tags.pojo.UserDetail;

import java.util.List;

public interface UserDetailDAO {
    public int insert(UserDetail userDetail);
    
    public int update(UserDetail userDetail);
    
    public int delete(UserDetail userDetail);
    
    public int deleteById(Long id);
    
    public UserDetail selectOneById(Long id);
    
    public List<UserDetail> selectList();
    
    public List<UserDetail> selectListByGender(String gender);
}
