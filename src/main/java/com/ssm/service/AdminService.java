package com.ssm.service;

import com.ssm.model.UserModel;

import java.util.List;

/**
 * 管理员添加用户方法
 * @author FaceFeel
 * @Created 2018-04-27 16:57
 **/
public interface AdminService {

    /**
     * 修改密码
     * @param id 用户ID
     * @param passWord 新密码
     * @return 布尔
     */
    boolean updatePassWord(Long id,String passWord);

    /**
     * 查看用户列表
     * @return 用户集合
     */
    List<UserModel> getUserList();

    /**
     * 校验用户名
     * @param userName 用户名
     * @return 对应用户
     */
    UserModel findUserByUserName(String userName);

    /**
     * 添加用户方法
     * @param userModel 用户实体
     * @return 布尔
     */
    boolean insertUser(UserModel userModel);
}
