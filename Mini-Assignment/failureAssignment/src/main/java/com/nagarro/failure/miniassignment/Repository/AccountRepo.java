package com.nagarro.failure.miniassignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import com.nagarro.failure.miniassignment.model.Account;



public interface AccountRepo extends JpaRepository<Account, String> {
	
	public List<Account> findByaccountNumber(String accountNumber);

}
