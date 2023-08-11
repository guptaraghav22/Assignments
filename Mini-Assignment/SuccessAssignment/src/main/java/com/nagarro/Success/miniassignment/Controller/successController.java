package com.nagarro.Success.miniassignment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.Success.miniassignment.entity.Account;
import com.nagarro.Success.miniassignment.serviceImpl.ServiceImpl;

@RestController
public class successController {

	@Autowired
	public ServiceImpl serviceImpl;
	
	
	@GetMapping("backendserver1/success/{accountno}")
	public List<Account> getbyaccountNo(@PathVariable String accountno)
	{
		return serviceImpl.getbyAccountno(accountno);
	}
	
}
