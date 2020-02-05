package review_08January;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class HWAA extends CommonMethods{

	public static void main(String[] args) throws InterruptedException, IOException {
		setUp("firefox",Constants.AA_AIRLINES);
		
		driver.manage().deleteAllCookies();
		driver.findElement(By.id("reservationFlightSearchForm.originAirport")).clear();
		driver.findElement(By.id("reservationFlightSearchForm.originAirport")).sendKeys("istan");
		Thread.sleep(1000);
		driver.findElement(By.linkText("IST - Istanbul, Turkey")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("reservationFlightSearchForm.destinationAirport")).sendKeys("newyork");
		Thread.sleep(1000);
		driver.findElement(By.linkText("NYC - New York, NY")).click();
		
		
		//***CHOSE DEPART DATE****
		driver.findElement(By.id("aa-leavingOn")).click();
		for(int i=0;i<12;i++) {
			WebElement months=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
			String depart=months.getText();
			if(depart.equals("May")) {
				List <WebElement> cells=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
				for (WebElement cell:cells){
					if (cell.getText().equals("14")){
						Thread.sleep(1000);
					cell.click();
					System.out.println("May 14 clicked");
					break;
					}
				}
				break;
				}
			
			 else{
				driver.findElement(By.xpath("//a[@title='Next']")).click();
			}
		}
		
		
		//***CHOSE RETURN DATE***
		driver.findElement(By.id("aa-returningFrom")).click();
		
		for(int i=0;i<12;i++) {
			WebElement months=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
			String returning=months.getText();
		    if(returning.equals("November")) {
				List <WebElement> cells=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
				for (WebElement cell:cells){
					if (cell.getText().equals("8")){
						Thread.sleep(1000);
					cell.click();
					System.out.println("Now 8 clicked");
					break;
					}
				}
				break;
				}
			
			 else{
				driver.findElement(By.xpath("//a[@title='Next']")).click();
			}
		}
driver.findElement(By.id("flightSearchForm.button.reSubmit")).click();
driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
String textshown=driver.findElement(By.xpath("//*[@id=\"aa-pageTitle\"]")).getText();

boolean text=driver.findElement(By.xpath("//*[@id=\"aa-pageTitle\"]")).isDisplayed();
if (text) {
	System.out.println("text captured = "+textshown);
}
else {
	System.out.println("text not shown");
}

TakesScreenshot ts=(TakesScreenshot) driver;
Thread.sleep(1000);
File source = ts.getScreenshotAs(OutputType.FILE);

FileUtils.copyFile(source, new File("ScrShots/TASKS/aaticket.jpg"));

		Thread.sleep(4000);
		driver.quit();
		


	}

}

