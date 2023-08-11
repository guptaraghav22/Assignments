package com.example.demo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.springboot.JwtHelper.JwtUtil;
import com.example.demo.springboot.model.JwtRequest;
import com.example.demo.springboot.model.JwtResponse;
import com.example.demo.springboot.service.CustomUserDetailService;

@RestController
@CrossOrigin
public class JwtController {

	@Autowired
	private AuthenticationManager authenticationManager; 
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private JwtUtil jwtUtil;

@PostMapping(value="/login")
@CrossOrigin
public  ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
{
	System.out.println(jwtRequest);
	
	try 
	{
		this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmailid(), jwtRequest.getPassword()));
		
	}
	catch(UsernameNotFoundException e) 
	{
		e.printStackTrace();
		throw new Exception("Bad Credentials");
	}
	catch(BadCredentialsException e) 
	{
		e.printStackTrace();
		throw new Exception("Bad Credentials");
	}
	
	UserDetails userDetails = this.customUserDetailService.loadUserByUsername(jwtRequest.getEmailid());
	String token =this.jwtUtil.generateToken(userDetails);
	System.out.println("jwt token is"+token);
	return ResponseEntity.ok(new JwtResponse(token));
}	
	
}
