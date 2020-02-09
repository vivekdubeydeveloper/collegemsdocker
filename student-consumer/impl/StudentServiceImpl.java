package com.college.student.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.student.dao.StudentDAO;
import com.college.student.entity.Student;
import com.college.student.exception.StudentNotFound;
import com.college.student.service.StudentService;
import com.college.student.util.MessageConstant;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDAO studentDAO;

	@Override
	public List<Student> getStudents(){
		List<Student> students=new ArrayList<>();
		Consumer<Student> sConsumer=s->students.add(s);
		studentDAO.findAll().forEach(sConsumer);
		return students;
	}

	@Override
	public Student getStudent(int id) {
		return studentDAO.findById(id).orElseThrow(()->new StudentNotFound(MessageConstant.NO_SUBJECT_FOUND));
	}

	@Override
	public void addUpdateStudent(Student student) {
		studentDAO.save(student);
	}

	@Override
	public void deleteStudentById(int id) {
		studentDAO.deleteById(id);
	}

}
