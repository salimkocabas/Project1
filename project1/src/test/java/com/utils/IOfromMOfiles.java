package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class IOfromMOfiles {

 private static FileInputStream fis;
 private static Workbook wb;
 private static Sheet sheet;

	public static void openExcel (String filepath, String sheetName) {
		
		try {
		fis= new FileInputStream (filepath);
		 wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(sheetName);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int rowCount() {
		
		return sheet.getPhysicalNumberOfRows();
		
	}
	public static int colCount() {
		
		return sheet.getRow(0).getLastCellNum();
	}
	public static String getCellData(int rowIndex, int cellIndex) {
		
		return sheet.getRow(rowIndex).getCell(cellIndex).toString();
	}
	public static Object[][] excellintoArray(String filepath, String sheetName){
		openExcel(filepath,sheetName);
		int rows=rowCount();
		int cols = colCount();
		Object[][] data= new Object [rows-1][cols];
		for (int i=1; i<rows; i++) {
			for(int y=0; y<cols; y++) {
				data[i-1][y]=getCellData(i,y);
			}
		}
		return data;	
	}
	
	public static void closeExcel() throws IOException {
		fis.close();
		wb.close();	
	}
	
	public static void changeCellValue(String filepath, String sheetName, int targetRow, int targetCell, String value) throws FileNotFoundException {
		try {
			fis= new FileInputStream(filepath);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(sheetName);
		sheet.getRow(targetRow).getCell(targetCell).setCellValue(value);
		FileOutputStream fos = new FileOutputStream(filepath);
		wb.write(fos);
		fos.close();
		wb.close();
		fis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void writetoExcel(String filepath, String sheetName, int targetRow, int targetCell, String value) throws FileNotFoundException {
		try {
			fis= new FileInputStream(filepath);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(sheetName);
		sheet.createRow(targetRow).createCell(targetCell).setCellValue(value);
		FileOutputStream fos = new FileOutputStream(filepath);
		wb.write(fos);
		fos.close();
		wb.close();
		fis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	
		
	}
	
}
