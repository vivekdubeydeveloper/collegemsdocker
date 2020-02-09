package com.college.student.consumer.dao;

import org.springframework.data.repository.CrudRepository;

import com.college.student.entity.KafkaTransaction;

public interface KafkaTransactionDAO  extends CrudRepository<KafkaTransaction, String>{

}
