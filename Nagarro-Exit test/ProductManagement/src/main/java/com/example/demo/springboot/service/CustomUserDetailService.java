package com.example.demo.springboot.service;

import java.io.Serial;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.springboot.model.CustomUserDetails;
import com.example.demo.springboot.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.springboot.repository.UserRegistrationRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRegistrationRepository userRegistrationRepository; 
	
	@Override
	public UserDetails loadUserByUsername(String emailid) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		/*
		 * if(email.equals("abc@gmail.com")) { System.out.println("axn"); return new
		 * User("abc@gmail.com", "abc",new ArrayList<>()); }
		 * 
		 * else { throw new UsernameNotFoundException("user not registered"); }
		 */
		User user = this.userRegistrationRepository.findByemailid(emailid);
		if(user==null) 
		{
			System.out.println("Raghav");
			throw new UsernameNotFoundException("User not registered");
		}
		else 
		{
			return new CustomUserDetails(user);
		}
	}
	
	
	

}
