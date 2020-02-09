package com.college.subject.exception;

public class SubjectNotFound  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public SubjectNotFound(String msg) {
		super(msg);
	}

}
