package com.dai.mysql;

import java.sql.*;

public class JDBCDStart {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //注册mysql的驱动 DriverManager帮你管理驱动并智能匹配，registeredDrivers
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm_hrm", "root", "root");
        connection.setAutoCommit(false);
        String sql = "select * from tbl_teach";
        //预编译  防止SQL注入，提高效率，提高代码的可读性（未执行就把prepareStatement提交给DBMS）
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name =resultSet.getString(2);
            String zhichen =resultSet.getString(3);
            System.out.println(id+name+zhichen);
        }
        resultSet.close();
        connection.close();
    }
}
