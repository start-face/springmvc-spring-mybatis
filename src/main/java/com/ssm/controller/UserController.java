package com.ssm.controller;

import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author FaceFeel
 * @Created 2018-01-28 19:12
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        return "success";
    }

    @RequestMapping("/show")
    public String showUser(HttpServletRequest request) {
        return "success";
    }
}
