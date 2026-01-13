package com.qa.nge.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.qa.nge.constants.AppConstants.*;
import com.qa.nge.base.BaseTest;
import com.qa.nge.utils.ExcelUtil;

public class NGEContactUsPageTest extends BaseTest{
	
	@BeforeClass
	public void contactUsPageSetUp()
	{
		contactusPage = homePage.navigateToContactUsPage();
	}
	
	@DataProvider
	public Object[][] getContactData()
	{
		return new Object[][] {
				{"naveen","sharma","I have a question"}
		};
	}
	
	@DataProvider
	public Object[][] getUserContactData()
	{
		Object testContactData[][] = ExcelUtil.getUserData(CONTACT_DATA_SHEET_NAME);
		return testContactData;
	}
	
	@Test(dataProvider="getUserContactData")
	public void validateContactUsPage(String firstNameVal,String lastNameVal,String messageVal)
	{
		Assert.assertTrue(contactusPage.fillContactUsForm(firstNameVal, lastNameVal,messageVal));
		
	}

}
