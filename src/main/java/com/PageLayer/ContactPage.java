package com.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseLayer.BaseClass;
import com.UtilsLayer.Utils;

public class ContactPage extends BaseClass {
//or
	@FindBy(xpath = "//a[@href=\"/contacts/new\"]")
	private WebElement Create;

	@FindBy(name = "first_name")
	private WebElement fname;

	@FindBy(name = "middle_name")
	private WebElement mname;

	@FindBy(name = "last_name")
	private WebElement lname;

	@FindBy(xpath = "//input[@placeholder=\"Email address\"]")
	private WebElement mailid;
	
	@FindBy(xpath = "//i[@class=\"save icon\"]")
	private WebElement button;
	

//	contructor
	public ContactPage() {
		PageFactory.initElements(driver, this);

	}

//Actions
	public void CreateEmp() {
		Utils.click(Create);
	}

	public void sendValue(String firstname,String lastname,String middlename) {
		Utils.sendKeys(fname, firstname);
		Utils.sendKeys(lname, lastname);
		Utils.sendKeys(mname, middlename);
	}
	
	public void validateEmailText(String email) {
		Utils.sendKeys(mailid, email);
		
	}
	public void SaveButton() {
		Utils.click(button);
	}
	
}
