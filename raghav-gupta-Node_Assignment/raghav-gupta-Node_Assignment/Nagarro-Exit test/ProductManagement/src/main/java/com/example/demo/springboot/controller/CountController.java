package com.example.demo.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.springboot.repository.ProductRepo;
import com.example.demo.springboot.repository.ProductReviewRepo;
import com.example.demo.springboot.repository.UserRegistrationRepository;

@RestController
public class CountController  {
	
	@Autowired
	ProductRepo productrepo;
	
	@Autowired
	ProductReviewRepo productReviewRepo;
	
	@Autowired
	UserRegistrationRepository userRegistrationRepository ;

	@GetMapping("/count")
	public List<Integer> getcount()
	{
		List<Integer> list =new ArrayList<Integer>();
		list.add((int)productReviewRepo.count());
		list.add((int)productrepo.count());
		list.add((int)userRegistrationRepository.count());
		return list;
		
	}
	
}
