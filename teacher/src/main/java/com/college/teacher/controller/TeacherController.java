package com.college.teacher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.college.teacher.entity.Teacher;
import com.college.teacher.model.ResponseBean;
import com.college.teacher.service.TeacherService;
import com.college.teacher.util.MessageConstant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value="TeacherController",tags= {"Represent Teacher Resource"})
@RestController
@RequestMapping("/api/v1")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@Autowired
	RestTemplate restTemplate;

	@ApiOperation(value = "Fetch all the teachers", response = Iterable.class)
	@GetMapping("/teachers")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Teacher> getTeachers() {
		return teacherService.getTeachers();
	}

	@ApiOperation(value = "Fetch teacher on the base of teacher id", response = Teacher.class)
	@GetMapping("/teachers/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Teacher getTeacher(@PathVariable("id") int id) {
		return teacherService.getTeacher(id);
	}

	@ApiOperation(value = "Add Teacher", response = ResponseBean.class)
	@PostMapping("/teachers")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseBean addTeacher(@RequestBody Teacher teacher) {
		teacherService.addUpdateTeacher(teacher);
		ResponseBean rb = new ResponseBean();
		rb.setMsg(MessageConstant.OBJECT_CREATED_SUCCESSFULLY + teacher.getEmpid());
		return rb;
	}

	@ApiOperation(value = "Update Teacher", response = ResponseBean.class)
	@PutMapping("/teachers")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseBean updateTeacher(@RequestBody Teacher teacher) {
		teacherService.addUpdateTeacher(teacher);
		ResponseBean rb = new ResponseBean();
		rb.setMsg(MessageConstant.OBJECT_UPDATED_SUCCESSFULLY);
		return rb;
	}

	@ApiOperation(value = "Delete teacher on the base of teacher id", response = ResponseBean.class)
	@DeleteMapping("/teachers/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseBean deleteTeacherById(@PathVariable("id") int id) {
		teacherService.deleteTeacherById(id);
		ResponseBean rb = new ResponseBean();
		rb.setMsg(MessageConstant.OBJECT_DELETED_SUCCESSFULLY);
		return rb;
	}

}
