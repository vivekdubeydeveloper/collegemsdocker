package com.college.subject.service;

import java.util.List;

import com.college.subject.entity.Subject;

public interface SubjectService {
	public List<Subject> getSubjects();
	public Subject getSubject(int id);
	public void addUpdateSubject(Subject subject);
	public void deleteSubjectById(int id);
}
