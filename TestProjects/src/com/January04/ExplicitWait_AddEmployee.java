package com.January04;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
// TC1-Add Employee
public class ExplicitWait_AddEmployee { 
	private static final String WebElement = null;

	//  **********Methods including synchronizations**********

	public static void signInKeys(WebElement element, String value, WebDriver driver, int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	public static void submitbutton(WebElement element, WebDriver driver, int timeout){
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.submit();
	}

	public static void AddEmployee(String namevalue, String lastnamevalue, WebElement staffname,WebElement stafflastname, WebDriver driver, int timeout) {
	WebDriverWait wait=new WebDriverWait(driver, timeout);
	wait.until(ExpectedConditions.elementToBeClickable(staffname));
	wait.until(ExpectedConditions.elementToBeClickable(stafflastname));
	staffname.sendKeys(namevalue);
	stafflastname.sendKeys(lastnamevalue);
	}
	
	    public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/macbook/Desktop/SeleniumJava/TestProjects/MyFirstLib/Drivers/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth");
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		
		WebElement username=driver.findElement(By.xpath("//input[@name='txtUsername']"));
		signInKeys(username, "admin",driver,20);
	    WebElement password = driver.findElement(By.xpath("//input[@name='txtPassword']"));
	    signInKeys(password,"Hum@nhrm123",driver,20);
		WebElement submit=driver.findElement(By.xpath("//input[@type='submit']"));
		submitbutton(submit,driver,20);
		//   *******go to add page ********
	
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("PIM")));
		driver.findElement(By.linkText("PIM")).click();
		
		WebDriverWait wait4=new WebDriverWait(driver,30);
		wait4.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='Add Employee']")));
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		
		WebElement staffname= driver.findElement(By.xpath("//input[@name='firstName']"));
		WebElement stafflastname=driver.findElement(By.name("lastName"));
		AddEmployee("Salim","Kocabas",staffname,stafflastname,driver,20);
		
		
		WebElement staffaddbutton = driver.findElement(By.xpath("//input[@id='btnSave']"));
		submitbutton(staffaddbutton,driver,20);
		WebDriverWait wait5=new WebDriverWait(driver, 30);
		wait5.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("PIM")));
		driver.findElement(By.linkText("PIM")).click();
		driver.manage().window().maximize();
		String targettext="Salim Kocabas";
		List<WebElement> rows= driver.findElements(By.xpath("//table[@class='table hover']/tbody/tr"));
		for (int i=1; i<rows.size(); i++) {
			String target=rows.get(i).getText();
			if(target.contains(targettext)) {
				driver.findElement(By.xpath("//table[@class='table hover']/tbody/tr[" + (i+1) + "]/td[1]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@class='delete']")).click();
				Thread.sleep(3000);
				break;
				
			}
		}
		//Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
		Thread.sleep(3000);
		
		List<WebElement> checkrows= driver.findElements(By.xpath("//table[@class='table hover']/tbody/tr"));
		for (int i=1; i<checkrows.size(); i++) {
			String target=checkrows.get(i).getText();
			if(target.contains(targettext)) {
				System.out.println(targettext + "still exists");
				
			}
			else {
				System.out.println(targettext + "has been deleted");
			}
				
		}
		
		//alert.accept();
		//********Logout*********
		/*
		driver.findElement(By.xpath("//a[@class='panelTrigger activated-welcome']")).click();
		WebDriverWait wait2=new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Logout")));
		driver.findElement(By.linkText("Logout")).click();
		*/

	    Thread.sleep(3000);
		driver.quit();	
	}
}
