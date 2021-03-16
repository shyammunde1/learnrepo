package com.samtech.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.samtech.qa.utility.UtilityTest;

public class TestBase {

	public static WebDriver driver;

	public static Properties prop;

	public TestBase() {

		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(
					"F:\\work space\\samtech\\src\\main\\java\\com\\samtech\\qa\\config\\config.properties");

			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public static void intialization() {

		String browsername = prop.getProperty("browser");

		if (browsername.equals("chrome")) {

//			DesiredCapabilities cap = new DesiredCapabilities();
//
//			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//			
//			
//			ChromeOptions option=new ChromeOptions();
//			
//			option.addArguments("headless");
//			option.merge(cap);
			System.setProperty("webdriver.chrome.driver", "F:\\work space\\samtechQA\\driver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browsername.equals("ff")) {

		} else {

			System.out.println("the browser  not found");

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(UtilityTest.Page_Load_TimeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilityTest.Implicit_Wait,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	}

}
