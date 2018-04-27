package com.ssm.controller;

import com.ssm.model.UserModel;
import com.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author FaceFeel
 * @Created 2018-04-27 16:55
 **/

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/insertUser")
    public String insertUser(){

        UserModel userModel = new UserModel();
        boolean result = adminService.insertUser(userModel);

        return "";
    }

    @RequestMapping("")
    public String index(){

        return "";
    }
}
