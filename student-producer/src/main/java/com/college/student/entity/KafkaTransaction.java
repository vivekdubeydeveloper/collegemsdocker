package com.college.student.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kafka_transaction")
public class KafkaTransaction implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="transaction_id")
	private String transactionId;
	
	@Column(name="status")
	private String status="IP";

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "KafkaTransaction [transactionId=" + transactionId + ", status=" + status + "]";
	}
	
}
