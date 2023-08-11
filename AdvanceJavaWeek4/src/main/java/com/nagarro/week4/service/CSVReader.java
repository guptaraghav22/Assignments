package com.nagarro.week4.service;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import com.nagarro.week4.model.Tshirt;
import com.nagarro.week4.dao.TshirtDao;
import com.nagarro.week4.enums.*;

@Component
public class CSVReader {

	@Autowired
	TshirtDao tshirtdao;

	public void getAllTshirts() {
		String folderPath = "/Assignment4/src/main/resources";
		System.out.print(folderPath);
		String[] filepath = getAllFilePath(folderPath);

		System.out.println(Arrays.toString(filepath));
		for (String i : filepath) {
			System.out.println(i);
			CSVReaderMethod(i);
		}
	}

	public String[] getAllFilePath(String path) {

		File directoryPath = new File(path);

		File filesList[] = directoryPath.listFiles();

		String[] pathList = new String[filesList.length];
		int i = 0;
		for (File file : filesList) {
			pathList[i++] = file.getAbsolutePath();
		}

		System.out.println(filesList);

		return pathList;
	}

	private void CSVReaderMethod(String filePath) {

		try {
			CSVParser parser = new CSVParserBuilder().withSeparator('|').withIgnoreQuotations(true).build();
			com.opencsv.CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath)).withCSVParser(parser)
					.withSkipLines(1).build();

			String[] line;
			try {
				while ((line = csvReader.readNext()) != null) {
					Tshirt tshirt = new Tshirt();
					tshirt.setId(line[0]);
					tshirt.setName(line[1]);
					tshirt.setColor(Color.valueOf(line[2].toUpperCase()).toString());
					tshirt.setGender(Gender.valueOf(line[3].toUpperCase()).toString());
					tshirt.setSize(Size.valueOf(line[4].toUpperCase()).toString());
					tshirt.setPrice(Double.parseDouble(line[5]));
					tshirt.setRating(Double.parseDouble(line[6]));
					tshirt.setAvailability(line[7]);

					System.out.println(tshirt.getId());

					tshirtdao.save(tshirt);
				}

			} catch (IOException e) {
				e.printStackTrace();
			} catch (CsvValidationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
