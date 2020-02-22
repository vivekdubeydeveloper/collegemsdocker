package com.college.student.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.college.student.exception.StudentNotFound;
import com.college.student.model.ResponseBean;


@RestControllerAdvice
public class StudentControllerAdvice {
	
	@ExceptionHandler(StudentNotFound.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ResponseBean handleUserNotFound(StudentNotFound subjectNotFound){
		ResponseBean rb=new ResponseBean();
		rb.setError(true);
		rb.setErrorMsg(subjectNotFound.getMessage());
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
