package com.qa.nge.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.nge.base.BaseTest;
import static com.qa.nge.constants.AppConstants.*;

import java.util.Arrays;
import java.util.List;
public class NGEHomePageTest extends BaseTest{
	
	@Test
	public void validateNGEHeroImageHeading()
	{
		String actualHeroImageHeading = homePage.getHeroImageHeading();
		Assert.assertEquals(actualHeroImageHeading,HEROIMAGE_HEADING);
	}
	
	@Test
	public void validateNGEURL()
	{
		String actualUrl = homePage.getNGEUrl();
		Assert.assertTrue(actualUrl.contains(HOME_PAGE_URL));
	}
	
	@Test
	public void validateNGEHomePageTitle()
	{
		String actualTitle = homePage.getNGETitle();
		Assert.assertTrue(actualTitle.contains(HOMEPAGE_TITLE));
	}

	
	@Test
	public void validateNavigationMenuLinks()
	{
		List<String> actualMenuNames = homePage.getMenuLinks();
		List<String> expectedMenuNames = Arrays.asList("DESTINATIONS","TRIP TYPES","NAT GEO DIFFERENCE","GET INSPIRED","SPECIAL OFFERS");
		
		Assert.assertEquals(actualMenuNames, expectedMenuNames);
		
	}
	
	@Test
	public void validateSignUpSuccess()
	{
		
	}

}
