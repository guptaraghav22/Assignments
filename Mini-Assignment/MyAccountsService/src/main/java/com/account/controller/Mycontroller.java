package com.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.account.model.Accounts;
import com.account.service.FailureService;
import com.account.service.PendingService;
import com.account.service.SuccessService;

@RestController
public class Mycontroller {

	@Autowired
	SuccessService successService;
	
	@Autowired
	FailureService failureService;
	
	@Autowired
	PendingService pendingService;
	
	@GetMapping("transactions/{AccountNumber}/{status}")
	List<Accounts> getData(@PathVariable String AccountNumber, @PathVariable String status){
		List<Accounts> myData=null;
		if(status=="success")
		  myData=successService.getSuccessTransaction(AccountNumber);
		else if(status=="failure")
			myData=failureService.getSuccessTransaction(AccountNumber);
		else if(status=="pending")
			myData=pendingService.getSuccessTransaction(AccountNumber);
		else if(status=="all") {
			List<Accounts> successData=successService.getSuccessTransaction(AccountNumber);
			List<Accounts> failureData=failureService.getSuccessTransaction(AccountNumber);
			List<Accounts> pendingData=pendingService.getSuccessTransaction(AccountNumber);	
		}
		return myData;
	}
	
}
