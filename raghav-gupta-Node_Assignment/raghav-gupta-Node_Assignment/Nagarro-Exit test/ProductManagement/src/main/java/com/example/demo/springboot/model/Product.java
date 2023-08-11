package com.example.demo.springboot.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int productCode;
	public String productName;
	public String productBrand;
	public String productImage;
	public String productDescription;
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Product(int productCode, String productName, String productBrand, String productImage,
			String productDescription) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productBrand = productBrand;
		this.productImage = productImage;
		this.productDescription = productDescription;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
