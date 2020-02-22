package com.college.student.service;

import com.college.student.entity.KafkaTransaction;

public interface KafkaTransactionService {

	public KafkaTransaction getTransactionById(String transactionid);
}
