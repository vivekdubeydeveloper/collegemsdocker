package com.college.student.util;

public final class MessageConstant {
	private MessageConstant() {
		
	}
	public static final String NO_SUBJECT_FOUND="No Student Found For This Id";
	public static final String NO_TRANSACTION_FOUND="No Transaction Found For This Id";
	
	public static final String DATA_PUSHED_IN_KAFKA="Data has been pushed. you can check status by calling transaction api using transaction id:";
	public static final String KAFKA_TRANSACTION_COMPLETED="C";
	public static final String KAFKA_TRANSACTION_FAILED="F";
    
}
