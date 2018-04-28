package com.ssm.model;

import com.google.common.base.MoreObjects;

/**
 * @author FaceFeel
 * @Created 2018-01-28 19:44
 */

public class UserModel {

    private Long id;
    private String userName;
    private String passWord;
    private String mail;
    private String phone;
    private Integer auth;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("userName", userName)
                .add("passWord", passWord)
                .add("mail", mail)
                .add("phone", phone)
                .add("auth", auth)
                .toString();
    }

    public Long getId() {
        return id;
    }

    public UserModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserModel setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassWord() {
        return passWord;
    }

    public UserModel setPassWord(String passWord) {
        this.passWord = passWord;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public UserModel setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserModel setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Integer getAuth() {
        return auth;
    }

    public UserModel setAuth(Integer auth) {
        this.auth = auth;
        return this;
    }
}
