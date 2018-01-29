package com.ssm.service.impl;

import com.ssm.dao.UserMapper;
import com.ssm.model.UserModel;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author FaceFeel
 * @Created 2018-01-28 19:48
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserModel findUserByUserName(UserModel userModel) {

        return userMapper.findUserByUserName(userModel);
    }
}
