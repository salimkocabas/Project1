package com.January07;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {
	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "/Users/macbook/Desktop/SeleniumJava/TestProjects/MyFirstLib/Drivers/chromedriver");
	WebDriver driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth");
	driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Hum@nhrm123");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	TakesScreenshot ts=(TakesScreenshot)driver;
	File  screen=ts.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(screen, new File("ScrShots/HRMS/Adminlogin.jpg"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
}
