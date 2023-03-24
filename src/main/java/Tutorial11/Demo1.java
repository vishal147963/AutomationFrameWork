package Tutorial11;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo1 {
	@Test(dataProvider = "loginData")
	public void validateLoginFunctionality(String password, String username) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://ui.cogmento.com/");
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[text()='Login']")).click();

		String a = driver.findElement(By.xpath("//span[@class='user-display']")).getText();
		System.out.println(a);
		Thread.sleep(7000);
		driver.quit();
	}
	
	@DataProvider(name = "loginData")
	public Object[][] testData() {

		Object[][] data = new Object[5][2];

		data[0][0] = "mahindrakarashwini14@gmail.com";
		data[0][1] = "Samarth#4";

		data[1][0] = "28atul28@gmail.com";
		data[1][1] = "Ganbawle@123";

		data[2][0] = "sonalibhosale2725@gmail.com";
		data[2][1] = "Scogmento@27";

		data[3][0] = "chandurkarpushpak03@gmail.com";
		data[3][1] = "Pcogmento";

		data[4][0] = "shashikantpanhalkar5@gmail.com";
		data[4][1] = "Shashikant55";

		return data;
	
	
	
	
	
	}	
}
