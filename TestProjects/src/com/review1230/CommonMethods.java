package com.review1230;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonMethods {
	public static WebDriver driver;
	public static void setup(String browser, String url) {
		
		
		
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/macbook/Desktop/SeleniumJava/TestProjects/MyFirstLib/Drivers/chromedriver");
			
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "/Users/macbook/Desktop/SeleniumJava/TestProjects/MyFirstLib/Drivers/geckodriver");
			driver = new FirefoxDriver();
			driver.get(url);
			driver.manage().window().maximize();
		}
	}
}

