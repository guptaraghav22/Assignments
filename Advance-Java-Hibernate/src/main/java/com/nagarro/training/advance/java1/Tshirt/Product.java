package com.nagarro.training.advance.java1.Tshirt;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", colour=" + colour + ", genderRecommendation="
				+ genderRecommendation + ", size=" + size + ", price=" + price + ", rating=" + rating
				+ ", availability=" + availability ;
	}
	public Product(){}
	public Product(String id, String name, String colour, String genderRecommendation, String size, float price,
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
	public String getGenderRecommendation() {
		return genderRecommendation;
	}
	public void setGenderRecommendation(String genderRecommendation) {
		this.genderRecommendation = genderRecommendation;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
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
	@Id
	private String id;
	private String name;
	private String colour;
	private String genderRecommendation;
	private String size;
	private float price;
	private float rating;
	private String availability;
	
	public enum Size{
		S,M,L,XL;

	}
	public enum Gender{
		M,F,U;
	}
}
