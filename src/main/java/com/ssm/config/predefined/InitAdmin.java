package com.ssm.config.predefined;

import com.ssm.model.UserModel;
import com.ssm.service.UserService;
import com.ssm.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;

/**
 * @author FaceFeel
 * @Created 2018-04-28 16:29
 **/
@WebFilter
public class InitAdmin extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(InitAdmin.class);

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        UserService userService = new UserServiceImpl();
        UserModel model = new UserModel();
        model.setUserName("admin");
        UserModel admin = userService.findUserByUserName(model);
        if (admin == null){

            logger.info("开始初始化管理员账户");
            UserModel userModel = new UserModel();
            userModel.setUserName("admin")
                    .setPassWord("123456")
                    .setAuth(1)
                    .setMail("")
                    .setPhone("");
            UserModel result = userService.insertOne(userModel);
            if (result == null){
                logger.info("管理员初始化失败");
                return;
            }
            logger.info("管理员初始化成功");
        }
    }
}
