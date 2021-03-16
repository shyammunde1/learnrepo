package com.samtech.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.samtech.qa.base.TestBase;

public class ContactPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: group automation')]")
	WebElement contactpageverifylablevar;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsvar;
	@FindBy(id = "first_name")
	WebElement firstnamevar;
	@FindBy(id = "middle_initial")
	WebElement middlenamevar;
	@FindBy(id = "surname")
	WebElement surnamevar;
	@FindBy(xpath = "//tbody/tr[8]/td[2]/input[3]")
	WebElement companyvar;
	@FindBy(xpath = "//input[@name='mobile']")
	WebElement mobilenumvar;

	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement savebutton;

	public ContactPage() {

		PageFactory.initElements(driver, this);

	}     

	public boolean contactpageverify() {

		return contactpageverifylablevar.isDisplayed();

	}
	
	
	

	public void creatnewcontact( String fsname, String midname, String lsname) {

//		Select select = new Select(driver.findElement(By.name("title")));
//
//		
//		select.selectByVisibleText(title);

		firstnamevar.sendKeys(fsname);
		middlenamevar.sendKeys(midname);
		surnamevar.sendKeys(lsname);
		savebutton.click();

	}

}
