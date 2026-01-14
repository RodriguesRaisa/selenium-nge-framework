package com.qa.nge.pages;

import org.openqa.selenium.By;

public class cartpage {
	
	private By cartLocator = By.id("cart");
	public void cart()
	{
		System.out.println("cart method"+cartLocator);
	}

}
