package com.FirstTest;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Sleeper;
public class FisrtTestAttempt {
public static void main(String[] args) throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", "/Users/macbook/Desktop/SeleniumJava/TestProjects/MyFirstLib/Drivers/geckodriver");
		
FirefoxDriver driver=new FirefoxDriver();
driver.get("http://vivarplproject.eu");

File screen= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

try {

	FileUtils.copyFile(screen, new File("c://nnnnnnn"));
}
catch(IOException e) {
	e.printStackTrace();
}//*[@id="loginpassword"]
//*[@id="loginpassword"]
	}
<span class="hidden-xs">Giriş</span>
	}
//firefox.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL+"t");
//Thread.sleep(2000);
//firefox.navigate().refresh();
//firefox.get("https://www.facebook.com/");
//JavascriptExecutor ex= (JavascriptExecutor)driver; (scroll down)
//ex.executeScript("scrollBy(500,5500)");