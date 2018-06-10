package com.assignment.personnel.personnelsystem.entity;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "user")
public class User {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long userId;
 
    @Column(name = "name")
    private String userName;
 
    @Column(name = "uemail")
    private String userEmail;
 
    public long getUserId() {
        return userId;
    }
 
    public void setUserId(long userId) {
        this.userId = userId;
    }
 
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getUserEmail() {
        return userEmail;
    }
 
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
 
    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail;
    }
 
}