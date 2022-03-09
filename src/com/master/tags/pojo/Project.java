package com.master.tags.pojo;

import java.util.Date;

public class Project {
    private Long id;
    private String projectName;
    private String info;
    private String picture;
    private Long ownerId;
    private Long parentId;
    private Date createTime;
    private Integer likesCount;
    private Integer hitsCount;
    
    public Project() {
    }
    
    public Project(Long id, String projectName, String info, String picture, Long ownerId, Long parentId, Date createTime, Integer likesCount, Integer hitsCount) {
        this.id = id;
        this.projectName = projectName;
        this.info = info;
        this.picture = picture;
        this.ownerId = ownerId;
        this.parentId = parentId;
        this.createTime = createTime;
        this.likesCount = likesCount;
        this.hitsCount = hitsCount;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getProjectName() {
        return projectName;
    }
    
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    public String getInfo() {
        return info;
    }
    
    public void setInfo(String info) {
        this.info = info;
    }
    
    public String getPicture() {
        return picture;
    }
    
    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    public Long getOwnerId() {
        return ownerId;
    }
    
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
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
    
    public Integer getLikesCount() {
        return likesCount;
    }
    
    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }
    
    public Integer getHitsCount() {
        return hitsCount;
    }
    
    public void setHitsCount(Integer hitsCount) {
        this.hitsCount = hitsCount;
    }
    
    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", info='" + info + '\'' +
                ", picture='" + picture + '\'' +
                ", ownerId=" + ownerId +
                ", parentId=" + parentId +
                ", createTime=" + createTime +
                ", likesCount=" + likesCount +
                ", hitsCount=" + hitsCount +
                '}';
    }
}
