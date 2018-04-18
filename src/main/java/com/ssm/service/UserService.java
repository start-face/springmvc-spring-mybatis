package com.ssm.service;

import com.ssm.model.UserModel;
import org.springframework.stereotype.Repository;

/**
 * @author FaceFeel
 * @Created 2018-01-28 19:44
 */
@Repository
public interface UserService {

    UserModel findUserByUserName(UserModel userModel);

    UserModel insertOne(UserModel userModel);
}
