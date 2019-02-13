package com.ssm.service.impl;

import com.ssm.dao.UserMapper;
import com.ssm.model.UserModel;
import com.ssm.service.UserService;
import com.ssm.tools.data.Str;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.acl.LastOwnerException;
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
    public UserModel findUserByUserName(String userName) {

        if (Str.isBlank(userName)) {
            logger.warn("输入的用户名为空");
            return null;
        }

        try {
            return userMapper.findUserByUserName(userName);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UserModel findUserByUserNameAndPassWord(String userName, String passWord) {

        if (Str.isBlank(userName) || Str.isBlank(passWord)) {
            logger.warn("传入的帐号或密码为空");
            return null;
        }

        try {
            return userMapper.findUserByUserNameAndPassWord(userName, passWord);
        } catch (Exception e) {
            logger.error("查询出错,错误信息是:", e);
            return null;
        }
    }
}
