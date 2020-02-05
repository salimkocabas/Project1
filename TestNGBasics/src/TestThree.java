import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestThree {
	
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
	public void methodtest1() {
		System.out.println("Before Methods 1");
	}
	public void methodtest2() {
		System.out.println("Before Methods 2");
	}

	@AfterMethod
	public void aftermethodtest1() {
		System.out.println("After Method 1");
	}
	public void aftermethodtest2() {
		System.out.println("After Method 2");
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
	    public void test1() {
		System.out.println(" 1 Tested");
	}
	   public void test2() {
			System.out.println(" 2 Tested");
		}


}
