package com.January04;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Recap_Alert {
	
	public static void setUp(String browser, String URL) {
		if (String )
		System.setProperty("webdriver.chrome.driver","/Users/macbook/Desktop/SeleniumJava/TestProjects/MyFirstLib/Drivers/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get("http://jiravm.centralus.cloudapp.azure.com:8081/window-popup-modal-demo.html");
		Thread.sleep(2000);
	}
	/**
	 * This method will dismiss the alert if there is
	 */
public static void dismissAlert() {
	try {
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	catch{(NoAlertPresentException e){
		System.out.println("No such an alert...");
	}
	
	public static String getAlertText() {
		try{
			Alert alert=driver.switchTo().alert();
			
		}
	}
	}
}
}

