package com.nagarro.training.advance.java1.controller;

import java.util.ArrayList;

import java.util.Scanner;

import com.nagarro.training.advance.java1.Tshirt.Product;
import com.nagarro.training.advance.java1.Tshirt.Product.Gender;
import com.nagarro.training.advance.java1.Tshirt.Product.Size;
import com.nagarro.training.advance.java1.Tshirt.search.and.sort.PriceOutput;
import com.nagarro.training.advance.java1.Tshirt.search.and.sort.RatingOutput;
import com.nagarro.training.advance.java1.file.reader.FileReaderThread;
import com.nagarro.training.advance.java1.file.reader.ReadCSV;
import com.nagarro.training.advance.java1.input_validator.InputValidate;

public class TshirtController {
	public static String[] inputarr = new String[4];
	public static void main(String[] args) throws Exception {
		System.out.println("Running First Assignment");
		
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String ans = "y";
		String colour = null;
		String size = null;
		String gender = null;
		String outputPreference = null;
		while (ans.equalsIgnoreCase("y")) {
			FileReaderThread t = new FileReaderThread();
			t.start();
			t.join();

			System.out.println("Filter Tshirts by colour, size and gender --->");

			System.out.println("Colour:");
			colour = sc.nextLine();
			inputarr[0]=colour;
			size = InputValidate.SizeInputAndValidate();
			inputarr[1]=size;
			
			gender = InputValidate.GenderValidate();
			inputarr[2]=gender;
			
			outputPreference = InputValidate.outputPreferenceValidate();
			inputarr[3]=outputPreference;
			System.out.println(inputarr.toString());
			if(outputPreference.equalsIgnoreCase("price")) 
			{
				PriceOutput.getPriceOutput(inputarr);
			}
			if(outputPreference.equalsIgnoreCase("rating")) 
			{
				RatingOutput.getRatingOutput(inputarr);
				
			}
			System.out.println();
			System.out.println("Want to search again. Press y/n.");
			ans = sc.nextLine();
		if (ans.equalsIgnoreCase("n")) {
			
			System.out.println("Thank you! Goodbye.");
		}

	}

	}}
