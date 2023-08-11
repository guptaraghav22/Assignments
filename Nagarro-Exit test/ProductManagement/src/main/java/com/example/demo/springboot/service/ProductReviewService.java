package com.example.demo.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.springboot.model.ProductReview;
import com.example.demo.springboot.repository.ProductReviewRepo;

@Service
public class ProductReviewService  {
	
	@Autowired
	public ProductReviewRepo productReviewRepo;
	
	
	
	public ProductReview savereview (ProductReview productReview )
	{
		
		productReviewRepo.save(productReview); 
		return productReview ;
	}
	
	
	public ProductReview findByprodcode(Integer productcode)
	{
		ProductReview pr= (ProductReview) productReviewRepo.findByProductcode(productcode);
		System.out.println(pr);
		return pr;
		
	}
}
