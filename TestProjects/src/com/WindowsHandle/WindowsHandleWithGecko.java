package com.WindowsHandle;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WindowsHandleWithGecko {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.gecko.driver","/Users/macbook/Desktop/SeleniumJava/TestProjects/MyFirstLib/Drivers/geckodriver");
		WebDriver task= new FirefoxDriver();
		task.get("http://jiravm.centralus.cloudapp.azure.com:8081/window-popup-modal-demo.html");
		task.manage().window().maximize();
		Thread.sleep(2000);
		String mainWindow= task.getWindowHandle();
		Thread.sleep(1000);
		System.out.println("***** PARENT INFO WITH getHandle METHOD *****");
		System.out.println(mainWindow);
		System.out.println(task.getTitle());
		//After opening new page
		task.findElement(By.xpath("//a[@title='Follow @syntaxtech on Instagram']")).click();
		Set<String> allwindows=task.getWindowHandles();
		Iterator<String> it=allwindows.iterator();
		String parent=it.next();
		String child =it.next();
		task.switchTo().window(child);
		Thread.sleep(2000);
		System.out.println("**** PARENT AND CHILD INFOR WITH getHandles METHOD ****");
		System.out.println(child);
		System.out.println(task.getTitle());
		Thread.sleep(2000);
		task.switchTo().window(parent);
		Thread.sleep(2000);
		//parent info again
		System.out.println("**** PARENT INFO AFTER SWITCHING BACK TO PARENT *****");
		System.out.println(parent);
		System.out.println(task.getTitle());
		System.out.println(mainWindow);
		
		
		Thread.sleep(2000);
		//task.findElement(By.xpath("//a[@title='Follow @syntaxtech']")).click();
		//Thread.sleep(2000);
		task.quit();
		
	}

}
