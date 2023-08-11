package com.nagarro.training.advance.java1.file.reader;

import java.io.*;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nagarro.training.advance.java1.Tshirt.Product;
import com.nagarro.training.advance.java1.Tshirt.Product.Gender;
import com.nagarro.training.advance.java1.Tshirt.Product.Size;
import com.opencsv.*;


public class ReadCSV {
	public static ArrayList<Product> arrayList;

	public static void readCSVdata() throws Exception {

		System.out.println("Reading CSV File DATA");

		CSVParser csvParser = new CSVParserBuilder().withSeparator('|').build();
		File dir = new File(
				"C:\\Users\\raghavgupta05\\Desktop\\raghav-gupta-AdvanceJava\\Advance-Java-maven-Assignment1\\src\\main\\resources\\Assigment Links");
		File[] files = dir.listFiles();
		arrayList = new ArrayList<Product>();
		if (files != null) {
			for (File file : files) {
				try {
					FileReader fileReader = new FileReader(file);
					CSVReader csvReader = new CSVReaderBuilder(fileReader).withCSVParser(csvParser).withSkipLines(1)
							.build();
					String[] record = null;
					while ((record = csvReader.readNext()) != null) {
						addValues(record);
					}
				} catch (Exception e) {
					System.out.println(e);
				}

			}
		}

	}
    private static void addValues(String[] line) {
        Product t = new Product();
        t.setId(line[0]);
        t.setName(line[1]);
        t.setColour(line[2]);
        t.setGenderRecommendation(line[3].toUpperCase());
        
        t.setSize(line[4].toUpperCase());
        t.setPrice(Float.parseFloat(line[5]));
        t.setRating(Float.parseFloat(line[6]));
        t.setAvailability(line[7]);

        Configuration con = new Configuration().configure().addAnnotatedClass(Product.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Product dupTshirt= session.get(Product.class, line[0]);
         if(dupTshirt==null){
             session.persist(t);
             tx.commit();
         }

}
}
