package com.DropDownSelect;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectList {


	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.gecko.driver","/Users/macbook/Desktop/SeleniumJava/TestProjects/MyFirstLib/Drivers/geckodriver");
		WebDriver task= new FirefoxDriver();
		task.get("https://www.ebay.com");
		Thread.sleep(1000);
		WebElement selectlist= task.findElement(By.xpath("//select[@class='gh-sb ']"));
		Thread.sleep(1000);
		Select obj= new Select(selectlist);
		Thread.sleep(1000);
		List<WebElement> options=obj.getOptions();
		Thread.sleep(1000);
		for(WebElement opt:options){
			String text= opt.getText();
			// chose only music
			if (text.equals("Music")){
			obj.selectByVisibleText(text);
			break;
			}
			Thread.sleep(1000); 
		}
	
		Thread.sleep(1000); 
		task.quit(); 
	}

}