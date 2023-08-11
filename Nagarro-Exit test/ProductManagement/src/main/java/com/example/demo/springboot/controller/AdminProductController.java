package com.example.demo.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.springboot.model.Product;
import com.example.demo.springboot.model.ProductReview;
import com.example.demo.springboot.repository.ProductRepo;
import com.example.demo.springboot.repository.ProductReviewRepo;

@RestController
public class AdminProductController {


	@Autowired
	public ProductRepo productrepo;
	
	@Autowired
	public ProductReviewRepo productReviewRepo;

  	
  	@GetMapping("/adminproducts")
  	@CrossOrigin(origins = "http://localhost:4200")
	public List<ProductReview> getallreviews()
  	{
  		return productReviewRepo.findAll();
  	}
  	
  	@PutMapping("/updatereview")
  	@CrossOrigin(origins = "http://localhost:4200")
  	public void update(@RequestBody int id) 
  	{	
  		ProductReview productReview=productReviewRepo.getById(id);
  		productReview.setApproved(1);
  	    productReviewRepo.save(productReview);
		  
  		
  	}
  	
  	@PutMapping("/updatereviewdelete")
  	@CrossOrigin(origins = "http://localhost:4200")
  	public void updatee(@RequestBody int id) 
  	{	
  		ProductReview productReview=productReviewRepo.getById(id);
  		productReview.setApproved(0);
  	    productReviewRepo.save(productReview);
		  
  		
  	}

}
