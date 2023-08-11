package com.nagarro.failure.miniassignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.failure.miniassignment.model.Account;
import com.nagarro.failure.miniassignment.service.service;

@RestController
public class Controller {

	@Autowired
	public service accService;
	
	
	@GetMapping("backendserver2/failure/{accountno}")
	public List<Account> getAccountbyAccountNo(@PathVariable String accountno) 
	{
		return accService.getbyaccountno(accountno);
		
	}
	
	
	
	
}
