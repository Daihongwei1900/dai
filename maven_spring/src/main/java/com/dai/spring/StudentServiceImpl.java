package com.dai.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentServiceImpl {
    @Autowired
    private StudentDaoImpl studentDao;


    public List<Teacher> findALl() throws SQLException {
        List<Teacher> all = studentDao.findAll();
        return all;
    }
}
