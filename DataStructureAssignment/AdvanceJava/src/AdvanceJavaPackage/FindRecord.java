package AdvanceJavaPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class FindRecord {
	public static void DisplayInfo(String ID) {
		try {
			System.out.print("hy");
			String filename="C:\\Users\\raghavgupta05\\Desktop\\Advance Java\\Advance Java\\Assigment Links\\Assigment Links\\Puma.csv";		
			Scanner sc = new Scanner(new File(filename));
			sc.useDelimiter("[|\n]");
			
			boolean found = false;
			String id="";
			String Name="";
			String Color = "";
			String Gr="";
			String Size="";
			String price="";
			String Rating="";
			String Availability="";
			while(sc.hasNext() && !found) 
			{
				id=sc.next();
				Name=sc.next();
				Color=sc.next();
				Gr=sc.next();
				Size=sc.next();
				price=sc.next();
				Rating=sc.next();
				Availability=sc.next();
				if(id.equals(ID)) 
				{	System.out.println("true");
					found=true;
				}
				if(found==true) 
				{
					System.out.println("ProductID"+id+"Name"+Name+"Color"+Color+"Gr"+Gr+"Size"+Size+"Price"+price+"Rating"+Rating+"Availability"+Availability);
					
				}
				else 
				{
					System.out.println("FNF");
				}
			}
			
			
		}
		catch (FileNotFoundException e) 
		{
			System.out.print(e);
		}
	}

	public static void main(String[] args) {	
		DisplayInfo("PU847760SB");

	}
}
