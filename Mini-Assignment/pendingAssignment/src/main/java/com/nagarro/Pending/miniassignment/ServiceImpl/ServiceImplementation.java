package com.nagarro.Pending.miniassignment.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.nagarro.Pending.miniassignment.Entity.Account;
import com.nagarro.Pending.miniassignment.Repository.pendingRepo;
import com.nagarro.Pending.miniassignment.Service.Services;


@Service
public class ServiceImplementation implements Services {

	@Autowired
	public pendingRepo pendRepo;
	
	@Override
	public List<Account> getbyAccountno(String Accountno) {
		// TODO Auto-generated method stub
		return pendRepo.findByaccountNumber(Accountno);
	}

}
