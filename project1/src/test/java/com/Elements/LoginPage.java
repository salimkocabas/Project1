package com.Elements;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.BaseClass;
import com.utils.CommonMethods;

public class LoginPage extends CommonMethods{

	@FindBy(xpath = "//div[@id='divLogo']")
	public WebElement logo;
	
	@FindBy(id="logInPanelHeading")
	public WebElement loginLabel;
	
	@FindBy(name="txtUsername")
	public WebElement username;
	
	@FindBy(css="input#txtPassword")
	public WebElement password;
	
	@FindBy(css="input[name='Submit']")
	public WebElement loginBtn;
	
	@FindBy(id="spanMessage")
	public WebElement errorMsg;
	
	@FindBy(xpath= "//form[@id='frmLogin']")
	public WebElement frmlogo;
	
	@FindBy(linkText="PIM")
	public WebElement PIMlink;
	
	@FindBy(id = "menu_pim_addEmployee")
	public WebElement AddEmplink;
	

	
	public LoginPage() {
		
		PageFactory.initElements(BaseClass.driver, this);
	}
}
