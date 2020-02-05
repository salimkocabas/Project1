package review_08January;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicTables extends CommonMethods {
public static void main(String[] args) throws InterruptedException {
	setUp("chrome",Constants.HRMS_URL);
	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Hum@nhrm123");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='menu_recruitment_viewRecruitmentModule']/b")).click();
    String empName = "Shavkat Irmukhamedov";
    List<WebElement> names = driver.findElements(By.id("//table[@id='resultTable']/tbody/tr[1]/td[3]/a"));
    String firstHalfXpath = "//table[@id = 'resultTable']/tbody/tr[";
    String secondHalfXpath = "]/td[3]/a";
    List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
    for(int i = 1; i<=rows.size(); i++) {
        String name = driver.findElement(By.xpath(firstHalfXpath + i + secondHalfXpath)).getText();
        System.out.println(name);
        if(name.equalsIgnoreCase(empName)) {
            System.out.println("TC passed : Name in the list");
            driver.findElement(By.xpath(firstHalfXpath + i + secondHalfXpath)).click();
        }
    }
	/*
			if(target.contains(targettext)) {
				found=true;
				driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[1]")).click();
				Thread.sleep(100);
				break;
			}

		}
		*/
	
	Thread.sleep(5000);
	driver.quit();
	
	
}
}
