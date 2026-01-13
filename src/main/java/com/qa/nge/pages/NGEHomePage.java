package com.qa.nge.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NGEHomePage {
	
	private WebDriver driver;
	
	//1.private final By locators
	private final By heroImageHeading = By.xpath("//div[@class='heading']//strong");
	private final By contactUsLink = By.linkText("Contact Us");
	private final By menuLinks = By.xpath("//li[@data-testid='DropMenu']");
//	private final By heroImageCTALink = By.xpath(null);
//	private final By selectDestination = By.id(null);
//	private final By selectTripType = By.id(null);
//	private final By selectDepartureMonth = By.id(null);
//	private final By searchTripsBtn = By.id(null);
//	
	//2.public constructors
	public NGEHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3.public methods/actions
	
	public String getNGEUrl()
	{
		String currentUrl = driver.getCurrentUrl();
		System.out.println("The application URL is:"+currentUrl);
		return currentUrl;
	}
	
	public String getNGETitle()
	{
		String homepageTitle = driver.getTitle();
		System.out.println("The application title is:"+homepageTitle);
		return homepageTitle;
	}
	
	public NGEContactUsPage navigateToContactUsPage()
	{
		driver.findElement(contactUsLink).click();
		return new NGEContactUsPage(driver);
	}
	
	public List<String> getMenuLinks()
	{
		List<WebElement> menusList = driver.findElements(menuLinks);
		List<String> menuNamesList = new ArrayList<>();
		for(WebElement m : menusList)
		{
			String menuName = m.getText();
			System.out.println(menuName);
			menuNamesList.add(menuName);
		}
		return menuNamesList;
	}
	
	public String getHeroImageHeading()
	{
		String headingTitle = driver.findElement(heroImageHeading).getText();
		System.out.println("The hero image heading is:"+headingTitle);
		return headingTitle;
	}
	
	public void searchTrip()
	{
		
	}
	
	public void doPromoCardClick()
	{
		
	}
	
	public void tripCarouselExist()
	{
		
	}
	
	public void tripExpertsLinkExist()
	{
		
	}
	
	public void doNewsSignUp()
	{
		
	}
	
	public void getFooterLinks()
	{
		
	}
	
	public void getHeaderLinks()
	{
		
	}
	
	public void getDestinationSubMenuLinks()
	{
		
	}
	
	public void getTripTypeSubMenuLinks()
	{
		
	}

	public void getNatGeoDiffSubMenuLinks()
	{
		
	}
}
