package com.January09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import review_08January.CommonMethods;
import review_08January.Constants;

public class Examples extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
	     
	        setUp("chrome", Constants.GURU);  
	        
	        WebElement link_Home = driver.findElement(By.linkText("Home"));
            WebElement td_Home = driver
                    .findElement(By
                    .xpath("//html/body/div"
                    + "/table/tbody/tr/td"
                    + "/table/tbody/tr/td"
                    + "/table/tbody/tr/td"
                    + "/table/tbody/tr"));    ////a[text()='Home'] 
             
            Actions builder = new Actions(driver);
            Action mouseOverHome= builder.moveToElement(link_Home).build();
                   
             
            String bgColor = td_Home.getCssValue("background-color");
            System.out.println("Before hover: " + bgColor);        
            mouseOverHome.perform();        
            bgColor = td_Home.getCssValue("background-color");
            System.out.println("After hover: " + bgColor);
            
            Thread.sleep(3000);
            driver.close();
    
	            
	                
	               
	}

	}


