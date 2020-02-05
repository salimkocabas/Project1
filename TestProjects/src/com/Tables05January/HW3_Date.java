package com.Tables05January;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW3_Date {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/macbook/Desktop/SeleniumJava/TestProjects/MyFirstLib/Drivers/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//***LOGIN***
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth");
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//***GOTO LEAVE PAGE***
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("PIM")));
		driver.findElement(By.linkText("Leave")).click();
		driver.findElement(By.linkText("Leave List")).click();
		//***CHOOSE DATES***
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
		driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).click();
//***Selecting Date From***
		
		driver.findElement(By.id("calFromDate")).click();
		WebElement monthfrom= driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select monthlist= new Select(monthfrom);
		monthlist.selectByVisibleText("Dec");
	    Thread.sleep(1000);
	    
		driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")).click();
		WebElement yearfrom= driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select yearlist= new Select(yearfrom);
		yearlist.selectByVisibleText("2019");
		Thread.sleep(1000);	

		List<WebElement> days=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td"));
			for(WebElement day:days) {
				if(day.getText().equals("1")) {
					day.click();
				}
			}
			
		//***Selecting Date Till***
			driver.findElement(By.id("calToDate")).click();
		    driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
			WebElement monthtill= driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
			Select month= new Select(monthtill);
			month.selectByVisibleText("Jan");
		    Thread.sleep(1000);
		    
			driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")).click();
			WebElement yeartill= driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
			Select year= new Select(yeartill);
			year.selectByVisibleText("2020");
			Thread.sleep(1000);	

			List<WebElement> daytill=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td"));
				for(WebElement day:daytill) {
					if(day.getText().equals("31")) {
						day.click();
					}
				}	
		
		Thread.sleep(2000);
		driver.quit();
	}
}
