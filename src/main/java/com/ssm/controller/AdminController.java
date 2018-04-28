package com.ssm.controller;

import com.ssm.model.UserModel;
import com.ssm.service.AdminService;
import com.ssm.tools.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    public String insertUser() {

        UserModel userModel = new UserModel();
        boolean result = adminService.insertUser(userModel);

        return "";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {

        Object currentUser = request.getSession().getAttribute("currentUser");
        System.err.println(currentUser);
        return "index";
    }

    /**
     * 前端请求的入口
     *
     * @param request  请求
     * @param response 响应
     * @throws IOException 异常
     */
    @RequestMapping(value = "/captcha", method = RequestMethod.GET)
    @ResponseBody
    public void captcha(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        CaptchaUtil.outputCaptcha(request, response);
    }
}
