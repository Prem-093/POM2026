package com.qa.opencart.Factory;

import java.io.FileInputStream;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory123456543 {
   
	
	 WebDriver driver;
	
	 boolean flag=false;
	public  WebDriver launchBrowser(Properties prop)
	
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();	
			
	
			flag=true;
			
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			flag=true;
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			flag=true;
		}
		else
		{
			System.out.println("Please check browser details :"+flag);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	public Properties getProperty()
	{
		Properties prop=new Properties();
		
		try {
			FileInputStream ip=new FileInputStream("C:\\Users\\admin\\eclipse-workspace-Automation\\POM2026Testing\\src\\main\\resources\\config\\config.properties");
				prop.load(ip);
		}
				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return prop;
			
		} 
	
		
	}


