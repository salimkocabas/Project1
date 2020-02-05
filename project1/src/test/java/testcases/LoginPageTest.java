package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Elements.DashBoardPage;
import com.Elements.LoginPage;
import com.utils.CommonMethods;
import com.utils.Constants;
import com.utils.IOfromMOfiles;

public class LoginPageTest extends CommonMethods{
	
	
	@Test(groups="smoke") //Is Main Page Title Shown?
	public void mainPageLoaded() {
			String expectedTitle = "Syntax HRM";
			String actualTitle = driver.getTitle();// Human Management System
			Assert.assertEquals(actualTitle, expectedTitle, "Titles are NOT matched");
		
	}
	@Test (groups="smoke") //IS LOGIN Logo Shown?
	public void loginLogoPresent() {
		LoginPage login = new LoginPage();
		boolean loginlogo= login.frmlogo.isDisplayed();
		if (loginlogo) {
		test.info("FRMLOGO DISPLAYED");
		}
		Assert.assertTrue(loginlogo, "LoginLogo Not Presented");
	}
	@Test(dataProvider="getData")  // Multiple User Type Login Enabled?
	public void multipleLogin(String uid, String pwd) throws InterruptedException, IOException {
		LoginPage login = new LoginPage();
	    DashBoardPage dashboard=new DashBoardPage();
		
		sendText(login.username, uid );
		sendText(login.password, pwd);
		click(login.loginBtn);
		String welcomeText=dashboard.welcomeLnk.getText();
		Thread.sleep(2000);
		Assert.assertTrue(welcomeText.contains(uid), "User with username "+uid+" was not able to login");
		test.info("Multiple Users Type Logged in");
		//IOfromMOfiles.closeExcel(); //You may delete it, lets try
	}
	
	@DataProvider
	public Object[][] getData(){
		
		return IOfromMOfiles.excellintoArray(Constants.XLPATH, "Login");
		
	}


	@Test(groups="smoke") //Is Negative Login Warning Shown?
	public void negativeLogin() throws InterruptedException {
		LoginPage login = new LoginPage();
		sendText(login.username, IOfromMOfiles.getCellData(1, 0));
		click(login.loginBtn);
		test.info("Clicked Login Without Password");
		String expectedError = "Password cannot be empty";
		Assert.assertEquals(login.errorMsg.getText(), expectedError, "Error message text is not matched");
		Thread.sleep(1000);
	}
}

