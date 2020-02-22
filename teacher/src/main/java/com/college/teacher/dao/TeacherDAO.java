package com.college.teacher.dao;

import org.springframework.data.repository.CrudRepository;

import com.college.teacher.entity.Teacher;

public interface TeacherDAO extends CrudRepository<Teacher, Integer>{

}
