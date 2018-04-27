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
    private Integer auth;


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("userName", userName)
                .add("passWord", passWord)
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
}
