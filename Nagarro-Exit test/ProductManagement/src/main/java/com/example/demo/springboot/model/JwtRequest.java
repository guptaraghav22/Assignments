package com.example.demo.springboot.model;

public class JwtRequest {

	String emailid;
	String password;
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public JwtRequest(String emailid, String password) {
		super();
		this.emailid = emailid;
		this.password = password;
	}
	public JwtRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
