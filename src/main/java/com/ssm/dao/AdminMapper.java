package com.ssm.dao;

import com.ssm.model.UserModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-04-27 17:04
 **/
public interface AdminMapper {

    boolean updatePassWord(@Param("id") Long id, @Param("passWord") String passWord);

    /**
     * 添加用户方法
     * @param userModel 用户实体
     */
    void insertUser(UserModel userModel);

    /**
     * 获取用户集合
     * @return 用户集合
     */
    List<UserModel> getUserList();

    /**
     * 按照用户名查找用户
     * @param userName 用户名
     * @return
     */
    UserModel findUserByUserName(String userName);
}
