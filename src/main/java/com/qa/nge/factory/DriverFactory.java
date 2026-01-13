package com.qa.nge.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.nge.exceptions.BrowserException;

public class DriverFactory {

	WebDriver driver;
	Properties prop;
	
	public WebDriver initDriver(Properties prop) {
		
		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("appUrl");
		System.out.println("Browser name is : "+browserName);
		OptionsManager opMgr = new OptionsManager(prop);
		
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver(opMgr.getChromeOptions());
			break;
		case "firefox":
			driver = new FirefoxDriver(opMgr.getFirefoxOptions());
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("Please pass the right browser: "+browserName);
			throw new BrowserException("==INVALID BROWSER==");
			
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
		
	}
	
	//mvn clean install -Denv="qa"
	public Properties initProp()
	{
		prop = new Properties();
		FileInputStream ip = null;
		String envName = System.getProperty("env");
		System.out.println("Running the tests on the env:"+envName);
		try {
		if(envName == null)
		{
			System.out.println("env is null hence running on default env qa");
			ip = new FileInputStream("./src/test/resources/config/config.properties");		
		}
		else {
			switch (envName.toLowerCase().trim()) {
			case "stage":
				System.out.println("Running tests on env"+envName);
				ip = new FileInputStream("./src/test/resources/config/stage.config.properties");		
				break;
			case "latest":
				System.out.println("Running tests on env"+envName);
				ip = new FileInputStream("./src/test/resources/config/latest.config.properties");
				break;
			case "prod":
				System.out.println("Running tests on env"+envName);
				ip = new FileInputStream("./src/test/resources/config/prod.config.properties");
				break;
			default:
				throw new BrowserException("===INVALID ENV NAME==="+envName);			
			}
		}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			}

			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
	
		return prop;
		
	}
	
	
}
