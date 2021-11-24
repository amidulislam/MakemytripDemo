package com.makemytrip.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.swaglab.utility.FrameworkDriver;
import com.swaglab.utility.FrameworkReusableUtility;

public class FlightSelection {
	String btnRoundTrip="//li[@data-cy='roundTrip']/span";
	String btnFromCity="//input[@id='fromCity']";
	String btnToCity="//input[@id='toCity']";
	String btnAdult="//li[@data-cy='adults-2']";
	String btnChildren="//li[@data-cy='children-1']";
	String btnApply="//button[text()='APPLY']";
	String btnSearch="//a[text()='Search']";
	String chknonStopFlight="(//span[text()='Non Stop'])[3]/../../../span[@class='customCheckbox']";

	String btnLowestPrice="(//span[text()='Price'])[1]/../..";

	String btnToFlight="((//div[@class='listingCardWrap'])[1]//div[@class='listingCard'])[1]//child::div[@class='makeFlex']/span";

	String btnFromFlight="((//div[@class='listingCardWrap'])[2]//div[@class='listingCard'])[1]//child::div[@class='makeFlex']/span";

	String btnBookNow="//button[text()='Book Now']";
	String btnContinue="//button[text()='Continue']";
	
	WebDriver driver=null;
	FrameworkReusableUtility utility=new FrameworkReusableUtility();
	
	public void bookTicketNow() throws IOException
	{
		
		driver=FrameworkDriver.getWebDriver();
		utility.getWebElement(btnRoundTrip).click();
		utility.getWebElement(btnFromCity).sendKeys("Bangalore");
		utility.getWebElement(btnToCity).sendKeys("Delhi");
		
		this.waitForbtnAdult(btnAdult,driver);
		
		utility.getWebElement(btnAdult).click();
		utility.getWebElement(btnChildren).click();
		utility.getWebElement(btnApply).click();
		utility.getWebElement(btnSearch).click();
		utility.getWebElement(chknonStopFlight).click();
		utility.getWebElement(btnLowestPrice).click();
		utility.getWebElement(btnToFlight).click();
		utility.getWebElement(btnFromFlight).click();
		utility.getWebElement(btnBookNow).click();
		utility.getWebElement(btnContinue).click();		
	}

	private void waitForbtnAdult(String btnAdult, WebDriver driver) throws IOException {
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(utility.getWebElement(btnAdult)));		
				
	}

}
