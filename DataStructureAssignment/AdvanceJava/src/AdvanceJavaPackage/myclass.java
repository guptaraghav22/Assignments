package AdvanceJavaPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class myclass {
	public static void csv(String FileName) 
	{	
	try{
		Scanner sc = new Scanner(new File(FileName));
		while(sc.hasNext()) 
		{
			System.out.println(sc.next());
		}
		sc.close();
	}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}

		
	}
	public static void main(String[] args)
	{
		
		csv("C:\\Users\\raghavgupta05\\Desktop\\Advance Java\\Advance Java\\Assigment Links\\Assigment Links\\Adidas.csv");	
		
	}
}
