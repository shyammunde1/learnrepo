package com.samtech.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.samtech.qa.base.TestBase;
import com.samtech.qa.pages.CalendarPage;
import com.samtech.qa.pages.HomePage;
import com.samtech.qa.pages.LoginPage;
import com.samtech.qa.utility.UtilityTest;

public class HomePageTest extends TestBase {

	public LoginPage loginpage;

	public HomePage homepage;
	public UtilityTest util;

	public HomePageTest() {

		super();
	}

	@BeforeMethod

	public void setup() {

		intialization();
		loginpage = new LoginPage();
		homepage = new HomePage();

		util=new UtilityTest();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod

	public void teardown() {

		driver.quit();

	}
	
	
	@Test
	
	public void homepagevalidateTest() {
		
		util.SwitchToFrame();
		homepage.validateHomePageLogoTest();
		
		Assert.assertTrue(homepage.validateHomePageLogoTest(),"the home page not validate");
		
		
	}
	
	@Test
	public void calenderPageTest() {
		util.SwitchToFrame();
		homepage.calenderLink();
		String title=driver.getTitle();
		System.out.println(title);
	}
	
	
	@Test
	
	public void companiepageTest() {
		
		util.SwitchToFrame();
		homepage.companipagelink();
		String title=driver.getTitle();
		System.out.println(title);
	}
@Test
	
	public void contactpagetest() {
		
		util.SwitchToFrame();
		homepage.contactpagelink();
		String title=driver.getTitle();
		System.out.println(title);
	}
	
	
	
	
	
	
	
	
	
}
