package com.Test1;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class LoginPageTest extends CommonMethods {
	
	@BeforeMethod(alwaysRun = true)
	public void openAndNavigate() {
		setUp("chrome", Constants.HRMS_URL);
	}
	
	@Test(groups="smoke")
	public void mainPageLoaded() {
			String expectedTitle = "Human Management System";
			String actualTitle = driver.getTitle();// Human Management System
			Assert.assertEquals(actualTitle, expectedTitle, "Titles are NOT matched");
		
	}
	
	@Test(groups="smoke")
	public void adminLogin() {
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.name("Submit")).click();
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='welcome']")));
		boolean isadminin=driver.findElement(By.xpath("//a[@id='welcome']")).isDisplayed();
		Assert.assertTrue(isadminin);	
	}
	
	@Test (groups="smoke")
	public void loginLogoPresent() {
		boolean loginlogo= driver.findElement(By.xpath("//form[@id='frmLogin']")).isDisplayed();
		Assert.assertTrue(loginlogo, "LoginLogo Not Presented");
	}
	
	@Test (groups="smoke")
	public void userLogin() {
		setUp("chrome", Constants.HRMS_URL);
		driver.findElement(By.name("txtUsername")).sendKeys("Tuna11");
		driver.findElement(By.name("txtPassword")).sendKeys("Tuna1@123?A*");
		driver.findElement(By.name("Submit")).click();
		WebDriverWait wait= new WebDriverWait(driver, 30);
	boolean isuserin= driver.findElement(By.xpath("//a[text()='Welcome Tuna1']")).isDisplayed();
	Assert.assertTrue(isuserin, "USER CANT LOGIN"); }
	
	@Test (groups="regression")
	public void negativeAdminLogin() {
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys(" ");
		driver.findElement(By.name("Submit")).click();
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='spanMessage']")));
		boolean isempty=driver.findElement(By.xpath("//span[@id='spanMessage']")).isDisplayed();
		Assert.assertTrue(isempty, "PASSWORD CANT BE EMPTY MESSAGE NOT DISPLAYED");
		
	}
	
	
	@AfterMethod(alwaysRun=true)
	
	public void logOut () {
		driver.quit();
	}
}
	
	

