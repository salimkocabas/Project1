package com.January09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import review_08January.CommonMethods;
import review_08January.Constants;

public class DragDrop extends CommonMethods{
public static void main(String[] args) throws InterruptedException {
	
	setUp("chrome", Constants.JQUERY);
	Thread.sleep(2000);
	driver.switchTo().frame(0);
	WebElement obj= driver.findElement(By.id("draggable"));
	//obj.click();
	//div[@id='droppable']"
	WebElement target= driver.findElement(By.id("droppable"));
	
	Actions act= new Actions(driver);
	//act.moveToElement(obj).click().perform();
	Thread.sleep(3000);
	act.dragAndDrop(obj, target).perform();
	Thread.sleep(3000);
	driver.quit();
}
}
