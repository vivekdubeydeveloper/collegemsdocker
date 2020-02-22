package com.college.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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

import com.college.student.entity.Student;
import com.college.student.model.ResponseBean;
import com.college.student.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="SubjectController",tags= {"Represent Student Resource"})
@RestController
@RequestMapping("/api/v1")
@RefreshScope
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Value("${topic.create.student}")
	String createStudentTopic;
	
	@Value("${topic.update.student}")
	String updateStudentTopic;
	
	@Value("${topic.delete.student.id}")
	String deleteStudentTopic;
	
	@ApiOperation(value = "Fetch all the students", response = Iterable.class)
	@GetMapping("/students")
	@ResponseStatus(code=HttpStatus.OK)
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
	
	@ApiOperation(value = "Fetch student on the base of id", response = Student.class)
	@GetMapping("/students/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public Student getStudent(@PathVariable("id") int id) {
		return studentService.getStudent(id);
	}
	
	@ApiOperation(value = "Add student", response = ResponseBean.class)
	@PostMapping("/students")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseBean addStudent(@RequestBody Student student) {
		return studentService.addUpdateStudent(student,createStudentTopic);
	}
	
	@ApiOperation(value = "Update student", response = ResponseBean.class)
	@PutMapping("/students")
	@ResponseStatus(code=HttpStatus.OK)
	public ResponseBean updateStudent(@RequestBody Student student) {
		return studentService.addUpdateStudent(student,updateStudentTopic);
	}
	
	@ApiOperation(value = "Delete student on the base of id", response = ResponseBean.class)
	@DeleteMapping("/students/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public ResponseBean deleteStudentById(@PathVariable("id") int id) {
		Student student=new Student();
		student.setRollno(id);
		return studentService.deleteStudentById(student,deleteStudentTopic);
	}
	
	
	
}
