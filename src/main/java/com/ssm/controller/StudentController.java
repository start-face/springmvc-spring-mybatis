package com.ssm.controller;

import com.ssm.model.Student;
import com.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author FaceFeel
 * @Created 2018-01-28 20:29
 */

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/show")
    public String showStudent(HttpServletRequest request){
        request.setAttribute("user",studentService.findStudentByUserName(new Student().setSname("曹操")));
        return "success";
    }

    @RequestMapping("/list")
    public String showList(HttpServletRequest request){
        request.setAttribute("listOracle",studentService.getList());
        return "showList";
    }
}
