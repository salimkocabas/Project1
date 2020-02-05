package testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Elements.AddEmployeePage;
import com.Elements.LoginPage;
import com.Elements.PersonalDetailsPage;
import com.utils.CommonMethods;
import com.utils.Constants;
import com.utils.IOfromMOfiles;


public class AddEmployeePageTest extends CommonMethods {
	

	@Test(dataProvider="getData", groups="smoke")
    public void addMultipleEmpoyee(String firstName, String middleName, String lastName) throws InterruptedException {
       
		LoginPage login = new LoginPage();
		gotoHRMSDashboard();
		test.info("Login in into HRMS");
		login.AddEmplink.click();
		test.info("Navigating to the add Employee Page");

        test.info("Adding Employee");
        AddEmployeePage addEmp=new AddEmployeePage();
    
        sendText(addEmp.firstName, firstName);
        sendText(addEmp.middleName, middleName);
        sendText(addEmp.lastName, lastName);
        String empId=addEmp.empId.getAttribute("value");
     
        Thread.sleep(1000);
        click(addEmp.saveBtn);      
        test.info("Validating Employee is added");
        PersonalDetailsPage pdw= new PersonalDetailsPage();
        
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(pdw.empId));     
        String actEmpId=pdw.empId.getAttribute("value");
    
        Assert.assertEquals(actEmpId, empId);
    }
    
    @DataProvider
    public Object[][] getData(){
        return IOfromMOfiles.excellintoArray(Constants.XLPATH, "AddEmployee");
    }
}
