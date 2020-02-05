package com.Buttons;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Buttons {
public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.gecko.driver", "/Users/macbook/Desktop/SeleniumJava/TestProjects/MyFirstLib/Drivers/geckodriver");
			WebDriver task= new FirefoxDriver();
			task.get("http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
			Thread.sleep(2000);
	
		
			task.findElement(By.linkText("Input Forms")).click();
			Thread.sleep(1000);
			task.findElement(By.linkText("Select Dropdown List")).click();
			task.findElement(By.id("isAgeSelected")).click();
			List<WebElement> list=task.findElements(By.xpath("//h1[text()='Enrollment for SDET Automation has officially Opened. Sign Up Today Accepting Applicants Limited Seats.']"));
			list.get(1).click();
			Thread.sleep(1000);
			  kk 

		}
		}

