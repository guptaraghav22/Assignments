package com.nagarro.Success.miniassignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.Success.miniassignment.entity.Account;

public interface SuccessRepo extends JpaRepository<Account, String>{

	
	public List<Account> findByaccountNumber(String accountNumber);
}
