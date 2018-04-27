package com.ssm.dao;

import com.ssm.model.UserModel;

/**
 * @author FaceFeel
 * @Created 2018-04-27 17:04
 **/
public interface AdminDao {

    /**
     * 添加用户方法
     * @param userModel 用户实体
     */
    void insertUser(UserModel userModel);
}
