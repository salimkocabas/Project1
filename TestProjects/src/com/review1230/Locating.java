package com.review1230;

import org.openqa.selenium.By;

public class Locating extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
	setup("firefox",Constants.URL);
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//div[text()='Yardım']")).click();

	}

}
