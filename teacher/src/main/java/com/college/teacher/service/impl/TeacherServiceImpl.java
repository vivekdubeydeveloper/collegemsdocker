package com.college.teacher.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.teacher.dao.TeacherDAO;
import com.college.teacher.entity.Teacher;
import com.college.teacher.exception.TeacherNotFound;
import com.college.teacher.service.TeacherService;
import com.college.teacher.util.MessageConstant;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	TeacherDAO teacherDAO;

	@Override
	public List<Teacher> getTeachers(){
		List<Teacher> teachers=new ArrayList<>();
		Consumer<Teacher> sConsumer=teachers::add;
		teacherDAO.findAll().forEach(sConsumer);
		return teachers;
	}

	@Override
	public Teacher getTeacher(int id) {
		return teacherDAO.findById(id).orElseThrow(()->new TeacherNotFound(MessageConstant.NO_SUBJECT_FOUND));
	}

	@Override
	public void addUpdateTeacher(Teacher subject) {
		teacherDAO.save(subject);
	}

	@Override
	public void deleteTeacherById(int id) {
		Teacher teacher=getTeacher(id);
		teacherDAO.delete(teacher);
	}

}
