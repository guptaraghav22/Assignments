package com.example.demo.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.springboot.model.User;
import com.example.demo.springboot.repository.UserRegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private UserRegistrationRepository repo;
	
	public User saveuser(User userr) 
	{
		repo.save(userr);
		return userr;
	}
	
	
	public User findbyemailid(String emailid) 
	{	
		
		return repo.findByemailid(emailid);
	}
	
	
	public User Loginuser(String emailid,String password) 
	{
		return repo.findByemailidAndPassword(emailid, password);
	}
	
	
}
