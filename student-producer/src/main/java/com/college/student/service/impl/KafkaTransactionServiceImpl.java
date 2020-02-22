package com.college.student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.student.consumer.dao.KafkaTransactionDAO;
import com.college.student.entity.KafkaTransaction;
import com.college.student.exception.TransactionNotFound;
import com.college.student.service.KafkaTransactionService;
import com.college.student.util.MessageConstant;

@Service
public class KafkaTransactionServiceImpl implements KafkaTransactionService {
	
	@Autowired
	KafkaTransactionDAO ktDAO;

	@Override
	public KafkaTransaction getTransactionById(String transactionid) {
		return ktDAO.findById(transactionid).orElseThrow(()->new TransactionNotFound(MessageConstant.NO_TRANSACTION_FOUND));
	}

}
