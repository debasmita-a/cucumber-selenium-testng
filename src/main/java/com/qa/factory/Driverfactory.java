package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driverfactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	/**
	 * This method is used to initialize ThreadLocal WebDriver on basis of given browser
	 * @param browser
	 * @return
	 */
	public WebDriver init_driver(String browser) {
		System.out.println("Browser value is : "+ browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
			tlDriver.set(new ChromeDriver());
		}else if(browser.equalsIgnoreCase("firefox")) {
			tlDriver.set(new FirefoxDriver());
		}else {
			System.out.println("Please provide correct browser name..");
		}
		
		getDriver().get("");
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
