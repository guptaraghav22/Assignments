package com.account.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.account.model.Accounts;


@FeignClient(name="SUCCESS-SERVICE")
public interface SuccessService {

	@GetMapping("/backendserver1/success/{AccountNumber}")
	public List<Accounts> getSuccessTransaction(@PathVariable String AccountNumber);
	
}
