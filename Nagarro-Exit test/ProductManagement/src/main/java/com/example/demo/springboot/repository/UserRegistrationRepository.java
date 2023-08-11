package com.example.demo.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.springboot.model.Product;
import com.example.demo.springboot.model.User;

public interface UserRegistrationRepository extends JpaRepository<User, Integer>{

	public User findByemailid(String emailid);

	public User findByemailidAndPassword(String emaillid,String password);
	
	
	
}
