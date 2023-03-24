package com.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseLayer.BaseClass;
import com.UtilsLayer.Utils;

public class LoginPage extends BaseClass {
	@FindBy(name = "email")
	private WebElement uname;

	@FindBy(name = "password")
	private WebElement pass;
	
	@FindBy(xpath = "//div[text()='Login']")
	private WebElement login;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
//	public  void enterdata(String username, String Password) {
////		uname.sendKeys(username);
////		pass.sendKeys(Password);
//
//		uname.
//	}
	
	public void loginFuntion(String username, String Password)
	{
		Utils.sendKeys(uname, username);
		Utils.sendKeys(pass, Password);
		Utils.click(login);
		
	}
	
}
