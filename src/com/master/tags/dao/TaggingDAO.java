package com.master.tags.dao;

import com.master.tags.pojo.Tagging;

import java.util.List;

public interface TaggingDAO {
    public int insert(Tagging tagging);
    
    public int update(Tagging tagging);
    
    public int delete(Tagging tagging);
    
    public int deleteById(Long id);
    
    public Tagging selectOneById(Long id);
    
    public List<Tagging> selectList();
    
    public List<Tagging> selectListByProjectId(Long projectId);
    
    public List<Tagging> selectListByTagId(Long tagId);
    
    public List<Tagging> selectListByIsLive(Boolean isLive);
}
