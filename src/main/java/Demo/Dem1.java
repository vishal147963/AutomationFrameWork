package Demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Dem1 {
public static void main(String[] args) throws IOException {
	File f =new File("C:\\Users\\Vishal\\Documents\\EmpDetails.xlsx");
	
	FileInputStream fis =new FileInputStream(f);
	
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	
	XSSFSheet sheet = workbook.getSheetAt(0);
	
//	String a= sheet.getRow(0).getCell(0).getStringCellValue();//username1
//	String b= sheet.getRow(1).getCell(0).getStringCellValue();//username2
//	String c= sheet.getRow(2).getCell(0).getStringCellValue();//username3
//	String d= sheet.getRow(3).getCell(0).getStringCellValue();//username4
	
	int rows = sheet.getLastRowNum();
	
	for(int i=1;i<=rows;i++)
	{
		String  p = sheet.getRow(i).getCell(0).getStringCellValue();
		System.out.println(p);
	}


}
}
