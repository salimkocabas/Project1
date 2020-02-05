package com.testbase;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.utils.Constants;
import com.utils.IOfromMOfiles;


public class BaseClass {

	public static WebDriver driver;
	public static ExtentHtmlReporter html;
	public static ExtentReports report;
	public static ExtentTest test;
	
	@BeforeTest (alwaysRun=true)
	public void generateReports() {
		//ConfigsReader.readProperties(Constants.CREDENTIALS_FILEPATH);//Asel Used
		IOfromMOfiles.openExcel(Constants.XLPATH, "Config"); //I used
		html=new ExtentHtmlReporter(Constants.REPORT_FILEPATH);
		html.config().setTheme(Theme.DARK);
		html.config().setDocumentTitle("Salim's First TestNG Framework with Maven");
		html.config().setReportName("Project1");
		
		report= new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("QA Engineer", Constants.USER_NAME);
		report.setSystemInfo("Environment", "Test");
		report.setSystemInfo("OS Name", Constants.OS_NAME);
		report.setSystemInfo("Browser", IOfromMOfiles.getCellData(1, 0));
		
		
		try {
			IOfromMOfiles.closeExcel();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@AfterTest(alwaysRun=true)
	public void writeReport(){
		report.flush();
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		IOfromMOfiles.openExcel(Constants.XLPATH, "Config");

		switch (IOfromMOfiles.getCellData(1, 0).toLowerCase()) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();
			break;
		default:
			System.err.println("Browser is not supported");
		}
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_LOAD_TIME, TimeUnit.SECONDS);
		//driver.manage().window().maximize();

		driver.get(Constants.NEWHRMS_URL);
	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
}
