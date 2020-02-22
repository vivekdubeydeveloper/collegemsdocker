package com.college.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.college.teacher.entity.Subject;
import com.college.teacher.entity.Teacher;
import com.college.teacher.model.ResponseBean;
import com.college.teacher.service.TeacherService;
import com.college.teacher.util.MessageConstant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value="TeacherSubjectController",tags= {"Represent Teacher Subject Relationship"})
@RestController
@RequestMapping("/api/v1")
public class TeacherSubjectController {

	@Autowired
	private TeacherService teacherService;

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${subject.service.base.url}")
	private String subjectApiEndpoint;
	
	@Value("${get.subject.url}")
	private String getSubjectEndpoint;
	
	@ApiOperation(value = "Fetch subject of teacher", response = Subject.class)
	@GetMapping("/teachers/{id}/subjects")
	@ResponseStatus(code = HttpStatus.OK)
	public Subject getTeacherSubject(@PathVariable("id") int id) {
		Teacher dbTeacher = teacherService.getTeacher(id);
		String url =subjectApiEndpoint+getSubjectEndpoint+ dbTeacher.getSubjectId();
		return restTemplate.getForObject(url, Subject.class);
	}

	@ApiOperation(value = "Update subject of teacher", response = ResponseBean.class)
	@PutMapping("/teachers/{id}/subjects")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseBean addTeacherSubject(@RequestBody Teacher teacher, @PathVariable("id") int id) {
		Teacher dbTeacher = teacherService.getTeacher(id);
		dbTeacher.setSubjectId(teacher.getSubjectId());
		teacherService.addUpdateTeacher(dbTeacher);
		ResponseBean rb = new ResponseBean();
		rb.setMsg(MessageConstant.SUBJECT_UPDATED_SUCCESSFULLY + dbTeacher.getEmpid());
		return rb;
	}

	
}
