package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author FaceFeel
 * @Created 2018-04-27 11:21
 **/
@Controller
@RequestMapping("/")
public class RootController {

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("index")
    public String index(HttpServletRequest request) {

        String string = request.getSession().getAttribute("randomString").toString();
        System.err.println("conde:" + string);
        //在这判断登录
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String parameter = request.getParameter("");
        System.err.println("userName:********" + username);
        System.err.println("passWord:********" + password);

        if (!"".equals(username) && !"".equals(password)) {
            //登录成功跳转后台
            return "index";
        }
        //登录失败跳回原来的页面
        return "redirect:/login";
    }
}
