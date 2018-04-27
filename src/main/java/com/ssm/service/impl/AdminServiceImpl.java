package com.ssm.service.impl;

import com.ssm.dao.AdminDao;
import com.ssm.model.UserModel;
import com.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author FaceFeel
 * @Created 2018-04-27 17:03
 **/
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    /**
     * 添加用户方法
     *
     * @param userModel 用户实体
     * @return 布尔
     */
    @Override
    public boolean insertUser(UserModel userModel) {

        try {
            adminDao.insertUser(userModel);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
