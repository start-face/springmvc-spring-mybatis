package com.ssm.dao;

import com.ssm.model.UserModel;

import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-01-28 19:50
 */

public interface UserMapper {

    List<UserModel> findUserByUserName(UserModel userModel);

    void insertOne(UserModel userModel);
}
