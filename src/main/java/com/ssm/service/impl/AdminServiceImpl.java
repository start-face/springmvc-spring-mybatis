package com.ssm.service.impl;

import com.ssm.dao.AdminMapper;
import com.ssm.model.UserModel;
import com.ssm.service.AdminService;
import com.ssm.tools.data.Str;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-04-27 17:03
 **/
@Service
public class AdminServiceImpl implements AdminService {

    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 添加用户方法
     *
     * @param userModel 用户实体
     * @return 布尔
     */
    @Override
    public boolean insertUser(UserModel userModel) {

        if (userModel == null) {
            logger.warn("传入的实体为空");
            return false;
        }
        try {
            adminMapper.insertUser(userModel);
            return true;
        } catch (Exception e) {
            logger.error("insertOne error !!", e);
            return false;
        }
    }

    /**
     * 修改用户密码
     *
     * @param id       用户ID
     * @param passWord 新密码
     * @return
     */
    @Override
    public boolean updatePassWord(Long id, String passWord) {

        if (id == null || Str.isBlank(passWord)) {
            logger.warn("用户ID或新密码为空");
            return false;
        }

        try {
            adminMapper.updatePassWord(id, passWord);
            return true;
        } catch (Exception e) {
            logger.error("更新密码失败,失败信息是:", e);
            return false;
        }
    }

    /**
     * 获取用户集合
     *
     * @return
     */
    @Override
    public List<UserModel> getUserList() {

        try {
            return adminMapper.getUserList();
        } catch (Exception e) {
            logger.error("查询数据出错,错误信息是:", e);
            return null;
        }
    }

    /**
     * 按照用户名查找用户
     *
     * @param userName 用户名
     * @return
     */
    @Override
    public UserModel findUserByUserName(String userName) {

        if (Str.isBlank(userName)) {
            logger.warn("输入的用户名为空");
            return null;
        }

        try {
            return adminMapper.findUserByUserName(userName);
        } catch (Exception e) {
            return null;
        }
    }
}
