package com.januaary14;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlwaysRun {
@BeforeMethod (alwaysRun=true)
public void beforemthhod() {
	System.out.println("I am beforre mthod");
	
}
@AfterMethod
public void afterMethhod() {
	System.out.println("I am afterMethod");
}

@Test
public void testMethhod() {
	System.out.println("I am test");
}
}
