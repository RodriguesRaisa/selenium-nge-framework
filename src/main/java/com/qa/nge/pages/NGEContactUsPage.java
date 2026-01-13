package com.qa.nge.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.nge.utils.StringUtils;

import static com.qa.nge.constants.AppConstants.*;

public class NGEContactUsPage {
	
	private WebDriver driver;
	private JavascriptExecutor js;
	
	//private By locators
	private final By firstNameEle = By.id("first_name"); 
	private final By lastNameEle = By.id("last_name");
	private final By emailEle = By.id("contact_email");
	private final By messageEle = By.id("message");
	private final By submitBtn = By.xpath("//button[@type='submit']");
	private final By sucessMesg = By.xpath("//div[@class='text-block-text']/p");
	private final By contactUsLink = By.linkText("Contact Us");
	private final By closeButton = By.xpath("//button[@data-testid='modal-close-button']");
	
	//public constructor
	public NGEContactUsPage(WebDriver driver)
	{
		this.driver = driver;	
		js = (JavascriptExecutor) this.driver;
	}
	
	//public actions/methods
	public boolean fillContactUsForm(String firstName,String lastName,String message)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameEle));
		js.executeScript("arguments[0].scrollIntoView(true);", firstNameField);
		driver.findElement(firstNameEle).clear();
		driver.findElement(firstNameEle).sendKeys(firstName);
		driver.findElement(lastNameEle).clear();
		driver.findElement(lastNameEle).sendKeys(lastName);
		driver.findElement(emailEle).clear();
		driver.findElement(emailEle).sendKeys(StringUtils.getRandomEmail());
		driver.findElement(messageEle).clear();
		driver.findElement(messageEle).sendKeys(message);
		driver.findElement(submitBtn).click();
		WebElement closeBtnIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton));
		closeBtnIcon.click();
		String successheaderText = driver.findElement(sucessMesg).getText();
		System.out.println(successheaderText);
		if(successheaderText.contains(CONTACT_SUCCESS_MSG))
		{
			driver.findElement(contactUsLink).click();
			driver.navigate().refresh();
			return true;
		}
		return false;
		
	}

}
