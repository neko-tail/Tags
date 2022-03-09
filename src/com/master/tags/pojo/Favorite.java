package com.master.tags.pojo;

public class Favorite {
    private Long id;
    private Long userId;
    private Long projectId;
    
    public Favorite() {
    }
    
    public Favorite(Long id, Long userId, Long projectId) {
        this.id = id;
        this.userId = userId;
        this.projectId = projectId;
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
    
    public Long getProjectId() {
        return projectId;
    }
    
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
    
    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", userId=" + userId +
                ", projectId=" + projectId +
                '}';
    }
}
