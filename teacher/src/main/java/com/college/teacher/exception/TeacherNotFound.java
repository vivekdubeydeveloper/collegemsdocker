package com.college.teacher.exception;

public class TeacherNotFound  extends RuntimeException{
	

	private static final long serialVersionUID = 1L;

	public TeacherNotFound(String msg) {
		super(msg);
	}

}
