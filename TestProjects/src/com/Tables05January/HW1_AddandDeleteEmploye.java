package com.Tables05January;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW1_AddandDeleteEmploye {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/macbook/Desktop/SeleniumJava/TestProjects/MyFirstLib/Drivers/chromedriver");
		WebDriver driver= new ChromeDriver();
		//***LOGIN***
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth");
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//***GOTO ADD PAGE***
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("PIM")));
		driver.findElement(By.linkText("PIM")).click();
		
		WebDriverWait wait1=new WebDriverWait(driver,10);
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Add Employee")));
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		
		//***ADD EMPLOYEE***
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Girdim");
		driver.findElement(By.name("lastName")).sendKeys("Çıkamıyorum");
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		
		//***REFRESH EMPLOYEE LIST***
		WebDriverWait wait2=new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Employee List")));
		driver.findElement(By.linkText("Employee List")).click();
		driver.manage().window().fullscreen();
		//***FIND and DELETE ADDED EMPLOYEE***
		String targettext="Test Tester";
		WebDriverWait wait5=new WebDriverWait(driver, 10);
		wait5.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='resultTable']/tbody/tr")));
		List<WebElement> rows= driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		boolean found=false;
		while(!found) {
			for (int i=1; i<=rows.size(); i++) {
				String target=rows.get(i-1).getText();
				if(target.contains(targettext)) {
					found=true;
					driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[1]")).click();
					Thread.sleep(100);
					break;
				}
	
			}
			driver.findElement(By.xpath("//a[text()='Next']")).click();
			
		}
	
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='delete']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
		Thread.sleep(1000);
		
		//***VERIFY IF_DELETED***
		List<WebElement> checkrows= driver.findElements(By.xpath("//table[@class='table hover']/tbody/tr"));
		for (int i=1; i<checkrows.size(); i++) {
			String target=checkrows.get(i).getText();
	
		if(target.contains(targettext)) {
				System.out.println(targettext + " delete failure");
		}
		else {
			System.out.println(targettext  + " has been deleted");
			break;
		}
		}
		
		Thread.sleep(4000);
		driver.quit();
	}
}
