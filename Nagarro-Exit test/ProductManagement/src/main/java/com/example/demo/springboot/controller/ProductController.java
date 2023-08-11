package com.example.demo.springboot.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.springboot.model.Product;
import com.example.demo.springboot.repository.ProductRepo;

@RestController
public class ProductController {

		@Autowired
		public ProductRepo productrepo;
	
	  	@GetMapping("/product")
	  	@CrossOrigin(origins = "http://localhost:4200")
		public List<Product> getAllProducts(){
	        System.out.println("productrepo.findAll()");
	  		return productrepo.findAll();
	    }
	  
	
	
}
