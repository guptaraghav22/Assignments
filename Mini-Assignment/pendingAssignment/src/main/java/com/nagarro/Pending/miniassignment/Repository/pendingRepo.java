package com.nagarro.Pending.miniassignment.Repository;

import java.util.List;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AcceptAction;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.Pending.miniassignment.Entity.Account;

public interface pendingRepo extends JpaRepository<Account,String> 
{
	
	public List<Account> findByaccountNumber(String accountNumber);
}
