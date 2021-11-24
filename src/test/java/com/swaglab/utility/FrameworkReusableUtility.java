package com.swaglab.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameworkReusableUtility {
	WebDriver driver = null;

	public String getProperty(String propertyName) throws IOException {
		String propertyValue = null;
		String filePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator
				+ "Config.properties";
		FileInputStream file = new FileInputStream(new File(filePath));
		Properties prop = new Properties();
		prop.load(file);
		propertyValue = prop.getProperty(propertyName);
		return propertyValue;
	}

	public WebElement getWebElement(String element) throws IOException {

		driver = FrameworkDriver.getWebDriver();
		return driver.findElement(By.xpath(element));
	}

	void scrollIntoDesiredElement(String strElement) throws IOException {
		driver = FrameworkDriver.getWebDriver();
		WebElement element = driver.findElement(By.xpath(strElement));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView();", element);
	}

}
