package com.ssm.service.impl;

import com.ssm.dao.StudentMapper;
import com.ssm.model.Student;
import com.ssm.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-01-28 20:32
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student insertOne(Student student) {

        try {
            studentMapper.insertOne(student);
            return student;
        } catch (Exception e) {
            logger.error("insert One error !!", e);
            return null;
        }
    }

    @Override
    public Student findStudentByUserName(Student student) {
        return studentMapper.findStudentByUserName(student);
    }

    @Override
    public List<Student> getList() {
        return studentMapper.getList();
    }
}
