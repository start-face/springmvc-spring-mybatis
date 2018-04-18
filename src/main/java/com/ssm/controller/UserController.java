package com.ssm.controller;

import com.ssm.model.UserModel;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-01-28 19:12
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/show")
    public String showUser(HttpServletRequest request) {

        List<UserModel> userModel = userService.findUserByUserName(new UserModel().setUserName("tom"));
        request.setAttribute("user", userModel);
        return "success";
    }

    @RequestMapping("/insertOne")
    public String insertOne(HttpServletRequest request) {

        UserModel userModel = new UserModel();
        userModel.setUserName("Tom")
                .setPassWord("123456");
        UserModel user = userService.insertOne(userModel);
        request.setAttribute("user", user);
        return "result";
    }
}
