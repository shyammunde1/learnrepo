package com.samtech.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.samtech.qa.base.TestBase;
import com.samtech.qa.pages.ContactPage;
import com.samtech.qa.pages.HomePage;
import com.samtech.qa.pages.LoginPage;
import com.samtech.qa.utility.UtilityTest;

public class contactpagetest extends TestBase {
	public LoginPage loginpage;

	public HomePage homepage;
	public UtilityTest util;
	public ContactPage contactp;

	public contactpagetest() {

		super();
	}

	@BeforeMethod
	public void setup() {

		intialization();
		loginpage = new LoginPage();
		homepage = new HomePage();

		contactp = new ContactPage();
		util = new UtilityTest();
		
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
		
		
		

	}

//	@Test(priority=1)
//
//	public void verifycontactpage() {
//
//		util.SwitchToFrame();
//		boolean pagecontact = contactp.contactpageverify();
//
//		Assert.assertTrue(pagecontact);
//	}
//	
	
	@DataProvider

	public Object[][] getsamtechData() {
		
		Object data[][]=UtilityTest.getTestData("contactdata");
		
		return data;
		
	}
	@Test(priority=2,dataProvider="getsamtechData")

	public void validatenewcontact(String firstname,String lastname,String midelname) throws Exception {
		
		util.switchToFrame();
		homepage.clicknewcontact();
		

		contactp.creatnewcontact(firstname,lastname,midelname);

	}

	@AfterMethod

	public void teardown() {

		driver.quit();

	}

}
