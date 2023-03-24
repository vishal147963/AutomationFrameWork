package Tutorial11;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo22 {
	@Test (dataProvider="login")
public void contactInformation(String fname, String lname,String phno,String email) throws InterruptedException, IOException
{
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver= new FirefoxDriver();
	driver.get("https://demo.guru99.com/test/newtours/register.php");
	driver.findElement(By.name("firstName")).sendKeys(fname);
	driver.findElement(By.name("lastName")).sendKeys(lname);
	driver.findElement(By.name("phone")).sendKeys(phno);
	driver.findElement(By.name("userName")).sendKeys(email);
	File f=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
String date=new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
	FileUtils.copyFile(f, new File(System.getProperty("user.dir")+"//PassScreenshot//"+date+".png"));

Thread.sleep(3000);
driver.quit();



	}
@DataProvider(name= "login")
public Object[][] getData() {
	ExcelReader obj= new ExcelReader("C:\\Users\\Vishal\\Documents\\guru99.xlsx");
	int row = obj.getRowCount(0);
	int cell = obj.getColumnCount(0);
	
	Object[][] data = new Object[row][cell];
	for(int i=0;i<row;i++) {
		data[i][0]=obj.getdata(0, i, 0);
		data[i][1]=obj.getdata(0, i, 1);
		data[i][2]=obj.getdata(0, i, 2);
		data[i][3]=obj.getdata(0, i, 3);
		
	}
	
	return data;
	
}


}
