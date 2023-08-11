package com.nagarro.Pending.miniassignment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.Pending.miniassignment.Entity.Account;
import com.nagarro.Pending.miniassignment.ServiceImpl.ServiceImplementation;

@RestController
public class pendingController {

	@Autowired
	public ServiceImplementation serviceImplementation;
	
	
	@GetMapping("backendserver3/pending/{accountno}")
	public List<Account> getAccountbyAccountNo(@PathVariable String accountno) 
	{
		return serviceImplementation.getbyAccountno(accountno);
		
	}
	
	
}
