package com.January09;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import review_08January.CommonMethods;
import review_08January.Constants;

public class Action_Mouse_SendKey extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome",Constants.HRMS_URL);
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Hum@nhrm123");
	
		Actions act= new Actions(driver);
		WebElement clicking= driver.findElement(By.xpath("//input[@type='submit']"));
		act.moveToElement(clicking).contextClick().perform();
		Thread.sleep(1000);
	    act.moveToElement(clicking).click().perform();
		WebElement pimlink= driver.findElement(By.linkText("PIM"));
		act.moveToElement(pimlink).perform();
		Thread.sleep(1000);
		WebElement add= driver.findElement(By.linkText("Add Employee"));
		act.moveToElement(add).click().perform();
		
		WebElement name= driver.findElement(By.id("firstName"));
		WebElement lastname= driver.findElement(By.id("lastName"));
		
		act.moveToElement(name).click().keyDown(Keys.SHIFT).sendKeys("salimMM").keyUp(Keys.LEFT_SHIFT).perform();
		Thread.sleep(1000);
		act.moveToElement(lastname).sendKeys(lastname, "kocabas").perform();
		Thread.sleep(4000);

	}

}
