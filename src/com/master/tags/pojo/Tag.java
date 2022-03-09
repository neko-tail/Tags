package com.master.tags.pojo;

public class Tag {
    private Long id;
    private String tagName;
    private Boolean visible;
    private Boolean available;
    
    public Tag() {
    }
    
    public Tag(Long id, String tagName, Boolean visible, Boolean available) {
        this.id = id;
        this.tagName = tagName;
        this.visible = visible;
        this.available = available;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTagName() {
        return tagName;
    }
    
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
    
    public Boolean isVisible() {
        return visible;
    }
    
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
    
    public Boolean isAvailable() {
        return available;
    }
    
    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
