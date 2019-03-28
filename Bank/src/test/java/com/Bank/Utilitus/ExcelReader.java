package com.Bank.Utilitus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;



public class ExcelReader {
	
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;

	
	public ExcelReader(String path) {
		
		this.path = path;
		try {
			File file = new File(path);
			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e ) {
			System.out.println("Error not inizializate fis");
		}
	}

	public int getRowCount(String string) {
		//Read sheet inside the workbook by its name
		
		sheet = workbook.getSheet(string);
		//Find number of rows in excel file
		
		 int rowCount = sheet.getLastRowNum()- sheet.getFirstRowNum();
		
		 return rowCount;
	}

	public int getColomnCount(String string) {
		//read sheet inside the workbook by its name
		
		sheet = workbook.getSheet(string);
		
		int colomnCount = sheet.getRow(0).getLastCellNum();
		return colomnCount;
	}

	public Object getCellData(String string, int colNum, int rowNum) {
		sheet = workbook.getSheet(string);

		Row row = sheet.getRow(rowNum-1);

		System.out.print(row.getCell(colNum).getStringCellValue()+"|| ");

		return row.getCell(colNum).getStringCellValue();
	

	}
}
