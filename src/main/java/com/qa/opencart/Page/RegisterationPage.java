package com.qa.opencart.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterationPage {

	WebDriver driver;
	
	RegisterationPage register;

	public RegisterationPage(WebDriver driver) {
	
		this.driver = driver;
	}
	
	private By firstName=By.xpath("//input[@name='firstname']");
	//input[@name='lastname']
	private By email=By.xpath("//input[@name='email']");
	private By lastname=By.xpath("//input[@name='lastname']");
	private By telephone=By.xpath("//input[@name='telephone']");
	private By password=By.xpath("//input[@name='password']");
	private By confirm=By.xpath("//input[@name='confirm']");
	//input[@type='checkbox']
	private By checkbox=By.xpath("//input[@type='checkbox']");
	private By button=By.xpath("//input[@value='Continue']");
	
	By sussceesmess=By.xpath("//div[@id='content']/h1");
	//  (//a[text()='Logout'])[2]
	
	By logout=By.xpath("(//a[text()='Logout'])[2]");
	
	//a[text()='Continue']
	
	By logout_Register=By.xpath("(//a[text()='Register'])[2]");
	
	
	
	public String testRegistrationTitle()
	{
		String text=driver.getTitle();
		return text;
	}
	
	public String doRegistration(String firstName1,String lastName,String gmail,String Phonenumber,String Password,String ConfirmPass) 
	{
		driver.findElement(firstName).sendKeys(firstName1);
		driver.findElement(lastname).sendKeys(lastName);
		driver.findElement(email).sendKeys(gmail);
		driver.findElement(telephone).sendKeys(Phonenumber);
		driver.findElement(password).sendKeys(Password);
		driver.findElement(confirm).sendKeys(ConfirmPass);
		driver.findElement(checkbox).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(button).click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	String successMessage=	driver.findElement(sussceesmess).getText();
	
	driver.findElement(logout).click();
	
	//a[text()='Register'])[2]
	driver.findElement(logout_Register).click();
	
	return successMessage;
		
		
	}
	
}
