package com.nagarro.training.advance.java1.Tshirt.search.and.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.nagarro.training.advance.java1.Tshirt.Product;
import com.nagarro.training.advance.java1.Tshirt.display.ShowProduct;

public class SortProduct {
	public static void sortProducts(String outputPreference,ArrayList<Product>matchingList) {
		if(outputPreference.equalsIgnoreCase("price")) {
			Collections.sort(matchingList,new Comparator<Product>() {
				public int compare(Product p1,Product p2) {
					return (int)(p1.getPrice()-p2.getPrice());
				}
			});
		}
		if(outputPreference.equalsIgnoreCase("rating")) {
			Collections.sort(matchingList,new Comparator<Product>() {
				public int compare(Product p1,Product p2) {
					return (int)(p2.getRating()-p1.getRating());
				}
			});
		}
		ShowProduct.showProduct(matchingList);
	}
	public int compare(Product o1, Product o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
