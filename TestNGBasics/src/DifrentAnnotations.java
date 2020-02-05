import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DifrentAnnotations {
@BeforeSuite
public void beforeSuite() {
	System.out.println("Beforre Suite");
}

@AfterSuite
public void afterSuite() {
	System.out.println("After Suite");
}

@BeforeTest
public void beforeTest() {
	System.out.println("Beforre Test");
}

@AfterTest
public void afterTest() {
	System.out.println("After Test");
	
}

@BeforeMethod
public void beforeMethods() {
	System.out.println("Before Methods");
}

@AfterMethod
public void afterMethod() {
	System.out.println("After Method");
}
@BeforeClass
public void beforeClass() {
	System.out.println("Before Class");
}
@AfterClass
public void afterClass() {
	System.out.println("After Class");
}
@Test
    public void test() {
	System.out.println("Tested");
}


}
