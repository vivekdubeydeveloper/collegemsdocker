package com.college.teacher.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.college.teacher.exception.TeacherNotFound;
import com.college.teacher.model.ResponseBean;

@RestControllerAdvice
public class TeacherControllerAdvice {
	
	@ExceptionHandler(TeacherNotFound.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ResponseBean handleTeacherNotFound(TeacherNotFound teacherNotFound){
		ResponseBean rb=new ResponseBean();
		rb.setError(true);
		rb.setErrorMsg(teacherNotFound.getMessage());
		return rb;
		
	}
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseBean handleException(Exception exception){
		ResponseBean rb=new ResponseBean();
		rb.setError(true);
		rb.setErrorMsg(exception.getMessage());
		return rb;
		
	}

}
