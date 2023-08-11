package com.nagarro.csvfiles;


	public class FileReaderThread extends Thread{
		public void run(){  
			
			try {
				CsvReading.readCSVdata();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
	}
}
