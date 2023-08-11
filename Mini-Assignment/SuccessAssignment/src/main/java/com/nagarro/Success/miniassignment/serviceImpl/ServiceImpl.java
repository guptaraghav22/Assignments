package com.nagarro.Success.miniassignment.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.Success.miniassignment.entity.Account;
import com.nagarro.Success.miniassignment.repository.SuccessRepo;
import com.nagarro.Success.miniassignment.service.SuccessService;

@Service
public class ServiceImpl implements SuccessService{

	@Autowired
	private SuccessRepo successRepo;
	
	@Override
	public List<Account> getbyAccountno(String Accountno) {
		// TODO Auto-generated method stub
		return successRepo.findByaccountNumber(Accountno) ;
	}

	
	
}
