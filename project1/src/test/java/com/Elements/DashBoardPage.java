package com.Elements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.BaseClass;
import com.utils.CommonMethods;


public class DashBoardPage extends CommonMethods{
	@FindBy(linkText = "Leave")
	public WebElement leaveLnk;

	@FindBy(linkText = "Leave List")
	public WebElement leaveList;

	@FindBy(linkText = "PIM")
	public WebElement pim;

	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmp;

	@FindBy(id = "welcome")
	public WebElement welcomeLnk;
	
	@FindBy(linkText="Dashboard")
	public WebElement dashboard;
	
	@FindBy(xpath="//a[@href='/Syntax_HRM/symfony/web/index.php/time/viewEmployeeTimesheet']/img")
	public WebElement timesheetlink;
	
	@FindBy(xpath="//input[@id='employee']")
	public WebElement searcbox;
	
	@FindBy(xpath="//input[@type='button' and @value='View']")
	public WebElement ViewBtn;
	
	@FindBy(xpath="//div[@class='message warning']")
	public WebElement nofoundlogo;
	
	@FindBy(id=("btnAddTimesheet"))
	public WebElement AddTimesheetbtn;
	
	@FindBy(xpath=("//canvas[@class='flot-overlay']"))
	public WebElement canvaslogo;

	public DashBoardPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}


	
}
