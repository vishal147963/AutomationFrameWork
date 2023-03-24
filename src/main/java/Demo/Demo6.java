package Demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo6 {
	public static void main(String[] args) throws Exception {
		File f = new File("C:\\Users\\Vishal\\Documents\\EmpDetails.xlsx");

		FileInputStream fis = new FileInputStream(f);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheetAt(0);
//		String a = sheet.getRow(0).getCell(0).getStringCellValue();// username1
//	String b= sheet.getRow(1).getCell(0).getStringCellValue();//username2
//	String c= sheet.getRow(2).getCell(0).getStringCellValue();//username3
//	String d= sheet.getRow(3).getCell(0).getStringCellValue();//username4

		int rows = sheet.getLastRowNum();
System.out.println(" row value is "+rows);
		for (int i = 1; i <= rows; i++) {
			String a = sheet.getRow(i).getCell(0).getStringCellValue();
			String b = sheet.getRow(i).getCell(1).getStringCellValue();
			String c = sheet.getRow(i).getCell(2).getStringCellValue();
			String d = sheet.getRow(i).getCell(3).getStringCellValue();
//			String e = sheet.getRow(i).getCell(4).getStringCellValue();

			System.out.println(a + " " + b+" "+c+" "+d);
		}

	}
}
