package com.FirstTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.org.apache.bcel.internal.generic.Select;
import s
public class LaunchChrome {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/Users/macbook/Desktop/SeleniumJava/TestProjects/MyFirstLib/Drivers/geckodriver");
		WebDriver task= new FirefoxDriver();
		task.get("http://166.62.36.207/syntaxpractice/index.html");
		Thread.sleep(2000);
		//task.findElement(By.linkText("REGISTER")).click();
	
		task.findElement(By.linkText("Input Forms")).click();
		Thread.sleep(1000);
		task.findElement(By.linkText("Checkbox Demo")).click();
		//Thread.sleep(1000);
		//task.findElement(By.xpath("input[@type='chekbox']")).click();

	}
	}

//<img src="/humanresources/symfony/web/webres_5acde3dbd3adc6.90334155/themes/default/images/syntax.png" alt="OrangeHRM" width="283" height="56">