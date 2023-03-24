 package com.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseLayer.BaseClass;
import com.UtilsLayer.Utils;

public class HomePage extends BaseClass {
	@FindBy(xpath = "//div[@class=\"header item\"]")
	private WebElement logo;

	@FindBy(xpath = "//b[text()]")
	private WebElement Cname;

	@FindBy(xpath = "(//span[@class=\"item-text\"])[3]")
	private WebElement Contact;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public  boolean homePagefunction() {
		return logo.isDisplayed();
	}
	public String companyFunction() {
	return	Cname.getText();
	}
	
	public void contactFuntion() {
		Utils.click(Contact);
	}
	public String getTitle() {
	return	driver.getTitle();
	}
	
	public String getCurrentURL() {
	return	driver.getCurrentUrl();
	}
	
	
	
	
}
