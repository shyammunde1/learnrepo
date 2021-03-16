package com.samtech.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.samtech.qa.base.TestBase;
import com.samtech.qa.pages.HomePage;
import com.samtech.qa.pages.LoginPage;

public class loginTestcase extends TestBase {

	public LoginPage loginpage;

	public HomePage homepage;

	public loginTestcase() {

		super();

	}

	@BeforeMethod

	public void setup() {

		intialization();
		loginpage = new LoginPage();

	}

	@Test(priority=1)
	public void validetTilte() {

		String title = loginpage.validateLoginPageTilte();

		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");

	}
	
	@Test(priority=2)
	
	public void validatetitlelogo() {
		
		boolean title=loginpage.validateLogoImage();
		
		Assert.assertTrue(title);
		
	}

	@Test(priority=3)
	public void loginTest() {

		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod

	public void teardown() {

		driver.quit();

	}

}
