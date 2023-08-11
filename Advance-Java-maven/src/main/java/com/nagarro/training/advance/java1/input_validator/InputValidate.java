package com.nagarro.training.advance.java1.input_validator;

import java.util.Scanner;

import com.nagarro.training.advance.java1.Tshirt.Product.Gender;
import com.nagarro.training.advance.java1.Tshirt.Product.Size;

//import acom.nagarro.fresher.training.Car.Validator.InvalidInputException;;

public class InputValidate {
	static Scanner sc=new Scanner(System.in);
	
	//------------------------------size----------------------

	public static Size SizeInputAndValidate() {
		
		while(true) {
		try {
			System.out.println("Size(S/M/L/XL):");
			String size1 = sc.nextLine();
			Size size=Size.valueOf(size1.toUpperCase());
			return size;
			}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("Try again.");
			
		}
		
		}
	}
	//------------------------------gender----------------------

		public static Gender GenderValidate() {
			
			while(true) {
				try {
					System.out.println("Gender(M/F/U):");
					String gender1 = sc.nextLine();
					Gender gender=Gender.valueOf(gender1.toUpperCase());
					return gender;
					}
				catch(Exception e) {
					System.out.println(e);
					System.out.println("Try again.");
					
				}
				
			}
		}
	
		//------------------------------output Preference----------------------

				public static String outputPreferenceValidate() {
					while(true) {
						try {
							System.out.println("Sort by price or rating:");
							String outputPreference=sc.nextLine();
							if(outputPreference.equalsIgnoreCase("rating") || outputPreference.equalsIgnoreCase("price") )
							{
								return outputPreference;
							}
							else {throw new Exception("Incorrect value");}
							
							
						}
						
						catch(Exception e) {
							System.out.println(e);
							System.out.println("Try again.");
						}
					}
				}
			
	
	
}
