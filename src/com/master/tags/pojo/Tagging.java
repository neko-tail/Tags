package com.master.tags.pojo;

public class Tagging {
    private Long id;
    private Long projectId;
    private Long tagId;
    private Boolean isLive;
    private Integer likesCount;
    private Integer disLikesCount;
    
    public Tagging() {
    }
    
    public Tagging(Long id, Long projectId, Long tagId, Boolean isLive, Integer likesCount, Integer disLikesCount) {
        this.id = id;
        this.projectId = projectId;
        this.tagId = tagId;
        this.isLive = isLive;
        this.likesCount = likesCount;
        this.disLikesCount = disLikesCount;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getProjectId() {
        return projectId;
    }
    
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
    
    public Long getTagId() {
        return tagId;
    }
    
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
    
    public Boolean getLive() {
        return isLive;
    }
    
    public void setLive(Boolean live) {
        isLive = live;
    }
    
    public Integer getLikesCount() {
        return likesCount;
    }
    
    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }
    
    public Integer getDisLikesCount() {
        return disLikesCount;
    }
    
    public void setDisLikesCount(Integer disLikesCount) {
        this.disLikesCount = disLikesCount;
    }
    
    @Override
    public String toString() {
        return "Tagging{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", tagId=" + tagId +
                ", isLive=" + isLive +
                ", likesCount=" + likesCount +
                ", disLikesCount=" + disLikesCount +
                '}';
    }
}
