package com.samtech.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.samtech.qa.base.TestBase;

public class LoginPage extends TestBase {

	// page factory

	@FindBy(xpath ="//input[@type='text']")
	WebElement username;
	@FindBy(xpath ="//input[@type='password']")
	WebElement password;
	@FindBy(xpath ="//input[@type='submit']")
	WebElement button;

	@FindBy(xpath="//a[@class='navbar-brand']")
	WebElement ImgLogo;
	// Initializing the page object

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTilte() {

		return driver.getTitle();

	}

	public boolean validateLogoImage() {

		return ImgLogo.isDisplayed();

	}

	public HomePage login(String Uname, String pwd) {

		username.sendKeys(Uname);
		password.sendKeys(pwd);
		button.click();

		return new HomePage();
	}

}
