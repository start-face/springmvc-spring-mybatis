package com.ssm.service;

import com.ssm.model.UserModel;

/**
 * 管理员添加用户方法
 * @author FaceFeel
 * @Created 2018-04-27 16:57
 **/
public interface AdminService {

    /**
     * 添加用户方法
     * @param userModel 用户实体
     * @return 布尔
     */
    boolean insertUser(UserModel userModel);
}
