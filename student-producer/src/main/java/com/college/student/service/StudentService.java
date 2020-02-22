package com.college.student.service;

import java.util.List;

import com.college.student.entity.Student;
import com.college.student.model.ResponseBean;

public interface StudentService {
	public List<Student> getStudents();
	public Student getStudent(int id);
	public ResponseBean addUpdateStudent(Student student,String topic);
	public ResponseBean deleteStudentById(Student student,String topic);
}
