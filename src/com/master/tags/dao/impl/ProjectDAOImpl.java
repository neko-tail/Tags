package com.master.tags.dao.impl;

import com.master.myssm.basedao.BaseDAO;
import com.master.tags.dao.ProjectDAO;
import com.master.tags.pojo.Project;

import java.util.List;

public class ProjectDAOImpl extends BaseDAO<Project> implements ProjectDAO {
    @Override
    public int insert(Project project) {
        String sql = "INSERT INTO t_project(t_project.id, t_project.projectName, t_project.info, t_project.picture, t_project.ownerId, t_project" +
                ".parentId, t_project.createTime, t_project.likesCount, t_project.hitsCount) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
        return super.executeUpdate(sql, project.getId(), project.getProjectName(), project.getInfo(), project.getPicture(), project.getOwnerId(),
                project.getParentId(), project.getCreateTime(), project.getLikesCount(), project.getHitsCount());
    }
    
    @Override
    public int update(Project project) {
        String sql = "UPDATE t_project SET t_project.projectName = ?, t_project.info = ?, t_project.picture = ?, t_project.ownerId = ?, t_project" +
                ".parentId = ?, t_project.createTime = ?, t_project.likesCount = ?, t_project.hitsCount = ? WHERE t_project.id = ?;";
        return super.executeUpdate(sql, project.getProjectName(), project.getInfo(), project.getPicture(), project.getOwnerId(),
                project.getParentId(), project.getCreateTime(), project.getLikesCount(), project.getHitsCount(), project.getId());
    }
    
    @Override
    public int delete(Project project) {
        String sql = "DELETE FROM t_project WHERE t_project.id = ?;";
        return super.executeUpdate(sql, project.getId());
    }
    
    @Override
    public int deleteById(Long id) {
        String sql = "DELETE FROM t_project WHERE t_project.id = ?;";
        return super.executeUpdate(sql, id);
    }
    
    @Override
    public Project selectOneById(Long id) {
        String sql = "SELECT t_project.id, t_project.projectName, t_project.info, t_project.picture, t_project.ownerId, t_project" +
                ".parentId, t_project.createTime, t_project.likesCount, t_project.hitsCount FROM t_project WHERE t_project.id = ?;";
        return super.load(sql, id);
    }
    
    @Override
    public List<Project> selectList() {
        String sql = "SELECT t_project.id, t_project.projectName, t_project.info, t_project.picture, t_project.ownerId, t_project" +
                ".parentId, t_project.createTime, t_project.likesCount, t_project.hitsCount FROM t_project;";
        return super.executeQuery(sql);
    }
    
    @Override
    public List<Project> selectListByOwnerId(Long ownerId) {
        String sql = "SELECT t_project.id, t_project.projectName, t_project.info, t_project.picture, t_project.ownerId, t_project" +
                ".parentId, t_project.createTime, t_project.likesCount, t_project.hitsCount FROM t_project WHERE t_project.ownerId = ?;";
        return super.executeQuery(sql, ownerId);
    }
    
    @Override
    public List<Project> selectListByParentId(Long parentId) {
        String sql = "SELECT t_project.id, t_project.projectName, t_project.info, t_project.picture, t_project.ownerId, t_project" +
                ".parentId, t_project.createTime, t_project.likesCount, t_project.hitsCount FROM t_project WHERE t_project.parentId = ?;";
        return super.executeQuery(sql, parentId);
    }
    
    @Override
    public List<Project> selectListByProjectNameLike(String projectName) {
        String sql = "SELECT t_project.id, t_project.projectName, t_project.info, t_project.picture, t_project.ownerId, t_project" +
                ".parentId, t_project.createTime, t_project.likesCount, t_project.hitsCount FROM t_project WHERE t_project.projectName = ?;";
        return super.executeQuery(sql, projectName);
    }
}
