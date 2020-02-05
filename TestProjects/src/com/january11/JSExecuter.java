package com.january11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import review_08January.CommonMethods;
import review_08January.Constants;

public class JSExecuter extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", Constants.HRMS_URL);
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Hum@nhrm123");
		JavascriptExecutor js= (JavascriptExecutor)driver;
		WebElement loginbtn= driver.findElement(By.id("btnLogin"));
		js.executeScript("arguments[0].style.backgroundColor='Green'",loginbtn);
		js.executeScript("arguments[0].click();", loginbtn);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(4000);
		driver.quit();
		
	}

}
