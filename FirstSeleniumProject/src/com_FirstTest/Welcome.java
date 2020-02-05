package com_FirstTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Welcome {

	public static void main(String[] args) {
	System.setProperty("webdriver.gecko.driver", "/Users/macbook/Desktop/SeleniumJava/FirstSeleniumProject/Lib_Selenium/Gecko/geckodriver");
	WebDriver firefox=new FirefoxDriver();
	
	firefox.get("https://www.facebook.com/");
	firefox.quit();
	}
}
	


