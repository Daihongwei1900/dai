package com.dai.spring;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.commons.dbutils.handlers.*;

import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private QueryRunner runner;

    public List<Teacher> findAll() throws SQLException {
        String sql = "select * from tbl_teach";
        List<Teacher> query = runner.query(sql, new BeanListHandler<Teacher>(Teacher.class));
        return query;
    }

}
