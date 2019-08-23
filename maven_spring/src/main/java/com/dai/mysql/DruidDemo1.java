package com.dai.mysql;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        String sql = "select * from tbl_teach";
        //预编译  防止SQL注入，提高效率，提高代码的可读性（未执行就把prepareStatement提交给DBMS）
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
    }
    @Test
    public void testC3p0() throws SQLException {
        DataSource ds  = new ComboPooledDataSource();
        Connection connection = ds.getConnection();
        System.out.println(connection);
    }
    @Test
    public void testSpringTemplate(){
        DataSource ds  = new ComboPooledDataSource();
        JdbcTemplate template = new JdbcTemplate(ds);
        String sql = "select * from tbl_teach where teach_title =?";
        List<Map<String, Object>> maps = template.queryForList(sql, "教授");
        System.out.println(maps);
    }
}