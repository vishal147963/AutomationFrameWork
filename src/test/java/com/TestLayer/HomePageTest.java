package com.TestLayer;

import org.testng.annotations.Test;

import com.BaseLayer.BaseClass;
import com.PageLayer.HomePage;

import junit.framework.Assert;
@Test(groups = { "HomePage","Regression" }, dependsOnGroups = { "Retesting" })
public class HomePageTest extends BaseClass {
private HomePage homepage;
	@Test(priority=1)
	public void validateHomePageTitle() {
		homepage= new HomePage();
		Assert.assertEquals(homepage.getTitle(), "Cogmento CRM");
	} 
	@Test(priority=2)
	public void geturl() {
		homepage= new HomePage();
		Assert.assertEquals(homepage.getCurrentURL().contains("cogmento"), true);
	}
	@Test(priority=3)
	public void logo() {
		homepage= new HomePage();
		Assert.assertEquals(homepage.homePagefunction(), true);
	}
	@Test(priority=4)
	public void compname() {
		homepage= new HomePage();
		Assert.assertEquals(homepage.companyFunction().contains("Tech"), true);
	}
	@Test(priority=5)
	public void contactpage() {
		homepage= new HomePage();
		homepage.contactFuntion();
	}
	
}
