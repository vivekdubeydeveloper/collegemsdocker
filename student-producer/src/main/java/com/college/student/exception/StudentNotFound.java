package com.college.student.exception;

public class StudentNotFound  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public StudentNotFound(String msg) {
		super(msg);
	}

}
