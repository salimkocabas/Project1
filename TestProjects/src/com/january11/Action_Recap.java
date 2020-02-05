package com.january11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import review_08January.CommonMethods;

public class Action_Recap extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
setUp("firefox", "https://google.com");

driver.findElement(By.name("q")).sendKeys("iphone11",Keys.ENTER);
Thread.sleep(2000);


Actions act=new Actions(driver);
WebElement btn= driver.findElement(By.name("btnK"));
act.click(btn).perform();


Thread.sleep(2000);
driver.quit();
	}

}
