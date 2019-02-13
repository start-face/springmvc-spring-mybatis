package com.ssm.controller;

import com.ssm.model.UserModel;
import com.ssm.service.AdminService;
import com.ssm.service.UserService;
import com.ssm.tools.CaptchaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @Created 2018-04-27 11:21
 **/
@Controller
@RequestMapping("/")
public class RootController {

    private static final Logger logger = LoggerFactory.getLogger(RootController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    public String login() {

        UserModel admin = userService.findUserByUserName("admin");
        if (admin == null){

            logger.info("开始初始化管理员账户");
            UserModel userModel = new UserModel();
            userModel.setUserName("admin")
                    .setPassWord("123456")
                    .setAuth(1)
                    .setMail("")
                    .setPhone("");
            boolean result = adminService.insertUser(userModel);
            if (!result){
                logger.error("管理员初始化失败");
            }
            logger.info("管理员初始化成功");
        }
        return "login";
    }

    @RequestMapping("registerPage")
    public String registerPage(){
        return "register";
    }

    /**
     * 注销登录
     *
     * @param request http
     * @return ""
     */
    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {

        request.getSession().setAttribute("currentUser", null);
        return "redirect:/login";
    }

    @RequestMapping("index")
    @ResponseBody
    public String index(HttpServletRequest request,UserModel userModel) {

        //在这判断登录
        UserModel userByUserName = userService.findUserByUserNameAndPassWord(userModel.getUserName(),userModel.getPassWord());
        if (userByUserName != null) {
            //登录成功跳转后台
            request.getSession().setAttribute("currentUser", userByUserName);

            //判断权限
            if (userByUserName.getAuth() == 0){
                //普通用户
                return "0";
            }
            //管理员
            return "1";
        }
        //登录失败跳回原来的页面
        return "2";
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
