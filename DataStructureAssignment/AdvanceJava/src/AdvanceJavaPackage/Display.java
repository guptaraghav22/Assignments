package AdvanceJavaPackage;
import java.io.File;
import java.util.*;
public class Display {
	public static void main(String[] args) {
		String filename="C:\\Users\\raghavgupta05\\Desktop\\Advance Java\\Advance Java\\Assigment Links\\Assigment Links\\Puma.csv";		
		try {
		
			Scanner sc = new Scanner(new File(filename));
				sc.useDelimiter("[|\n]");
				for(int 
						i=0;i<8;i++) {
				System.out.print(sc.next());
				}
				System.out.print(sc.next());
				System.out.print(sc.next());
				System.out.print(sc.next());
				
			
				
				
			
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	
}
