package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadingfromFile {

	Properties prop;
	public void read() {
		String filepath="/Users/macbook/Desktop/SeleniumJava/HRMS/src/test/java/com/practice/example.txt";
		try {
			FileInputStream fis= new FileInputStream(filepath);
			prop= new Properties();
			prop.load(fis);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		String value=prop.getProperty("company");
		System.out.println(value);
				
		
	}
}
