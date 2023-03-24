package com.UtilsLayer;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	private static XSSFWorkbook workbook;

	public  ExcelReader(String path) {
//		Check the 
		
	File f = new File(path);
	try {
		FileInputStream fis = new FileInputStream(f);
		workbook = new XSSFWorkbook(fis);
	} catch (Exception e) {
	}
	}
	
	public String setData(int sheetIndex, int row, int cell) {
		try {
			return workbook.getSheetAt(sheetIndex).getRow(row).getCell(cell).getStringCellValue();
		} catch (Exception e) 
		{	return workbook.getSheetAt(sheetIndex).getRow(row).getCell(cell).getRawValue();
		}
	}
	
	public int getRowCount(int sheetindex) {
		return workbook.getSheetAt(sheetindex).getLastRowNum() + 1;
	}

	public int getColumnCount(int sheetindex) {
		return workbook.getSheetAt(sheetindex).getRow(0).getLastCellNum();
	}


}
