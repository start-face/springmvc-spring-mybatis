package com.ssm.service;

import com.ssm.model.Student;

import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-01-28 20:30
 */
public interface StudentService {
    Student findStudentByUserName(Student student);

    List<Student> getList();
}
