package com.ssm.service;

import com.ssm.model.UserModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-01-28 19:44
 */
public interface UserService {

    UserModel findUserByUserName(String userName);

    UserModel findUserByUserNameAndPassWord(String userName, String passWord);
}
