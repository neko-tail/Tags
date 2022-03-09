package com.master.tags.dao.impl;

import com.master.myssm.basedao.BaseDAO;
import com.master.tags.dao.CommentDAO;
import com.master.tags.pojo.Comment;

import java.util.List;

public class CommentDAOImpl extends BaseDAO<Comment> implements CommentDAO {
    @Override
    public int insert(Comment comment) {
        String sql = "INSERT INTO t_comment(t_comment.id, t_comment.userId, t_comment.content, t_comment.projectId, t_comment.parentId, t_comment" +
                ".createTime) VALUES(?, ?, ?, ?, ?, ?);";
        return super.executeUpdate(sql, comment.getId(), comment.getUserId(), comment.getContent(), comment.getProjectId(), comment.getParentId(),
                comment.getCreateTime());
    }
    
    @Override
    public int update(Comment comment) {
        String sql = "UPDATE t_comment SET t_comment.userId = ?, t_comment.content = ?, t_comment.projectId = ?, t_comment" +
                ".parentId = ?, t_comment.createTime = ? WHERE  t_comment.id = ?;";
        return super.executeUpdate(sql, comment.getUserId(), comment.getContent(), comment.getProjectId(), comment.getParentId(),
                comment.getCreateTime(), comment.getId());
    }
    
    @Override
    public int delete(Comment comment) {
        String sql = "DELETE FROM t_comment WHERE t_comment.id = ?;";
        return super.executeUpdate(sql, comment.getId());
    }
    
    @Override
    public int deleteById(Long id) {
        String sql = "DELETE FROM t_comment WHERE t_comment.id = ?;";
        return super.executeUpdate(sql, id);
    }
    
    @Override
    public Comment selectOneById(Long id) {
        String sql = "SELECT t_comment.id, t_comment.userId, t_comment.content, t_comment.projectId, t_comment.parentId, t_comment" +
                ".createTime FROM t_comment WHERE t_comment.id = ?;";
        return super.load(sql, id);
    }
    
    @Override
    public List<Comment> selectList() {
        String sql = "SELECT t_comment.id, t_comment.userId, t_comment.content, t_comment.projectId, t_comment.parentId, t_comment" +
                ".createTime FROM t_comment;";
        return super.executeQuery(sql);
    }
    
    @Override
    public List<Comment> selectListByUserId(Long userId) {
        String sql = "SELECT t_comment.id, t_comment.userId, t_comment.content, t_comment.projectId, t_comment.parentId, t_comment" +
                ".createTime FROM t_comment WHERE t_comment.userId = ?;";
        return super.executeQuery(sql, userId);
    }
    
    @Override
    public List<Comment> selectListByParentId(Long parentId) {
        String sql = "SELECT t_comment.id, t_comment.userId, t_comment.content, t_comment.projectId, t_comment.parentId, t_comment" +
                ".createTime FROM t_comment WHERE t_comment.parentId = ?;";
        return super.executeQuery(sql, parentId);
    }
    
    @Override
    public List<Comment> selectListByProjectId(Long projectId) {
        String sql = "SELECT t_comment.id, t_comment.userId, t_comment.content, t_comment.projectId, t_comment.parentId, t_comment" +
                ".createTime FROM t_comment WHERE t_comment.projectId = ?;";
        return super.executeQuery(sql, projectId);
    }
    
    @Override
    public List<Comment> selectListByContentLike(String word) {
        String sql = "SELECT t_comment.id, t_comment.userId, t_comment.content, t_comment.projectId, t_comment.parentId, t_comment" +
                ".createTime FROM t_comment WHERE t_comment.content LIKE ?;";
        return super.executeQuery(sql, "%" + word + "%");
    }
}
