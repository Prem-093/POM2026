package com.qa.opencart.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	AccountPage account;
	RegisterationPage registration;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}


	private By email=By.xpath("//input[@name='email']");
	private By pass=By.xpath("//input[@name='password']");
	private By registationLink=By.xpath("(//a[text()='Register'])[2]");
	
	public String doGetTitleofSignupPage()
	{
		 return driver.getTitle();
		 
	}
	
	public AccountPage doLogin(String emailname,String Password)
	{
		driver.findElement(email).sendKeys(emailname);
		driver.findElement(pass).sendKeys(Password);
		account= new AccountPage(driver);
		return account;
	}
	
	public boolean isRegistrationLinkEnable()
	{
		return driver.findElement(registationLink).isEnabled();
	}
	
	public RegisterationPage navigateRegisterPage()
	{
		 driver.findElement(registationLink).click();
		
		 return new RegisterationPage(driver);
		
	}

}
