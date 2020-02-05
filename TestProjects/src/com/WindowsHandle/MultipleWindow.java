package com.WindowsHandle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindow {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","/Users/macbook/Desktop/SeleniumJava/TestProjects/MyFirstLib/Drivers/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get("http://jiravm.centralus.cloudapp.azure.com:8081/window-popup-modal-demo.html");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		String mainWindow= driver.getWindowHandle();
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Follow On Instagram")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Like us On Facebook")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Follow Instagram & Facebook")).click();
		Thread.sleep(1000);
		Set<String> allWindows=driver.getWindowHandles();
		Iterator<String> it=allWindows.iterator();
		//getting Titles of all windows
		while(it.hasNext()) {
			String child1 =it.next();// now child1 is parent
			String child2 =it.next();
			String child3 =it.next();
			String child4 =it.next();
			driver.switchTo().window(child1);
			System.out.println(driver.getTitle());
			Thread.sleep(1000);
			driver.close();
			driver.switchTo().window(child2);
			System.out.println(driver.getTitle());
			Thread.sleep(1000);
			driver.close();
			driver.switchTo().window(child3);
			System.out.println(driver.getTitle());
			Thread.sleep(1000);
			driver.close();
			driver.switchTo().window(child4);
			System.out.println(driver.getTitle());
			driver.close();
			//Getting Titles with if conditions
			/*
			 if(!child.equals(mainWindow)) {
				driver.switchTo().window(child);
				Thread.sleep(1000);
				System.out.println("Now browser in on child :"+driver.getTitle());
				driver.close();
				driver.switchTo().window(mainWindow);
				Thread.sleep(1000);
			}
		}
		*/
		}
		Thread.sleep(3000);
		driver.quit();
}
}
