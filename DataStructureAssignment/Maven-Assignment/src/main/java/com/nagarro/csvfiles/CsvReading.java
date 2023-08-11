package com.nagarro.csvfiles;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import com.nagarro.product.Product;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;



public class CsvReading {
	public static ArrayList < Product> arrayList;
	public static void readCSVdata() throws Exception {
		
		
		File dir = new File("C:\\Users\\raghavgupta05\\Desktop\\Assignment\\raghav-gupta\\DataStructureAssignment\\Maven-Assignment\\src\\main\\resources\\AssignmentLinks"); //folder directory where all csv files are stored

		
		File[] files = dir.listFiles(); 

		  
		  arrayList = new ArrayList <Product> (); 
		  
		  CSVParser csvParser=new CSVParserBuilder().withSeparator('|').build();
		  if (files != null) {
		  for (File file: files) {
		    try {
		    	FileReader fileReader=new FileReader(file);
		    	CSVReader csvReader=new CSVReaderBuilder(fileReader).withCSVParser(csvParser).withSkipLines(1).build();
		        String[] record=null;
		        while((record=csvReader.readNext())!=null) {
		        	
		      }
		    } 
		    catch (Exception e) {
		      System.out.println(e);
		    } 
		  }}
		  
		  

		}
}
