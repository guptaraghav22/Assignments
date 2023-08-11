package com.nagarro.training.advance.java1.Tshirt.display;

import java.util.ArrayList;

import com.nagarro.training.advance.java1.Tshirt.Product;
import com.nagarro.training.advance.java1.Tshirt.search.and.sort.SearchProduct;

public class ShowProduct {
	public static void showProduct(ArrayList<Product> list) {
		for(Product p:list) {
			System.out.println();
			System.out.print("\t|\t"+p.getId());
			System.out.print("\t|\t"+p.getName());
			System.out.print("\t|\t"+p.getSize());
			System.out.print("\t|\t"+p.getColour());
			System.out.print("\t|\t"+p.getGenderRecommendation());
			System.out.print("\t|\t"+p.getPrice());
			System.out.print("\t|\t"+p.getRating());
			System.out.print("\t|\t"+p.getAvailability());
			
		}
		if(list.isEmpty())
			System.out.println("No products matched.");
	}

}
