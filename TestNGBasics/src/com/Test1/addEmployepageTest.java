package com.Test1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class addEmployepageTest extends CommonMethods {

	@BeforeMethod(alwaysRun = true)
	public void goToAddPage() {
		setUp("chrome", Constants.HRMS_URL);
		driver.manage().window().fullscreen();
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("PIM")));
		driver.findElement(By.linkText("PIM")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Add Employee")));
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
	}

	@Test (priority=1, groups="regression")
	public void addEmployeeTest() {

		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Salimy");
		driver.findElement(By.name("lastName")).sendKeys("Kocabasbas");
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Personal Details']")));
		boolean ispersonaldetailshown = driver.findElement(By.xpath("//h1[text()='Personal Details']")).isDisplayed();
		Assert.assertTrue(ispersonaldetailshown, "ADDING EMPLOYEE FAIL");

	}

	@Test (priority=2, groups="regression")
	public void deleteEmployee() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
		Thread.sleep(500);
		String targettext="Salimy";
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='resultTable']/tbody/tr")));
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
		List<WebElement> checkrows= driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		for (int i=1; i<checkrows.size(); i++) {
			String target=checkrows.get(i).getText();
	
		if(target.contains(targettext)) {
			
			Assert.assertTrue(true);
			break;
		}
		else {
			driver.findElement(By.xpath("//a[text()='Next']")).click();
		}
		}
	}
	
	@Test (groups="regression")
	public void negativesearch() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']")).sendKeys("zzzz");
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		Thread.sleep(500);
		boolean isdisplayed= driver.findElement(By.xpath("//td[text()='No Records Found']")).isDisplayed();
		Assert.assertTrue(isdisplayed, "NEGATIVE EPLOYEE SEARCH NOT WORK");
		
	}
	@AfterMethod  (alwaysRun = true)
	public void quitBrowser() {
		driver.quit();
	}
	
}
	
	

	
	
	
	

