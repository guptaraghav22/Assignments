package com.nagarro.mainprogram;

import java.util.Scanner;

import com.nagarro.csvfiles.FileReaderThread;
import com.nagarro.product.Product.Gender;
import com.nagarro.product.Product.Size;

public class MainProgram {

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
		
	}

	}
	}
