package com.ssm.controller;

import com.ssm.model.UserModel;
import com.ssm.service.AdminService;
import com.ssm.tools.PageInfo;
import com.ssm.tools.ToolJson;
import com.ssm.tools.data.Str;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-04-27 16:55
 **/

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 跳转修改密码界面
     *
     * @return 页面名称
     */
    @RequestMapping("/updatePassWordPage")
    public String updatePassWordPage(HttpServletRequest request) {
        UserModel currentUser = (UserModel) request.getSession().getAttribute("currentUser");
        request.setAttribute("user", currentUser);
        return "updatePassWord";
    }

    /**
     * 添加用户时用于用户名的校验
     *
     * @param request http
     * @return json
     */
    @RequestMapping("/findUserByUserName")
    @ResponseBody
    public String findUserByUserName(HttpServletRequest request) {

        UserModel currentUser = (UserModel) request.getSession().getAttribute("currentUser");
        if (currentUser == null) {
            return "2";
        }

        String userName = request.getParameter("userName");
        if (Str.isBlank(userName)) {
            return "0";
        }

        UserModel userByUserName = adminService.findUserByUserName(userName);
        if (userByUserName == null) {
            //用户名未被使用
            return "1";
        } else {
            return "0";
        }
    }

    /**
     * 修改密码
     *
     * @param request http
     * @return json
     */
    @RequestMapping("/updatePassWord")
    @ResponseBody
    public String updatePassWord(HttpServletRequest request) {

        String passWord = request.getParameter("passWord");
        UserModel currentUser = (UserModel) request.getSession().getAttribute("currentUser");

        if (currentUser == null) {
            return "2";
        }

        boolean result = adminService.updatePassWord(currentUser.getId(), passWord);
        if (result) {
            //修改成功
            return "1";
        } else {
            return "0";
        }
    }

    /**
     * 查看用户列表
     *
     * @param request http
     * @return 页面名称
     */
    @RequestMapping("/getUserList")
    public String getUserList(HttpServletRequest request) {

        List<UserModel> userList = adminService.getUserList();
        request.setAttribute("userList", userList);
        PageInfo<UserModel> p = new PageInfo<>();
        p.setList(userList);
        return ToolJson.anyToJson(p);
    }

    /**
     * 添加用户
     *
     * @param request htt
     * @return 页面名称
     */
    @RequestMapping("/insertUser")
    @ResponseBody
    public String insertUser(HttpServletRequest request, UserModel userModel) {

        if (userModel == null) {
            return "0";
        }

        UserModel currentUser = (UserModel) request.getSession().getAttribute("currentUser");
        if (currentUser == null) {
            return "2";
        }

        userModel.setPassWord("123456").setAuth(0);
        boolean result = adminService.insertUser(userModel);
        if (result) {
            return "1";
        } else {
            return "0";
        }
    }

    /**
     * 跳转管理员主页
     *
     * @param request http
     * @return 页面名称
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        UserModel userModel = (UserModel) request.getSession().getAttribute("currentUser");
        if (userModel == null) {
            return "redirect:/login";
        }
        request.setAttribute("user", userModel);
        return "index";
    }
}
