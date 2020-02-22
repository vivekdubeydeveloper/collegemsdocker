package com.college.teacher.service;

import java.util.List;

import com.college.teacher.entity.Teacher;

public interface TeacherService {
	public List<Teacher> getTeachers();
	public Teacher getTeacher(int id);
	public void addUpdateTeacher(Teacher subject);
	public void deleteTeacherById(int id);
}
