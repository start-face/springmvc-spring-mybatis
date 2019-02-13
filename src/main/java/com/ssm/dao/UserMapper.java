package com.ssm.dao;

import com.ssm.model.UserModel;
import org.apache.ibatis.annotations.Param;

/**
 * @author FaceFeel
 * @Created 2018-01-28 19:50
 */

public interface UserMapper {

    UserModel findUserByUserName(String userName);

    /**
     * 传入多参数需要这么处理,否则会报错
     * @param userName
     * @param passWord
     * @return
     */
    UserModel findUserByUserNameAndPassWord(@Param("userName")String userName, @Param("passWord")String passWord);
}
