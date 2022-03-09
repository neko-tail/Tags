package com.master.tags.dao;

import com.master.tags.pojo.Favorite;

import java.util.List;

public interface FavoriteDAO {
    public int insert(Favorite favorite);
    
    public int update(Favorite favorite);
    
    public int delete(Favorite favorite);
    
    public int deleteById(Long id);
    
    public Favorite selectOneById(Long id);
    
    public List<Favorite> selectList();
    
    public List<Favorite> selectListByUserId(Long userId);
    
    public List<Favorite> selectListByProjectId(Long projectId);
}
