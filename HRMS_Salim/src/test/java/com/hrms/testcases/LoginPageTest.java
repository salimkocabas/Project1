package com.hrms.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;

public class LoginPageTest extends CommonMethods{

	//@Test
	public void login() {
		LoginPageElements login=new LoginPageElements();
		sendText(login.username, "Admin");
		sendText(login.password, "Hum@nhrm123");
		click(login.loginBtn);
	}
	

	@Test
	public void negativeLogin() throws InterruptedException {
		LoginPageElements login =new LoginPageElements();
		sendText(login.username, "Admin");
		click(login.loginBtn);
		String expectedError="Password cannot be empty";
		Assert.assertEquals(login.errorMsg.getText(), expectedError, "Error message text is not matched");
		Thread.sleep(5000);
	}
}