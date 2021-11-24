package com.swaglab.utility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameworkDriver {
	static WebDriver driver=null;
	static FrameworkReusableUtility utility=new FrameworkReusableUtility();
	private FrameworkDriver(String driverType)
	{
	   
	   if(driver==null)
	   {
		   if(driverType.equalsIgnoreCase("chrome"))
		   {
			   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"Ext"+File.separator+"chromedriver.exe");
			   driver=new ChromeDriver();			   
		   }
		   else if(driverType.equalsIgnoreCase("firefox"))
		   {
			   System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+File.separator+"Ext"+File.separator+"chromedriver.exe");
			   driver=new FirefoxDriver();
			      
		   }
		   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	   }
		   
	}
	public static WebDriver getWebDriver() throws IOException
	{
		String browserType=utility.getProperty("driverType");
		new FrameworkDriver(browserType);
		return driver;
	}
	
	

}
