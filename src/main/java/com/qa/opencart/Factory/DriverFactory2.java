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

import com.qa.opencart.OptionManager.OptionManager;

public class DriverFactory2 {

	WebDriver driver;

	boolean flag = false;

	public WebDriver launchBrowser(Properties prop)

	{

		OptionManager option;
		String browsername = prop.getProperty("browser").trim();

		option = new OptionManager(prop);
		if (browsername.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver(option.getChromeOptions());

			flag = true;

		} else if (browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			flag = true;
		} else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			flag = true;
		} else {
			System.out.println("Please check browser details :" + flag);
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		return driver;
	}

	public Properties getProperty() {

		// mvn clean install -Denv="qa"

		FileInputStream ip = null;

		Properties prop = new Properties();

		String envName = System.getProperty("env");
		System.out.println("Running tc on env: " + envName);

		try {
			if (envName == null) {
				System.out.println("no env is given ....hence running it to QA env...");

				ip = new FileInputStream(
						"C:\\Users\\admin\\eclipse-workspace-Automation\\POM2026Testing\\src\\main\\resources\\config\\qa.config.properties");

			}

			else if (envName.equalsIgnoreCase("qa")) {
				ip = new FileInputStream(
						"C:\\Users\\admin\\eclipse-workspace-Automation\\POM2026Testing\\src\\main\\resources\\config\\qa.config.properties");
			} else if (envName.equalsIgnoreCase("stage")) {
				ip = new FileInputStream(
						"C:\\Users\\admin\\eclipse-workspace-Automation\\POM2026Testing\\src\\main\\resources\\config\\stage.config.properties");
			} else if (envName.equalsIgnoreCase("uat")) {
				ip = new FileInputStream(
						"C:\\Users\\admin\\eclipse-workspace-Automation\\POM2026Testing\\src\\main\\resources\\config\\uat.config.properties");
			} else {
				System.out.println("Please pass right env name...." + envName);
			}
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;

	}

}
