package com.master.tags.dao;

import com.master.tags.pojo.Tag;

import java.util.List;

public interface TagDAO {
    public int insert(Tag tag);
    
    public int update(Tag tag);
    
    public int delete(Tag tag);
    
    public int deleteById(Long id);
    
    public Tag selectOneById(Long id);
    
    public List<Tag> selectList();
    
    public List<Tag> selectListByVisible(Boolean visible);
    
    public List<Tag> selectListByAvailable(Boolean available);
    
    public List<Tag> selectListByTagNameLike(String tagName);
}
