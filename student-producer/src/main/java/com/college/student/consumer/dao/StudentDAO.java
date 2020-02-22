package com.college.student.consumer.dao;

import org.springframework.data.repository.CrudRepository;

import com.college.student.entity.Student;

public interface StudentDAO extends CrudRepository<Student, Integer>{

}
