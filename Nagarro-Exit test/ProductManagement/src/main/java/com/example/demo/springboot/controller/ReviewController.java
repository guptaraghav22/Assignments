package com.example.demo.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.springboot.model.Product;
import com.example.demo.springboot.model.ProductReview;
import com.example.demo.springboot.repository.ProductReviewRepo;
import com.example.demo.springboot.service.ProductReviewService;

@RestController
public class ReviewController {
		
	@Autowired
	public ProductReviewRepo productReviewRepo;
	
	@Autowired
	public ProductReviewService productReviewService ; 
	
	
	@PostMapping("/registerreview")
	@CrossOrigin(origins = "http://localhost:4200")
	public ProductReview registerreview(@RequestBody ProductReview productReview) 
	{
		
			ProductReview pr=productReviewService.savereview(productReview);
			return pr;
	
	}
	

 	@GetMapping("/getreview")
 	@CrossOrigin(origins = "http://localhost:4200")
 	public List<ProductReview> getAllProducts(@RequestParam Integer productcode ){
    	
 		
 		return productReviewRepo.findByProductcode(productcode);	
	
 	}
 	
 	
}