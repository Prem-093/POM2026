package com.qa.opencart.OptionManager;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;

public class OptionManager {
	
	private Properties prop;
	
	private ChromeOptions co;

	public OptionManager(Properties prop) {
		super();
		this.prop = prop;
	}
	
	public ChromeOptions  getChromeOptions()
	{
		co=new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless")))
		{
			co.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("inconginato")))
		{
			co.addArguments("--headless");
		}
		return co;
	}

	
	
	
}
