package Tutorial11;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
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

public class Demo2 {
	@Test(dataProvider = "contactInfo")
	public void ContactInformation(String fname, String lname, String phone, String email)
			throws InterruptedException, IOException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		driver.findElement(By.name("firstName")).sendKeys(fname);
		driver.findElement(By.name("lastName")).sendKeys(lname);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.name("userName")).sendKeys(email);
		Thread.sleep(5000);

//		TakesScreenshot ts= (TakesScreenshot)driver;
//		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String date = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

//		String date = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
		
		
		FileUtils.copyFile(f, new File(System.getProperty("user.dir") + "//PassScreenshot//" + date + ".png"));

		Thread.sleep(1000);
		driver.quit();
	}
	
	@DataProvider(name = "contactInfo")
	public Object[][] getData() {
		
		Object[][] data = new Object[5][4];
		data[0][0] = "abc1";
		data[0][1] = "xyz1";
		data[0][2] = "11111";
		data[0][3] = "abc1@gmail.com";

		data[1][0] = "abc2";
		data[1][1] = "xyz2";
		data[1][2] = "2222";
		data[1][3] = "abc2@gmail.com";

		data[2][0] = "abc3";
		data[2][1] = "xyz3";
		data[2][2] = "3333";
		data[2][3] = "abc3@gmail.com";

		data[3][0] = "abc4";
		data[3][1] = "xyz4";
		data[3][2] = "44444";
		data[3][3] = "abc4@gmail.com";

		data[4][0] = "abc5";
		data[4][1] = "xyz5";
		data[4][2] = "55555";
		data[4][3] = "abc5@gmail.com";

		return data;
	
	
	
	
}}
