package com.nagarro.training.advance.java1.file.reader;
import java.io.*;
import java.util.*;
import com.nagarro.training.advance.java1.Tshirt.Product;
import com.nagarro.training.advance.java1.Tshirt.Product.Gender;
import com.nagarro.training.advance.java1.Tshirt.Product.Size;
import com.opencsv.*;
public class ReadCSV {
	public static ArrayList < Product> arrayList;
	public static void readCSVdata() throws Exception {
		
		CSVParser csvParser=new CSVParserBuilder().withSeparator('|').build();
		File dir = new File("C:\\Users\\raghavgupta05\\Desktop\\Assignment\\raghavgupta\\Advance-Java-maven\\src\\main\\resources\\Assigment Links"); 
		File[] files = dir.listFiles(); 
		arrayList = new ArrayList < Product> (); 
		  if (files != null) {
		  for (File file: files) {
		    try {
		    	FileReader fileReader=new FileReader(file);
		    	CSVReader csvReader=new CSVReaderBuilder(fileReader).withCSVParser(csvParser).withSkipLines(1).build();
		        String[] record=null;
		        while((record=csvReader.readNext())!=null) {
		        	Product p=new Product(record[0],record[1],record[2],Gender.valueOf(record[3].toUpperCase()),Size.valueOf(record[4].toUpperCase()),Float.parseFloat(record[5]),Float.parseFloat(record[6]),record[7]);
		        	arrayList.add(p);
		      }
		    } 
		    catch (Exception e) {
		      System.out.println(e);
		    } 
		  }}
		  
		  

		}

	
}
