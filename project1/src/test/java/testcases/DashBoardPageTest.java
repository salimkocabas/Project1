package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Elements.DashBoardPage;
import com.utils.CommonMethods;

public class DashBoardPageTest extends CommonMethods {
	DashBoardPage dash = new DashBoardPage();

	@Test(groups = "regression" )  // Check Timesheet for Zeynep
	public void checkTimeSheet() {
		gotoHRMSDashboard();

		jsClick(dash.timesheetlink);

		dash.searcbox.clear();
		dash.searcbox.sendKeys("Zeynep Azer Baseova");
		jsClick(dash.ViewBtn);
		boolean notimesheet = dash.nofoundlogo.isDisplayed();
		Assert.assertTrue(notimesheet);
	}

	@Test(groups = "regression") // Add TimeSheet for James
	public void addTimeSheet() throws InterruptedException {
		gotoHRMSDashboard();
		jsClick(dash.timesheetlink);
	
		Thread.sleep(500);
		dash.searcbox.clear();
		dash.searcbox.sendKeys("James Smith");
		jsClick(dash.ViewBtn);
		Thread.sleep(500);
		jsClick(dash.AddTimesheetbtn);

		driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		WebElement months = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']/option"));
		Select month = new Select(months);
		month.deselectByVisibleText("Apr");
		WebElement years = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']/option"));
		Select year = new Select(years);
		year.deselectByVisibleText("2019");
		List<WebElement> cells = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		for (WebElement cell : cells) {
			if (cell.getText().equals("15")) {
				Thread.sleep(500);
				cell.click();
				break;
			}
			boolean ishwon = driver.findElement(By.xpath("//td[@id='noRecordsColumn']")).isDisplayed();
			Assert.assertTrue(ishwon, "***NO RECORD FOR TIMESHEET NOT SHOWN***");

		}
	}

	@Test(groups = "regression") // check canvas logo
	public void canvasLogo() throws InterruptedException {
		gotoHRMSDashboard();

		Thread.sleep(1000);

		boolean isshown = dash.canvaslogo.isDisplayed();
		Assert.assertTrue(isshown, "***CANVAS LOGO NOT DISPLAYED***");

	}

}
