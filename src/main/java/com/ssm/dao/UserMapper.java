package com.ssm.dao;

import com.ssm.model.UserModel;

/**
 * @author FaceFeel
 * @Created 2018-01-28 19:50
 */

public interface UserMapper {

    UserModel findUserByUserName(UserModel userModel);
}
