package com.dai.TransactionManager.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;

@Repository
public class ConnectionUtils {
    private ThreadLocal<Connection> t1 = new ThreadLocal<Connection>();
    @Autowired
    private DataSource dataSource;

    public Connection getTheadConnection() {

        try {
            //先从线程获取，看是否有连接，无则创建并添加
            Connection connection = t1.get();
            if (connection == null) {
                connection = dataSource.getConnection();
                t1.set(connection);
            }
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void removeConnection(){
        t1.remove();
    }

}
