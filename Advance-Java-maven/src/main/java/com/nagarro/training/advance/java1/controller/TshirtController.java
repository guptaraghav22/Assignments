package com.nagarro.training.advance.java1.controller;

import java.util.ArrayList;
import java.util.Scanner;


import com.nagarro.training.advance.java1.Tshirt.Product;
import com.nagarro.training.advance.java1.Tshirt.Product.Gender;
import com.nagarro.training.advance.java1.Tshirt.Product.Size;
import com.nagarro.training.advance.java1.Tshirt.search.and.sort.SearchProduct;
import com.nagarro.training.advance.java1.file.reader.FileReaderThread;
import com.nagarro.training.advance.java1.file.reader.ReadCSV;
import com.nagarro.training.advance.java1.input_validator.InputValidate;

public class TshirtController {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String ans="y";
		String colour=null;
		Size size=null;
		Gender gender=null;
		String outputPreference=null;
		while(ans.equalsIgnoreCase("y")) {
			FileReaderThread t=new FileReaderThread();
			t.start();
			t.join();
		
			
			System.out.println("Filter Tshirts by colour, size and gender --->");
			
			System.out.println("Colour:");
			colour=sc.nextLine();
			
			size=InputValidate.SizeInputAndValidate();
			
			gender=InputValidate.GenderValidate();
			
			outputPreference=InputValidate.outputPreferenceValidate();
			
			
			SearchProduct matchList=new SearchProduct();
			try {
				ArrayList<Product> list=ReadCSV.arrayList;
				matchList.searchProduct(list, colour, size, gender,outputPreference);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println();
			System.out.println("Want to search again. Press y/n.");
			ans=sc.nextLine();
		}
		if(ans.equalsIgnoreCase("n")) {
			System.out.println("Thank you! Goodbye.");
		}
		
	}

}
