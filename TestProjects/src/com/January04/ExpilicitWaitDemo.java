package com.January04;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExpilicitWaitDemo extends CommonMethods{
	
	public static void main(String[] args) throws InterruptedException {
		
		setup("chrome", "https://the-internet.herokuapp.com/");
		WebDriverWait wait=new WebDriverWait(driver, 30);
		driver.findElement(By.linkText("Dynamic Controls")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
		driver.findElement(By.xpath("//button[text()='Remove']")).click();
		driver.findElement(By.xpath("//button[text()='Add'] ")).click();
		String text=driver.findElement(By.id("message")).getText();
		
	
		if(text.equals(text)) {
			System.out.println("Test Passed. Taken Message is ---->"+ text);
		}
		
		else {
			System.out.println("Test Not Passed");
		}

		driver.quit();
		
		
	}

}
