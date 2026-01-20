package com.qa.opencart.Factory;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.opencart.OptionManager.OptionManager;

public class DriverFactory {

	WebDriver driver;
	OptionManager option;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	boolean flag = false;

	public WebDriver launchBrowser(Properties prop)

	{

		String browsername = prop.getProperty("browser").trim();

		option = new OptionManager(prop);
		if (browsername.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver(option.getChromeOptions());
			tlDriver.set(new ChromeDriver(option.getChromeOptions()));

			flag = true;

		} else if (browsername.equalsIgnoreCase("edge")) {
			//driver = new EdgeDriver();
			tlDriver.set(new EdgeDriver());
			flag = true;
		} else if (browsername.equalsIgnoreCase("firefox")) {
			//driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
			flag = true;
		} else {
			System.out.println("Please check browser details :" + flag);
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}

	public synchronized static WebDriver getDriver() {
		return tlDriver.get();
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
	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);//imp
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}

}
