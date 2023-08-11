package com.account.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.account.model.Accounts;


@FeignClient(name="PENDING-SERVICE")
public interface PendingService {

	@GetMapping("/backendserver3/pending/{AccountNumber}")
	public List<Accounts> getSuccessTransaction(@PathVariable String AccountNumber);
	
}
