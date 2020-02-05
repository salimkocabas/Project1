package com.january11;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import review_08January.CommonMethods;
import review_08January.Constants;

public class Upload extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome","https://the-internet.herokuapp.com/upload");
		driver.findElement(By.id("file-upload")).sendKeys("/Users/macbook/Pictures/Tara.jpeg");
		Thread.sleep(2000);
		driver.findElement(By.id("file-submit")).click();
		WebElement upload=driver.findElement(By.xpath("//div[@id='uploaded-files']/preceding-sibling::h3"));
		if (upload.isDisplayed()) {
			String msg=upload.getText();
			System.out.println("File Uploaded : "+ msg);
		
		}
		else {
			System.out.println("not uploaded");
		}

		TakesScreenshot ts=(TakesScreenshot) driver;
		Thread.sleep(1000);
		File source = ts.getScreenshotAs(OutputType.FILE);
		Thread.sleep(4000);
		try {
			FileUtils.copyFile(source, new File("ScrShots/TASKS/file.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(4000);
		
	}
}
