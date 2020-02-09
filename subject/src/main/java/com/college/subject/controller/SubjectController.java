package com.college.subject.controller;

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

import com.college.subject.entity.Subject;
import com.college.subject.model.ResponseBean;
import com.college.subject.service.SubjectService;
import com.college.subject.util.MessageConstant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Api(value="SubjectController",tags= {"Represent Subject Resource"})
@RestController
@RequestMapping("/api/v1")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@ApiOperation(value = "Fetch all the subjects", response = Iterable.class)
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"), 
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/subjects")
	@ResponseStatus(code=HttpStatus.OK)
	public List<Subject> getSubjects() {
		return subjectService.getSubjects();
	}
	
	@ApiOperation(value = "Fetch subject on the base of subject id", response = Subject.class)
	@GetMapping("/subjects/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public Subject getSubject(@PathVariable("id") int id) {
		return subjectService.getSubject(id);
	}
	
	@ApiOperation(value = "Add subject", response = ResponseBean.class)
	@PostMapping("/subjects")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseBean addSubject(@RequestBody Subject subject) {
		subjectService.addUpdateSubject(subject);
		ResponseBean rb=new ResponseBean();
		rb.setMsg(MessageConstant.OBJECT_CREATED_SUCCESSFULLY+subject.getId());
		return rb;
	}
	
	@ApiOperation(value = "Update subject", response = ResponseBean.class)
	@PutMapping("/subjects")
	@ResponseStatus(code=HttpStatus.OK)
	public ResponseBean updateSubject(@RequestBody Subject subject) {
		subjectService.addUpdateSubject(subject);
		ResponseBean rb=new ResponseBean();
		rb.setMsg(MessageConstant.OBJECT_UPDATED_SUCCESSFULLY);
		return rb;
	}
	
	@ApiOperation(value = "Delete subject", response = ResponseBean.class)
	@DeleteMapping("/subjects/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public ResponseBean deleteSubjectById(@PathVariable("id") int id) {
		subjectService.deleteSubjectById(id);
		ResponseBean rb=new ResponseBean();
		rb.setMsg(MessageConstant.OBJECT_DELETED_SUCCESSFULLY);
		return rb;
	}
	

}
