package com.example.demo.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductReview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer  id;
	public Integer productcode;
	public Integer productrating;
	public String productreview;
	public String emailid;
	public Integer approved;
	public Integer getApproved() {
		return approved;
	}
	public void setApproved(Integer approved) {
		this.approved = approved;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public Integer getProductcode() {
		return productcode;
	}
	public void setProductcode(Integer productcode) {
		this.productcode = productcode;
	}
	public Integer getProductrating() {
		return productrating;
	}
	public void setProductrating(Integer productrating) {
		this.productrating = productrating;
	}
	public String getProductreview() {
		return productreview;
	}
	public void setProductreview(String productreview) {
		this.productreview = productreview;
	}
	public ProductReview(Integer productcode, Integer productrating, String productreview) {
		super();
		this.productcode = productcode;
		this.productrating = productrating;
		this.productreview = productreview;
	}
	public ProductReview() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
