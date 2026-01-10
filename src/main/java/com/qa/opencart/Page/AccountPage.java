package com.qa.opencart.Page;

import org.openqa.selenium.WebDriver;

public class AccountPage {
	WebDriver driver;


	public AccountPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public String doGetVerifyAccountTitle()
	{
		return driver.getTitle();
	}

}
