package com.master.tags.dao;

import com.master.tags.pojo.Comment;

import java.util.List;

public interface CommentDAO {
    
    /**
     * 向数据库中添加一个Comment
     * @param comment Comment对象
     * @return 修改行数
     */
    public int insert(Comment comment);
    
    /**
     * 修改comment
     * @param comment 新的Comment
     * @return 修改行数
     */
    public int update(Comment comment);
    
    /**
     * 删除comment
     * @param comment comment
     * @return 修改行数
     */
    public int delete(Comment comment);
    
    /**
     * 通过id来删除comment
     * @param id comment的id
     * @return 修改行数
     */
    public int deleteById(Long id);
    
    /**
     * 通过Comment的Id获取一个Comment对象
     * @param id Commentid
     * @return 一个Comment对象
     */
    public Comment selectOneById(Long id);
    
    /**
     * 获取所有Comment
     * @return 所有Comment
     */
    public List<Comment> selectList();
    
    
    /**
     * 通过用户id来获取评论列表
     * @param userId 用户id
     * @return 评论列表
     */
    public List<Comment> selectListByUserId(Long userId);
    
    
    /**
     * 通过父级评论id来获取评论列表
     * @param parentId 父级评论id
     * @return 评论列表
     */
    public List<Comment> selectListByParentId(Long parentId);
    
    
    /**
     * 获取对应评论列表
     * @param projectId 项目id
     * @return 评论列表
     */
    public List<Comment> selectListByProjectId(Long projectId);
    
    /**
     * 根据词语查找相关评论
     * @param word 词语
     * @return 评论列表
     */
    public List<Comment> selectListByContentLike(String word);
}
