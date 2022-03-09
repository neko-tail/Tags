package com.master.tags.pojo;

import java.util.Date;

public class UserDetail {
    private Long id;
    private String gender;
    private Date birthday;
    
    public UserDetail() {
    }
    
    public UserDetail(Long id, String gender, Date birthday) {
        this.id = id;
        this.gender = gender;
        this.birthday = birthday;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public Date getBirthday() {
        return birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
