package com.college.student.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.college.student.consumer.dao.StudentDAO;
import com.college.student.consumer.entity.Student;
import com.college.student.consumer.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO studentDAO;

	@KafkaListener(topics = "${topic.create.student}")
	@Override
	public void addStudent(Student student) {
		studentDAO.save(student);
	}

	@KafkaListener(topics = "${topic.update.student}")
	@Override
	public void updateStudent(Student student) {
		studentDAO.save(student);
	}

	@KafkaListener(topics = "${topic.delete.student.id}")
	@Override
	public void deleteStudentById(Student student) {
		Optional<Student>studentO=studentDAO.findById(student.getRollno());
		if(studentO.isPresent()) {
			studentDAO.delete(studentO.get());
		}
		
	}

}
