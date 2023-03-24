package com.TestLayer;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BaseLayer.BaseClass;
import com.PageLayer.ContactPage;
import com.UtilsLayer.ExcelReader;  

@Test(groups= {"contactpage"},dependsOnGroups= {"HomePage"})
public class ContactPageTest extends BaseClass {

	private static ContactPage contactpage;

	@Test(priority = 1)
	public void clickOnCreate() {
		contactpage = new ContactPage();
		contactpage.CreateEmp();
	}

	@Test(priority = 2, dataProvider="contactData")
	public void EnterContactData(String fname,String lname,String mname) {
//		contactpage.sendValue("abc", "pqr", "xyz");
//		homepage.checkContactLink();
		
//		contactpage = new ContactPage();
		contactpage.sendValue(fname, lname, mname);
	}
	
	@DataProvider(name="contactData")
	public Object [][] getData()
	{
		ExcelReader excelreader =new ExcelReader("C:\\Users\\Vishal\\Documents\\EmpDetails.xlsx");
		
		int rows = excelreader.getRowCount(0);
		int cells = excelreader.getColumnCount(0);
		
		Object [][] data =new Object[rows][cells];
		
		for(int i=0;i<rows;i++)
		{
			for (int j=0;j<cells;j++)
			{
				data[i][j]=excelreader.setData(0, i, j);
			}
		}
		return data;
	}

	@Test(priority = 3)
	public void savedata() {
		contactpage.validateEmailText("xyz@gamil.com");
	}

	@Test(priority = 4)
	public void savebutton() {
		contactpage.SaveButton();
	
	}
	
}
