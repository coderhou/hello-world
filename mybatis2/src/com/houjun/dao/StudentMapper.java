package com.houjun.dao;

import com.houjun.domain.Student;

public interface StudentMapper {
// @Select("SELECT * FROM blog WHERE id = #{id}")
 Student selectById(int id);
 
 Student selectByAll();

 void insert(Student student);

 void delete(int id);

 Integer update(Student student);
}