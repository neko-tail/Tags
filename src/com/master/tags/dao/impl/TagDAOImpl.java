package com.master.tags.dao.impl;

import com.master.myssm.basedao.BaseDAO;
import com.master.tags.dao.TagDAO;
import com.master.tags.pojo.Tag;

import java.util.List;

public class TagDAOImpl extends BaseDAO<Tag> implements TagDAO {
    @Override
    public int insert(Tag tag) {
        String sql = "INSERT INTO t_tag(t_tag.id, t_tag.tagName, t_tag.visible, t_tag.available) VALUES(?, ?, ?, ?);";
        return super.executeUpdate(sql, tag.getId(), tag.getTagName(), tag.isVisible(), tag.isAvailable());
    }
    
    @Override
    public int update(Tag tag) {
        String sql = "UPDATE t_tag SET t_tag.tagName = ?, t_tag.visible = ?, t_tag.available = ? WHERE t_tag.id = ?;";
        return super.executeUpdate(sql, tag.getTagName(), tag.isVisible(), tag.isAvailable(), tag.getId());
    }
    
    @Override
    public int delete(Tag tag) {
        String sql = "DELETE FROM t_tag WHERE t_tag.id = ?;";
        return super.executeUpdate(sql, tag.getId());
    }
    
    @Override
    public int deleteById(Long id) {
        String sql = "DELETE FROM t_tag WHERE t_tag.id = ?;";
        return super.executeUpdate(sql, id);
    }
    
    @Override
    public Tag selectOneById(Long id) {
        String sql = "SELECT t_tag.id, t_tag.tagName, t_tag.visible, t_tag.available FROM t_tag WHERE t_tag.id = ?;";
        return super.load(sql, id);
    }
    
    @Override
    public List<Tag> selectList() {
        String sql = "SELECT t_tag.id, t_tag.tagName, t_tag.visible, t_tag.available FROM t_tag;";
        return super.executeQuery(sql);
    }
    
    @Override
    public List<Tag> selectListByVisible(Boolean visible) {
        String sql = "SELECT t_tag.id, t_tag.tagName, t_tag.visible, t_tag.available FROM t_tag WHERE t_tag.visible = ?;";
        return super.executeQuery(sql, visible);
    }
    
    @Override
    public List<Tag> selectListByAvailable(Boolean available) {
        String sql = "SELECT t_tag.id, t_tag.tagName, t_tag.visible, t_tag.available FROM t_tag WHERE t_tag.available = ?;";
        return super.executeQuery(sql, available);
    }
    
    @Override
    public List<Tag> selectListByTagNameLike(String tagName) {
        String sql = "SELECT t_tag.id, t_tag.tagName, t_tag.visible, t_tag.available FROM t_tag WHERE t_tag.tagName LIKE ?;";
        return super.executeQuery(sql, "%"+tagName+"%");
    }
}
