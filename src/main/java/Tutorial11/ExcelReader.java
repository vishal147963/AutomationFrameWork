package Tutorial11;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;

	public ExcelReader(String path) {
		File f = new File(path);
		boolean exists = f.exists();
		System.out.println(exists);
		try {
			fis = new FileInputStream(f);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
		}

	}

	public String getdata(int sheetindex, int row, int cell) {
		XSSFSheet sheet = workbook.getSheetAt(sheetindex);
		try {
			return sheet.getRow(row).getCell(cell).getStringCellValue();
		} catch (Exception e) {
			return sheet.getRow(row).getCell(cell).getRawValue();
		}
	}

	public int getRowCount(int sheetIndex) {
		XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
		int rows = sheet.getLastRowNum() + 1;
		return rows;
	}

	public int getColumnCount(int sheetIndex) {
		XSSFSheet sheet = workbook.getSheetAt(sheetIndex);

		int cells = sheet.getRow(0).getLastCellNum();

		return cells;
	}

}
