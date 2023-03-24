package com.UtilsLayer;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader1 {
	public static FileInputStream fis;
	public static XSSFWorkbook workbook ;
	public ExcelReader1(String path) throws Exception {
		File f= new File(path);
		fis = new FileInputStream(f);
		workbook = new XSSFWorkbook(fis);
	}
	public String getData(int sheetindex, int row, int col) {
		 workbook.getSheetAt(sheetindex).getRow(row).getCell(col).getStringCellValue();
		return workbook.getSheetAt(sheetindex).getRow(row).getCell(col).getRawValue();
	}
	
	public int getRowCount(int sheetindex) {
		return workbook.getSheetAt(sheetindex).getLastRowNum()+1;
	} 
	
	public int getColumCount(int sheetindex) {
		return workbook.getSheetAt(sheetindex).getRow(0).getLastCellNum();
		
	}
}
