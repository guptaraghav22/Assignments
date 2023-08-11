package com.example.demo.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.springboot.model.Product;
import com.example.demo.springboot.model.User;
import com.example.demo.springboot.service.RegistrationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController 
{	
	
	
	@Autowired
	private RegistrationService regservice;
	
	@GetMapping("/check")
	public String checking() 
	{
		return "check";
	}
	
	@PostMapping("/register")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registeruser(@RequestBody User user) throws Exception 
	{
		String emailcheck=user.getEmailid();
		if(emailcheck!=null && !"".equals(emailcheck)) 
		{
			User userobj =regservice.findbyemailid(emailcheck);
			if(userobj!=null) 
			{
				throw new Exception("user with "+emailcheck+"alredy exists");
			}
	
		
		
		
		
		}	
		
//		User userobj=null;
//		userobj=regservice.saveuser(user);
//		return userobj;
//	
		User userObj = null;
        String password = user.getPassword();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        user.setPassword(hashedPassword);
        userObj = regservice.saveuser(user);
        return userObj;	
	}
//	
//	@PostMapping("/login")
//	@CrossOrigin(origins = "http://localhost:4200")
//	public  User Login(@RequestBody User user) throws Exception
//	{
//		String tempemail=user.getEmailid();
//		System.out.println(tempemail);
//		String temppass=user.getPassword();
//		User Userobj=null;
//		if(tempemail!=null && temppass!=null) {
//			
//			 Userobj = regservice.Loginuser(tempemail, temppass);
//			
//		
//		}
//		if(Userobj==null) 
//		{
//			throw new Exception("No User Found");
//		}
//		
//		return Userobj;
//		
//		
//		
//	}
//	
	
}
