package com.januaary14;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HW extends CommonMethods{
	@BeforeMethod
public void navigate() {
		setUp("chrome", Constants.HRMS_URL);
	
}
	
	@Test (dataProvider="getData")
	public void addemployee(String firstname, String lastname,String username,String pass) throws InterruptedException {
		//GOTO PAGE
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.name("Submit")).click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("PIM")));
		driver.findElement(By.linkText("PIM")).click();
		
		WebDriverWait wait1=new WebDriverWait(driver,10);
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Add Employee")));
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		//ADD NAME
		driver.findElement(By.id("firstName")).sendKeys(firstname);
		driver.findElement(By.id("lastName")).sendKeys(lastname);
		driver.findElement(By.id("chkLogin")).click();
		Thread.sleep(500);
		//ADD USERNAME and PASWORD
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(pass);
		driver.findElement(By.id("re_password")).sendKeys(pass);
		Thread.sleep(500);
		driver.findElement(By.id("btnSave")).click();
	
	
	
		//CHECK
		String empId=driver.findElement(By.id("employeeId")).getAttribute("value");
		String actualEmpId=driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
	    Assert.assertEquals(actualEmpId, empId, "Employee ID did not match");
		//SCREENSHOT
		TakesScreenshot ts=(TakesScreenshot) driver;
		Thread.sleep(500);
		File source = ts.getScreenshotAs(OutputType.FILE);
		Thread.sleep(500);
		try {
			
			FileUtils.copyFile(source, new File("Screen/HW"+firstname+".png"));
			 
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] data= {
				{"Tuna1","İyitester","Tuna11","Tuna1@123?A*"},
				{"Tuna2","Güzeltester","Tuna22","Tuna2@123?A*"},
				{"Tuna3","Süpertester","Tuna33","Tuna3@123?A*"},
				{"Tuna4","Ultratester","Tuna44","Tuna4@123?A*"},
				{"Tuna5","Xlargetester","Tuna55","Tuna5@123?A*"}
		};
		
		return data;
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
