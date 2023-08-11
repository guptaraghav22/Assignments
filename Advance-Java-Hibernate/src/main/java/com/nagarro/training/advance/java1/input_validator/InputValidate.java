package com.nagarro.training.advance.java1.input_validator;

import java.util.Scanner;

import com.nagarro.training.advance.java1.Tshirt.Product.Gender;
import com.nagarro.training.advance.java1.Tshirt.Product.Size;

//import acom.nagarro.fresher.training.Car.Validator.InvalidInputException;;

public class InputValidate {
	static Scanner sc=new Scanner(System.in);
	
	//------------------------------size----------------------

	public static String SizeInputAndValidate() {
			boolean val=true;
		while(val) {
		
			System.out.println("Size(S/M/L/XL):");
			String size1 = sc.nextLine();
			String size=size1.toUpperCase();
			
			if(size.equals("S")||size.equals("M")||size.equals("L")||size.equals("XL"))
			{	val=false;
				
				return size;
			}
			else {
				System.out.println("Try again.");
			}
		
		
		
		}
		return null;
	}
	//------------------------------gender----------------------

		public static String GenderValidate() {
			boolean val=true;
			while(val) {
				
					System.out.println("Gender(M/F/U):");
					String gender1 = sc.nextLine();
					String gender=gender1.toUpperCase();
					if(gender.equals("F")||gender.equals("M")||gender.equals("U"))
					{		val=false;
							return gender;
							
					}
					else {
						System.out.println("Try again.");
						
					}
					
					
				
				
			}
			return null;
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
