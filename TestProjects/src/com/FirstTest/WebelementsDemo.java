package com.FirstTest;

import org.openqa.selenium.firefox.FirefoxDriver;

public class WebelementsDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/macbook/Desktop/SeleniumJava/TestProjects/MyFirstLib/Drivers/geckodriver" );
		FirefoxDriver driver=new FirefoxDriver();
		driver.get(URL);

	}

}
