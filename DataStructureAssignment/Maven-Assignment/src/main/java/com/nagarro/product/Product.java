package com.nagarro.product;

public class Product {
	private String id;
	private String name;
	private String colour;
	private Gender genderRecommendation;
	private Size size;
	private float price;
	private float rating;
	private String availability;
	
	public enum Size{
		S,M,L,XL;

	}
	public enum Gender{
		M,F,U;
	}
	public Product(String id, String name, String colour, Gender genderRecommendation, Size size, float price,
			float rating, String availability) {
		super();
		this.id = id;
		this.name = name;
		this.colour = colour;
		this.genderRecommendation = genderRecommendation;
		this.size = size;
		this.price = price;
		this.rating = rating;
		this.availability = availability;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public Gender getGenderRecommendation() {
		return genderRecommendation;
	}
	public void setGenderRecommendation(Gender genderRecommendation) {
		this.genderRecommendation = genderRecommendation;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}

}
