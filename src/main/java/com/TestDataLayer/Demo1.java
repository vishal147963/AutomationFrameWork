package com.TestDataLayer;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo1 {
	public static XSSFWorkbook workbook;

	public Demo1(String path) throws Exception {
		File f = new File(path);
		System.out.println(f.exists());
		FileInputStream fis = new FileInputStream(f);
		workbook = new XSSFWorkbook(fis);
	}


	public String getData(int sheetindex, int row, int colm) {
		XSSFSheet sheet = workbook.getSheetAt(sheetindex);
		return sheet.getRow(row).getCell(colm).getStringCellValue();
	}

//	public String getData(int sheetindex, int rows, int cells) {
//
//		XSSFSheet sheet = workbook.getSheetAt(sheetindex);
//
//		String data = sheet.getRow(rows).getCell(cells).getStringCellValue();
//
//		return data;
//	}

	public int getRowCount(int sheetindex) {
		XSSFSheet sheetAt = workbook.getSheetAt(sheetindex);
		return sheetAt.getLastRowNum()+1;
	}

	public int getLastCount(int sheetindex ) {
		XSSFSheet sheet=workbook.getSheetAt(sheetindex);
	return sheet.getRow(0).getLastCellNum();
	
	}
	

	
	
	public static void main(String[] args) throws Exception {
		Demo1 d= new Demo1("C:\\Users\\Vishal\\Documents\\EmpDetails.xlsx");

		String data = d.getData(0, 1, 0);
		System.out.println(data);
		
		int lastCount = d.getLastCount(0);
		System.out.println(lastCount);
		
		int lastCount2 = d.getLastCount(0);
		System.out.println(lastCount2);
		
		
		
	}
	
}
