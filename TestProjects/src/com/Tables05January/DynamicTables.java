package com.Tables05January;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicTables {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/macbook/Desktop/SeleniumJava/TestProjects/MyFirstLib/Drivers/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		/*List<WebElement> headers=driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/th"));
		System.out.println(headers.size());
		for (int i=1; i<headers.size(); i++) {
			String hnames=headers.get(i).getText();
			System.out.println(hnames); 
		} */
		String targettext= "Susan McLaren";
		System.out.println("***************row data**************");
		List<WebElement> rows=driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr"));
			for(int x=1; x<rows.size(); x++) {
				String data=rows.get(x).getText();
				//System.out.println(data); 
				if (data.contains(targettext)) {
				driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr[" + (x+1) + "]/td[13]")).click();
			break;
				}
			}
			WebDriverWait wait=new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_MainContent_fmwOrder_txtName")));
			driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']")).sendKeys("Susan Turk");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']")).clear();
			driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']")).sendKeys("999999999999");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@class='btn_light'] ")).click();
			Thread.sleep(3000);
			String verifytext= "Susan Turk";
			String verifycard= "999999999999";
			List<WebElement> newrows=driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr"));
			for(int x=1; x<newrows.size(); x++) {
				String data=newrows.get(x).getText();
				//System.out.println(data); 
				if (data.contains(verifytext)|| data.contains(verifycard)) {
				System.out.println(verifytext + " info has been updated");
			break;
				}
			}
			
			/*List<WebElement> cols=driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/th"));
			System.out.println("***************data cell by cell **************");
			
			for (int i=2; i<rows.size(); i++) {
				for (int y=1; y<headers.size(); y++) {
					String celldata= driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr[" + i + "]/td[" + y + "]")).getText();
					System.out.println(celldata); 
				}
			}
			*/
			
			
			
		Thread.sleep(5000);
		driver.quit();
		}

	}


