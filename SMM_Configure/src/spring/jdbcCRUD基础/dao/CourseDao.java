package com.imooc.jdbc.dao;

import com.imooc.jdbc.entity.Course;
import java.util.List;

public interface CourseDao {
    void insert(Course course);
    void update(Course course);
    void delete(int id);
    Course select(int id);
    List<Course> selectAll();
}
