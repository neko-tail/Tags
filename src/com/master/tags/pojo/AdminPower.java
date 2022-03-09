package com.master.tags.pojo;

public class AdminPower {
    private Long id;
    private String name;
    private Boolean isProjectManager;
    private Boolean isTagManager;
    private Boolean isUserManager;
    private Boolean isAnnouncementManager;
    
    public AdminPower() {
    }
    
    public AdminPower(Long id, String powerName, Boolean isProjectManager, Boolean isTagManager, Boolean isUserManager, Boolean isAnnouncementManager) {
        this.id = id;
        this.name = powerName;
        this.isProjectManager = isProjectManager;
        this.isTagManager = isTagManager;
        this.isUserManager = isUserManager;
        this.isAnnouncementManager = isAnnouncementManager;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Boolean isProjectManager() {
        return isProjectManager;
    }
    
    public void setProjectManager(Boolean projectManager) {
        isProjectManager = projectManager;
    }
    
    public Boolean isTagManager() {
        return isTagManager;
    }
    
    public void setTagManager(Boolean tagManager) {
        isTagManager = tagManager;
    }
    
    public Boolean isUserManager() {
        return isUserManager;
    }
    
    public void setUserManager(Boolean userManager) {
        isUserManager = userManager;
    }
    
    public Boolean isAnnouncementManager() {
        return isAnnouncementManager;
    }
    
    public void setAnnouncementManager(Boolean announcementManager) {
        isAnnouncementManager = announcementManager;
    }
    
    @Override
    public String toString() {
        return "AdminPower{" +
                "id=" + id +
                ", powerName='" + name + '\'' +
                ", isProjectManager=" + isProjectManager +
                ", isTagManager=" + isTagManager +
                ", isUserManager=" + isUserManager +
                ", isAnnouncementManager=" + isAnnouncementManager +
                '}';
    }
}
