package com.college.subject.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.subject.dao.SubjectDAO;
import com.college.subject.entity.Subject;
import com.college.subject.exception.SubjectNotFound;
import com.college.subject.service.SubjectService;
import com.college.subject.util.MessageConstant;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	SubjectDAO subjectDAO;

	@Override
	public List<Subject> getSubjects(){
		List<Subject> subjects=new ArrayList<>();
		Consumer<Subject> sConsumer=subjects::add;
		subjectDAO.findAll().forEach(sConsumer);
		return subjects;
	}

	@Override
	public Subject getSubject(int id) {
		return subjectDAO.findById(id).orElseThrow(()->new SubjectNotFound(MessageConstant.NO_SUBJECT_FOUND));
	}

	@Override
	public void addUpdateSubject(Subject subject) {
		subjectDAO.save(subject);
	}

	@Override
	public void deleteSubjectById(int id) {
		Subject subject=getSubject(id);
		subjectDAO.delete(subject);
	}

}
