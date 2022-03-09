package com.master.tags.pojo;

public class Admin {
    private Long id;
    private String username;
    private String password;
    private Long powerId;
    
    public Admin() {
    }
    
    public Admin(Long id, String username, String password, Long powerId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.powerId = powerId;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Long getPowerId() {
        return powerId;
    }
    
    public void setPowerId(Long powerId) {
        this.powerId = powerId;
    }
    
    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", powerId=" + powerId +
                '}';
    }
}
