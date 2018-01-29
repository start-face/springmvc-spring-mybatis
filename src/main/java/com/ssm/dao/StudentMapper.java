package com.ssm.dao;

import com.ssm.model.Student;

import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-01-28 20:31
 */

public interface StudentMapper {
    Student findStudentByUserName(Student student);

    List<Student> getList();
}
