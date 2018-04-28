package com.ssm.service.impl;

import com.ssm.dao.UserMapper;
import com.ssm.model.UserModel;
import com.ssm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-01-28 19:48
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserModel findUserByUserName(UserModel userModel) {

        try {
            return userMapper.findUserByUserName(userModel);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public UserModel insertOne(UserModel userModel) {

        try {
            userMapper.insertOne(userModel);
            return userModel;
        } catch (Exception e) {
            logger.error("insertOne error !!", e);
            return null;
        }
    }
}
