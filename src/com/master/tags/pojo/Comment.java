package com.master.tags.pojo;

import java.util.Date;

/**
 * @author master
 */
public class Comment {
    private Long id;
    private Long userId;
    private String content;
    private Long projectId;
    private Long parentId;
    private Date createTime;
    
    public Comment() {
    }
    
    public Comment(Long id, Long userId, String content, Long projectId, Long parentId, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.projectId = projectId;
        this.parentId = parentId;
        this.createTime = createTime;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public Long getProjectId() {
        return projectId;
    }
    
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
    
    public Long getParentId() {
        return parentId;
    }
    
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", projectId=" + projectId +
                ", parentId=" + parentId +
                ", createTime=" + createTime +
                '}';
    }
}
