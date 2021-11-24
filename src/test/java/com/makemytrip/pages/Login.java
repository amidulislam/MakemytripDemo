package com.makemytrip.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.swaglab.utility.FrameworkDriver;
import com.swaglab.utility.FrameworkReusableUtility;

public class Login {
	String uname;
	String pwd;
	String btnLoginOrCreate = "//p[text()='Login or Create Account']";
	String strUname = "//input[@id='username']";
	String btnContinue = "//span[text()='Continue']/..";
	String strPwd = "//input[@id='password']";
	String btnLogin = "//span[text()='Login']/..";
	WebDriver driver = null;
	FrameworkReusableUtility utility = new FrameworkReusableUtility();

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void loginToApplication() throws IOException {

		driver = FrameworkDriver.getWebDriver();
		utility.getWebElement(btnLoginOrCreate).click();
		utility.getWebElement(strUname).sendKeys(uname);
		utility.getWebElement(btnContinue).click();
		utility.getWebElement(strPwd).sendKeys(pwd);
		utility.getWebElement(btnLogin).click();

	}

}
