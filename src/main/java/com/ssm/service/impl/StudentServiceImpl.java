package com.ssm.service.impl;

import com.ssm.dao.StudentMapper;
import com.ssm.model.Student;
import com.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-01-28 20:32
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student findStudentByUserName(Student student) {
        return studentMapper.findStudentByUserName(student);
    }

    @Override
    public List<Student> getList() {
        return studentMapper.getList();
    }
}
