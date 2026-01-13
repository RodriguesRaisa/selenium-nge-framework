package com.qa.nge.newtests;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumChallenge1 {

	WebDriver driver;
	JavascriptExecutor js;
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
        
	}
	
	@Test(priority=1)
	public void extractContent() throws InterruptedException{
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        driver.get("https://mockexam1cpsat.agiletestingalliance.org/");
	        
	        // Close initial popup
	        wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//i[@class='eicon-close']"))).click();

	        // Click menu
	        driver.findElement(By.xpath("//li[contains(@class,'menu-item-align-right')]/a")).click();

	        // Click Challenge 1
	        driver.findElement(By.linkText("Challenge 1")).click();

	        // Close popup again
	        wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//i[@class='eicon-close']"))).click();
	        
	        WebElement paraBoxEle = driver.findElement(By.xpath("//div[contains(@class,'elementor-widget-wrap')]"));
	        By paragraphText = By.xpath("//div[contains(@id,'elementor-tab-content') and @style='display: block;']//p");
	        
	        
	        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'elementor-widget-wrap')]")));
	        
	        js.executeScript("arguments[0].scrollIntoView(true);",paraBoxEle);
	                       
	       Thread.sleep(1000);
	               
	        List<WebElement> paraElements = driver.findElements(By.xpath("//div[starts-with(@id,'para')]"));
	        
	        List<String> langTextList = new ArrayList<>();
	        for (WebElement p : paraElements) {
	           
	        	String backcroundColorBeforeClick = p.getCssValue("background-image");
	 	        System.out.println("Background color for paraElement before click:"+backcroundColorBeforeClick);
	        	
	 	        wait.until(ExpectedConditions.elementToBeClickable(p));
	        	p.click();
	        	
	        	String backcroundColorAfterClick = p.getCssValue("background-image");
	 	        System.out.println("Background color for paraElement before click:"+backcroundColorAfterClick);
	 	        
	 	        //Verify that two colors are different
		        Assert.assertNotEquals(backcroundColorBeforeClick, backcroundColorAfterClick);
	 	        
	        	WebElement paraText = wait.until(ExpectedConditions.visibilityOfElementLocated(paragraphText));
	            String text = paraText.getText();
	            
	            System.out.println(text);
	            langTextList.add(text);
	                                
	        }
	        
	        System.out.println(langTextList);	
	        
	        //Take Screenshot
//	        TakesScreenshot ts = (TakesScreenshot) driver;
//	        File srcFile= ts.getScreenshotAs(OutputType.FILE);
//	        File destFile = new File("C:\\Users\\RaisaRodrigues\\Desktop\\accordion_screenshot.png");
//	        FileUtils.copyFile(srcFile,destFile);
	}
	
	
	@Test(priority=2)
	public void displaySpeakers() {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        driver.get("https://mockexam1cpsat.agiletestingalliance.org/index.php/challenge-2/");	        
	        
	        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'"));
	        
	        List<WebElement> speakersList = driver.findElements(By.xpath("//div/h6"));
	        
	        for(WebElement s : speakersList)
	        {
	        	 System.out.println(s.getText());
	        }
	}
	     
	
	@Test(priority=3)
	public void displayTweets() {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        driver.get("https://mockexam1cpsat.agiletestingalliance.org/index.php/challenge-4/");	        
	        
	        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'"));
	        
	        WebElement sectionTitle = driver.findElement(By.xpath("//h2[contains(@class,'elementor-heading-title')]"));
	        System.out.println(sectionTitle.getText());
	        
	        // Assuming carousel tweets rotate — read all carousel text
	        List<WebElement> tweetsList = driver.findElements(By.xpath(""));
	        
	        for(WebElement tweet : tweetsList)
	        {
	        	System.out.println(tweet.getText());
	        	System.out.println("-----------------------------");
	        }
	        

	}


	        @AfterTest
	        public void tearDown() 
	        {	                
	        driver.quit();
	        }

}
