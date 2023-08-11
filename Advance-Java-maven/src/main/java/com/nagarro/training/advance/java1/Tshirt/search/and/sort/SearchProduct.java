package com.nagarro.training.advance.java1.Tshirt.search.and.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.nagarro.training.advance.java1.Tshirt.Product;
import com.nagarro.training.advance.java1.Tshirt.Product.Gender;
import com.nagarro.training.advance.java1.Tshirt.Product.Size;
import com.nagarro.training.advance.java1.Tshirt.display.ShowProduct;

public class SearchProduct implements Comparator<Product> {
	 ArrayList<Product> matchingList =new ArrayList<Product>();
	public void searchProduct(ArrayList<Product> list,String colour, Size size, Gender gender,String outputPreference) {
		
		for(Product p:list) {
			
			if(p.getColour().equalsIgnoreCase(colour) && p.getSize().equals(size)&& p.getGenderRecommendation().equals(gender) )
			{
				Product prod=new Product(p.getId(),p.getName(),p.getColour(),p.getGenderRecommendation(),p.getSize(),p.getPrice(),p.getRating(),p.getAvailability());
				matchingList.add(prod);
			}
		}
		SortProduct.sortProducts(outputPreference,matchingList);
	}
	public int compare(Product o1, Product o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
