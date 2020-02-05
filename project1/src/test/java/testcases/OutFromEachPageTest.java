package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Elements.DashBoardPage;
import com.Elements.LoginPage;
import com.utils.CommonMethods;

public class OutFromEachPageTest extends CommonMethods{
	
//	@BeforeClass(alwaysRun = true)
//	public void openAndNavigate() {
//		LoginPage login = new LoginPage();
//		LoginPage login=new LoginPage();
//		IOfromMOfiles.openExcel(Constants.XLPATH,"Login");
//		sendText(login.username, IOfromMOfiles.getCellData(1, 0));
//		sendText(login.password,IOfromMOfiles.getCellData(1, 1));
//		click(login.loginBtn);
//	
//	}
//	@AfterClass  (alwaysRun = true)
//	public void quitBrowser() {
//		driver.quit();
//	}

	
	@Test (groups="smoke")
	public void outFromAddEmploye() throws InterruptedException{
		LoginPage login=new LoginPage();
		gotoHRMSDashboard();
		login.PIMlink.click();
		login.AddEmplink.click();
		test.info("Navigated to AddEmployee");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.linkText("Logout")).click();
		boolean islogout= driver.findElement(By.xpath("//input[@id='btnLogin']")).isDisplayed();
		Assert.assertTrue(islogout, "***NOT LOGIN FROM ADDEMPLOYEE PAG***E");
	
	}
	
	@Test (groups="smoke")
	public void outFromDashBoard() throws InterruptedException{
	
		gotoHRMSDashboard();
		
		DashBoardPage dash= new DashBoardPage();
		dash.dashboard.click();
		test.info("Navigated to Dashboard");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.linkText("Logout")).click();
		boolean islogout= driver.findElement(By.xpath("//input[@id='btnLogin']")).isDisplayed();
		Assert.assertTrue(islogout, "***NOT LOGIN FROM ADDEMPLOYEE PAG***E");
	
	}
	@Test (groups="smoke")
	public void outFromTimesheet() throws InterruptedException {

		gotoHRMSDashboard();
		DashBoardPage dash= new DashBoardPage();
		dash.timesheetlink.click();
		test.info("Navigated to TimeSheet");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.linkText("Logout")).click();
		boolean islogout= driver.findElement(By.xpath("//input[@id='btnLogin']")).isDisplayed();
		Assert.assertTrue(islogout, "***NOT LOGIN FROM ADDEMPLOYEE PAG***E");
	}
	@Test (groups="smoke")
	public void outFromDirectory() throws InterruptedException {
	
		gotoHRMSDashboard();
	
		driver.findElement(By.linkText("Directory"));
		test.info("Navigated to Directory");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.linkText("Logout")).click();
		boolean islogout= driver.findElement(By.xpath("//input[@id='btnLogin']")).isDisplayed();
		Assert.assertTrue(islogout, "***NOT LOGIN FROM ADDEMPLOYEE PAGE***");
	}
	@Test (groups="smoke")
	
	public void outFromPerformance() throws InterruptedException {
	
		gotoHRMSDashboard();		
		driver.findElement(By.linkText("Performance"));
		test.info("Navigated to Performance");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.linkText("Logout")).click();
		boolean islogout= driver.findElement(By.xpath("//input[@id='btnLogin']")).isDisplayed();
		Assert.assertTrue(islogout, "***NOT LOGIN FROM ADDEMPLOYEE PAGE***");
	}
	@Test (groups="smoke")
	public void outFromRecruitment() throws InterruptedException {

		gotoHRMSDashboard();
		
		driver.findElement(By.linkText("Recruitment"));
		test.info("Navigated to Recruitment");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.linkText("Logout")).click();
		boolean islogout= driver.findElement(By.xpath("//input[@id='btnLogin']")).isDisplayed();
		Assert.assertTrue(islogout, "***NOT LOGIN FROM ADDEMPLOYEE PAGE***");
	}
	
	
}
