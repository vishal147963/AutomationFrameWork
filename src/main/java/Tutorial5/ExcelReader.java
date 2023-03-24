package Tutorial5;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static XSSFWorkbook workbook;

	public ExcelReader(String path) throws Exception {
		File f = new File(path);
		boolean a = f.exists();
		System.out.println(a);
		FileInputStream fis = new FileInputStream(f);
		workbook = new XSSFWorkbook(fis);
	}

	public String getData(int sheetindex, int rows, int cells) {
		XSSFSheet sheet = workbook.getSheetAt(sheetindex);
		String data = sheet.getRow(rows).getCell(cells).getStringCellValue();
		return data;
	}

	public int getRowCount(int count) {
		XSSFSheet sheet = workbook.getSheetAt(count);
		int row = sheet.getLastRowNum() + 1;
		return row;
	}
	
	public int getRowCounts(int sheetindex) {

		XSSFSheet sheet = workbook.getSheetAt(sheetindex);

		int rows = sheet.getLastRowNum()+1;

		return rows;}

	public static void main(String[] args) throws Exception {

		ExcelReader obj = new ExcelReader("C:\\Users\\Vishal\\Documents\\EmpDetails.xlsx");
//int b=obj.getRowCounts(0);
//System.out.println(b);


		for(int i=0;i<=5;i++)
		{
			String p = obj.getData(0, i, 0);
			String data = obj.getData(0, i, 1);
			String data2 = obj.getData(0, i, 2);
				String data3 = obj.getData(0, i, 3);	
			System.out.println(p+"    "+data+"     "+data2+"    "+data3);
		}
		

	}

}
