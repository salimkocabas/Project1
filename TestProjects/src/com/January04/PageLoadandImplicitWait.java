package com.January04;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLoadandImplicitWait extends CommonMethods {

	public static void main(String[] args) {
		
    setup("chrome","http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
    driver.findElement(By.linkText("Others")).click();
    driver.findElement(By.linkText("Dynamic Data Loading")).click();
    driver.findElement(By.id("save")).click();
    
    WebDriverWait wait = new  WebDriverWait(driver,30);
    wait.until(ExpectedCondtions.visibleilityOfAllEelementslocatedBy(By.xpath("//p[starts-with)))")));
    		boolean  dipslayed=driver.findElement(By.xpath("//p[starts-with(text(), 'First Name')])"));
    				if (displayed){
    				System.out.println("Test Passed");}
    				else {
    					System.out.println("Test Failed");
    				}
    				Thread.sleep(3000);
    				driver.quit();
	}

}
