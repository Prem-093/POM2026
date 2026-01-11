package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.qa.opencart.Factory.DriverFactory;
import com.qa.opencart.Page.AccountPage;
import com.qa.opencart.Page.LoginPage;
import com.qa.opencart.Page.RegisterationPage;

public class BaseTest {
	
	WebDriver driver;
	
	protected DriverFactory df;
	protected Properties prop;
	protected AccountPage account;
	protected LoginPage login;
	protected RegisterationPage registration;
	
	
	@Parameters({"browser"})
	@BeforeTest
	public void doSetUp(String browserName)
	{
		df=new DriverFactory();
		prop=df.getProperty();
		
		if(browserName!=null)
		{
			prop.setProperty("browser", browserName);
		}
		
		driver=df.launchBrowser(prop);
		
		login=new LoginPage(driver);
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
