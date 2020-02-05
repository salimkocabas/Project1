package com.Test2;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class LogoutfromAllPagesTest extends CommonMethods {

	@BeforeMethod(alwaysRun = true)
	public void openAndNavigate() {
		setUp("chrome", Constants.HRMS_URL);
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	@Test (groups="smoke")
	public void outFromAddEmploye() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("PIM")));
		driver.findElement(By.linkText("PIM")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Add Employee")));
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.linkText("Logout")).click();
		boolean islogout= driver.findElement(By.xpath("//input[@id='btnLogin']")).isDisplayed();
		Assert.assertTrue(islogout, "NOT LOGIN FROM ADDEMPLOYEE PAGE");
		
	
	}
	@Test (groups="regression")
	public void outFromTimesheet() throws InterruptedException {
		driver.findElement(By.linkText("Dashboard")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//img[@src='/humanresources/symfony/web/webres_5acde3dbd3adc6.90334155/orangehrmTimePlugin/images/MyTimesheet.png']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.linkText("Logout")).click();
		boolean islogout= driver.findElement(By.xpath("//input[@id='btnLogin']")).isDisplayed();
		Assert.assertTrue(islogout, "NOT LOGIN FROM ADDEMPLOYEE PAGE");
	}
	@Test (groups="smoke")
	public void outFromDashboard() throws InterruptedException {
		driver.findElement(By.linkText("Dashboard")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.linkText("Logout")).click();
		boolean islogout= driver.findElement(By.xpath("//input[@id='btnLogin']")).isDisplayed();
		Assert.assertTrue(islogout, "NOT LOGIN FROM ADDEMPLOYEE PAGE");
	}
	@AfterMethod  (alwaysRun = true)
	public void quitBrowser() {
		driver.quit();
	}

}

