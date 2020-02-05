package com.Test2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class DashboradPageTest extends CommonMethods {

	@BeforeMethod(alwaysRun = true)
	public void openAndNavigate() {
		setUp("chrome", Constants.HRMS_URL);
		
		driver.manage().window().fullscreen();
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	}
	
	@Test (groups="regression")
	public void checkTimeSheet() throws InterruptedException {
		driver.findElement(By.linkText("Dashboard")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//img[@src='/humanresources/symfony/web/webres_5acde3dbd3adc6.90334155/orangehrmTimePlugin/images/MyTimesheet.png']")).click();
		driver.findElement(By.xpath("//input[@id='employee']")).clear();
		driver.findElement(By.xpath("//input[@id='employee']")).sendKeys("Tuna5 Xlargetester");
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='button' and @value='View']")));
		driver.findElement(By.xpath("//input[@type='button' and @value='View']")).click();
		boolean isshown=driver.findElement(By.xpath("//td[@id='noRecordsColumn']")).isDisplayed();
		Assert.assertTrue(isshown);
	}
	@Test (groups="regression")
	public void addTimeSheet() throws InterruptedException {
		driver.findElement(By.linkText("Dashboard")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//img[@src='/humanresources/symfony/web/webres_5acde3dbd3adc6.90334155/orangehrmTimePlugin/images/MyTimesheet.png']")).click();
		driver.findElement(By.xpath("//input[@id='employee']")).clear();
		driver.findElement(By.xpath("//input[@id='employee']")).sendKeys("Tuna5 Xlargetester");
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='btnView']")));
		driver.findElement(By.xpath("//input[@id='btnView']")).click();
		Thread.sleep(500);
		driver.findElement(By.id("btnAddTimesheet")).click();
		driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		WebElement months= driver.findElement(By.xpath("//select[@class='ui-datepicker-month']/option"));
		Select month=new Select(months);
		month.deselectByVisibleText("Apr");
		WebElement years=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']/option"));
		Select year=new Select(years);
		year.deselectByVisibleText("2019");
		List <WebElement> cells=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		for (WebElement cell:cells){
			if (cell.getText().equals("15")){
				Thread.sleep(500);
			cell.click();
			break;
			}
			boolean ishwon =driver.findElement(By.xpath("//td[@id='noRecordsColumn']")).isDisplayed();
			Assert.assertTrue(ishwon, "NO RECORD FOR TIMESHEET NOT SHOWN");
		
	}
	}
	
	@Test (groups="smoke")
	public void canvasLogo() throws InterruptedException {
		driver.findElement(By.linkText("Dashboard")).click();
		Thread.sleep(500);
		boolean isshown=driver.findElement(By.xpath("//canvas[@class='flot-overlay']")).isDisplayed();
		Assert.assertTrue(isshown, "CANVAS LOGO NOT DISPLAYED");
		
	}
	@AfterMethod  (alwaysRun = true)
	public void quitBrowser() {
		driver.quit();
	}
}
	
	
	
	
	
	

