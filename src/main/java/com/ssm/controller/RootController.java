package com.ssm.controller;

import com.ssm.tools.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

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
    @ResponseBody
    public String index(HttpServletRequest request) {

        //在这判断登录
        String username = request.getParameter("userName");
        String password = request.getParameter("passWord");
        System.err.println("userName:********" + username);
        System.err.println("passWord:********" + password);

        if ("fudan".equals(username) && !"".equals(password)) {
            //登录成功跳转后台
            request.getSession().setAttribute("currentUser", username);
            return "1";
        }
        //登录失败跳回原来的页面
        return "0";
    }

    /**
     * 前端请求的入口
     *
     * @param request  请求
     * @param response 响应
     * @throws IOException 异常
     */
    @RequestMapping(value = "captcha", method = RequestMethod.GET)
    @ResponseBody
    public void captcha(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        CaptchaUtil.outputCaptcha(request, response);
    }

    @RequestMapping("checkCode")
    @ResponseBody
    public String checkCode(HttpServletRequest request) {

        String string = request.getSession().getAttribute("randomString").toString();
        String code = request.getParameter("code");
        if (string.equals(code)) {
            return "1";
        } else {
            return "0";
        }
    }
}
