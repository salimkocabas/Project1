package com.review1230;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetLinkList {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/Users/macbook/Desktop/SeleniumJava/TestProjects/MyFirstLib/Drivers/geckodriver");
		WebDriver task= new FirefoxDriver();
		task.get("https://the-internet.herokuapp.com/");
		Thread.sleep(2000);
		List<WebElement >links = task.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (WebElement link:links) {
			System.out.println(link.getCssValue("font-size"));
		}
		Thread.sleep(1000);
		
		task.quit();
	}

}
