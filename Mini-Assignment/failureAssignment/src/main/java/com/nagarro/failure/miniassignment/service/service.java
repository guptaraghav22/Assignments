package com.nagarro.failure.miniassignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.failure.miniassignment.Repository.AccountRepo;
import com.nagarro.failure.miniassignment.model.Account;


@Service
public class service {

	@Autowired
	public AccountRepo accrepoo;
	
	
	public List<Account> getbyaccountno(String accountno) 
	{
		return accrepoo.findByaccountNumber(accountno);
	}
	
	
	
}
