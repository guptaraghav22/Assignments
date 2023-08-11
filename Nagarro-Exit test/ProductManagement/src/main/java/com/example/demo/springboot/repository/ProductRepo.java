package com.example.demo.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.springboot.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	
	
}
