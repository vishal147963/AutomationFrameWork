package com.TestLayer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseLayer.BaseClass;
import com.PageLayer.LoginPage;
@Test(groups = {"Retesting" })
public class LoginPageTest extends BaseClass{

	@BeforeClass
	public void setup() {
		LoginPage.initilization();
}
	@Test
	public void validateLoginFuntion() {
		LoginPage loginpage= new LoginPage();
		loginpage.loginFuntion("prafulp1010@gmail.com", "Pr@ful0812");
	}
	
	
	
	
}
