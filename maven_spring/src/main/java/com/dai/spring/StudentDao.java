package com.dai.spring;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface StudentDao extends Serializable {
    List<Teacher> findAll() throws SQLException;

}
