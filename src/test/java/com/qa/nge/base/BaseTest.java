package com.qa.nge.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.nge.factory.DriverFactory;
import com.qa.nge.pages.NGEContactUsPage;
import com.qa.nge.pages.NGEHomePage;

public class BaseTest {
	
	WebDriver driver;
	DriverFactory df;
	Properties prop;
	protected NGEHomePage homePage;
	protected NGEContactUsPage contactusPage;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browserName) {
		
		df = new DriverFactory();
		prop = df.initProp();
		if(browserName !=null)
		{
			prop.setProperty("browser", browserName);
		}
		driver = df.initDriver(prop);
		homePage = new NGEHomePage(driver);
		
	}
	
	@AfterTest
	public void tearDown()
	{
		//driver.quit();
	}

}
