package com.Gbo601.Model;


import com.alibaba.druid.sql.visitor.functions.Char;

/**
 * @author Gbo601
 * @create 2021-05-10 21:48
 */
public class User {
    private String userID;
    private String userPassword;
    private int Identity;
    private String userName;
    private String userAge;
    private String userSex;
    private String userEmail;
    private String userPhone;

    public User() {
    }
    public User(String userPassword) {
        this.userPassword=userPassword;
    }

    public User(String userID, String userPassword, int identity, String userName, String userAge, String userSex, String userEmail, String userPhone) {
        this.userID = userID;
        this.userPassword = userPassword;
        this.Identity = identity;
        this.userName = userName;
        this.userAge = userAge;
        this.userSex = userSex;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public int getIdentity() {
        return Identity;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public String getUserSex() {
        return userSex;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setIdentity(int identity) {
        this.Identity = identity;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", Identity=" + Identity +
                ", userName='" + userName + '\'' +
                ", userAge='" + userAge + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }
}
