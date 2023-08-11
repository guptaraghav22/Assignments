package com.example.demo.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.springboot.model.ProductReview;

public interface ProductReviewRepo extends JpaRepository<ProductReview, Integer> {
	
	public List<ProductReview> findByProductcode(Integer productcode);
	


}
