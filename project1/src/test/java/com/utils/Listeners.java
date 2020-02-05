package com.utils;


import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.testbase.BaseClass;

public class Listeners extends BaseClass implements ITestListener{
	
	public void onStart(ITestContext context) {
		System.out.println("everything " + context.getName());
		
	}
	
	public void onTestStart(ITestResult result) {
		 System.out.println("Test started " + result.getName());
		  test= report.createTest(result.getName());
		
	}


		  public void onTestSuccess(ITestResult result) {
			  System.out.println("test passed " + result.getName());
			  test.pass("Test Passed " + result.getName());
			  String imagePath= CommonMethods.takeScreenshot("passed/"+result.getName());
			  try {
				test.addScreenCaptureFromPath(imagePath);
			} catch (IOException e) {
		
				e.printStackTrace();
			}
			  
		
		  }

		public void onTestFailure(ITestResult result) {
			System.out.println("test failed" +result.getName());
			test.fail("Test Failed "+ result.getName());
			 String imagePath= CommonMethods.takeScreenshot("failed/"+result.getName());
			 try {
				test.addScreenCaptureFromPath(imagePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
			 
			
	
		  }

		public void onTestSkipped(ITestResult result) {
		System.out.println("***");
		  }
}
