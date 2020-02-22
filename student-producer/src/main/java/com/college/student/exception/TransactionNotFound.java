package com.college.student.exception;

public class TransactionNotFound  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public TransactionNotFound(String msg) {
		super(msg);
	}

}
