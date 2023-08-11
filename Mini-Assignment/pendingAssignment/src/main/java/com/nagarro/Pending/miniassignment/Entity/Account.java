package com.nagarro.Pending.miniassignment.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {

	
	@Id
	private String transactionId;

	private String accountNumber;
	private String status;
	private String amount;
	private String date;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String transactionId, String accountNumber, String status, String amount, String date) {
		super();
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.status = status;
		this.amount = amount;
		this.date = date;
	}
	
	

}
