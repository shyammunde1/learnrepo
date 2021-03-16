package com.samtech.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.samtech.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: group automation')]")
	WebElement ValidateLink;

	@FindBy(xpath = "//a[@title='Calendar']")
	WebElement calendarvar;
	@FindBy(xpath = "//a[@title='Companies']")
	WebElement companiesvar;
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsvar;
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newcontactvar;

	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public boolean validateHomePageLogoTest() {

		return ValidateLink.isDisplayed();

	}

	public CalendarPage calenderLink() {

		calendarvar.click();
		return new CalendarPage();
	}

	public CompaniPage companipagelink() {

		companiesvar.click();
		return new CompaniPage();
	}

	public ContactPage contactpagelink() {

		contactsvar.click();

		return new ContactPage();

	}

	public ContactPage clicknewcontact() {
		
		Actions action=new Actions(driver);
		
		action.moveToElement(contactsvar).build().perform();
		newcontactvar.click();
		
		return new ContactPage();
		
	}

}
