package com.makemytrip.test;

import java.io.IOException;
import java.util.List;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.makemytrip.pages.FlightSelection;
import com.makemytrip.pages.Login;
import com.swaglab.utility.FrameworkDriver;
import com.swaglab.utility.FrameworkReusableUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RountTripBookingTest {
	static WebDriver driver=null;
	FrameworkReusableUtility utility=new FrameworkReusableUtility();
	@BeforeClass
	void initDriver() throws IOException
	{
		WebDriverManager.chromedriver().setup();		
		//driver=FrameworkDriver.getWebDriver();
		driver=new ChromeDriver();
		
		String url=utility.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
	}
	@Test(priority = 1)
	void login() throws IOException
	{
		
		String uname=utility.getProperty("uname");
		String pass=utility.getProperty("pwd");
		Login objLogin=new Login();		
		objLogin.setUname(uname);
		objLogin.setPwd(pass);		
		objLogin.loginToApplication();
		String pageTitle=driver.getTitle();
		boolean boolLoginStatus=utility.getWebElement("//span[contains(text(),'Hey')]").isDisplayed();
		//if(!boolLoginStatus)			
		    Assert.assertEquals("Expected Successful Login", true, boolLoginStatus);		    
		
	}
	@Test(priority = 2)
	void bookFlighTicket() throws IOException
	{
	FlightSelection flight=new FlightSelection();
	flight.bookTicketNow();	
	}
	
	@AfterClass
	void tearDown() throws InterruptedException
	{		
		Thread.sleep(5000);		
		driver.quit();
	}

}
