package com.master.tags.dao;


import com.master.tags.pojo.Project;

import java.util.List;

public interface ProjectDAO {
    public int insert(Project project);
    
    public int update(Project project);
    
    public int delete(Project project);
    
    public int deleteById(Long id);
    
    public Project selectOneById(Long id);
    
    public List<Project> selectList();
    
    public List<Project> selectListByOwnerId(Long ownerId);
    
    public List<Project> selectListByParentId(Long parentId);
    
    public List<Project> selectListByProjectNameLike(String projectName);
}
