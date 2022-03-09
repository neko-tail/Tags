package com.master.tags.dao.impl;

import com.master.myssm.basedao.BaseDAO;
import com.master.tags.dao.TaggingDAO;
import com.master.tags.pojo.Tagging;

import java.util.List;

public class TaggingDAOImpl extends BaseDAO<Tagging> implements TaggingDAO {
    @Override
    public int insert(Tagging tagging) {
        String sql = "INSERT INTO t_tagging(t_tagging.id, t_tagging.projectId, t_tagging.tagId, t_tagging.isLive, t_tagging.likesCount, t_tagging" +
                ".disLikesCount) VALUES(?, ?, ?, ?, ?, ?);";
        return super.executeUpdate(sql, tagging.getId(), tagging.getProjectId(), tagging.getTagId(), tagging.getLive(), tagging.getLikesCount(),
                tagging.getDisLikesCount());
    }
    
    @Override
    public int update(Tagging tagging) {
        String sql = "UPDATE t_tagging SET t_tagging.projectId = ?, t_tagging.tagId = ?, t_tagging.isLive = ?, t_tagging" +
                ".likesCount = ?, t_tagging.disLikesCount = ? WHERE t_tagging.id = ?;";
        return super.executeUpdate(sql, tagging.getProjectId(), tagging.getTagId(), tagging.getLive(), tagging.getLikesCount(),
                tagging.getDisLikesCount(), tagging.getId());
    }
    
    @Override
    public int delete(Tagging tagging) {
        String sql = "DELETE FROM t_tagging WHERE t_tagging.id = ?;";
        return super.executeUpdate(sql, tagging.getId());
    }
    
    @Override
    public int deleteById(Long id) {
        String sql = "DELETE FROM t_tagging WHERE t_tagging.id = ?;";
        return super.executeUpdate(sql, id);
    }
    
    @Override
    public Tagging selectOneById(Long id) {
        String sql = "SELECT t_tagging.projectId, t_tagging.tagId, t_tagging.isLive, t_tagging.likesCount, t_tagging.disLikesCount FROM t_tagging WHERE " +
                "t_tagging.id = ?;";
        return super.load(sql, id);
    }
    
    @Override
    public List<Tagging> selectList() {
        String sql = "SELECT t_tagging.projectId, t_tagging.tagId, t_tagging.isLive, t_tagging.likesCount, t_tagging.disLikesCount FROM t_tagging;";
        return super.executeQuery(sql);
    }
    
    @Override
    public List<Tagging> selectListByProjectId(Long projectId) {
        String sql = "SELECT t_tagging.projectId, t_tagging.tagId, t_tagging.isLive, t_tagging.likesCount, t_tagging.disLikesCount FROM t_tagging WHERE " +
                "t_tagging.projectId = ?;";
        return super.executeQuery(sql, projectId);
    }
    
    @Override
    public List<Tagging> selectListByTagId(Long tagId) {
        String sql = "SELECT t_tagging.projectId, t_tagging.tagId, t_tagging.isLive, t_tagging.likesCount, t_tagging.disLikesCount FROM t_tagging WHERE " +
                "t_tagging.tagId = ?;";
        return super.executeQuery(sql, tagId);
    }
    
    @Override
    public List<Tagging> selectListByIsLive(Boolean isLive) {
        String sql = "SELECT t_tagging.projectId, t_tagging.tagId, t_tagging.isLive, t_tagging.likesCount, t_tagging.disLikesCount FROM t_tagging WHERE " +
                "t_tagging.isLive = ?;";
        return super.executeQuery(sql, isLive);
    }
}
