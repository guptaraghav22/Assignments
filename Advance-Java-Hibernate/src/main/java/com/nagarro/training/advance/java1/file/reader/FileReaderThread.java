package com.nagarro.training.advance.java1.file.reader;

public class FileReaderThread extends Thread{
	public void run(){  
		
		try {
			ReadCSV.readCSVdata();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
}
	}
