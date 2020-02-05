package com.utils;

public class Constants {

	public static final String HRMS_URL="http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
	public static final String NEWHRMS_URL="http://166.62.36.207/Syntax_HRM/symfony/web/index.php/auth/login";

	public static final String BROWSER="chrome";
	
	
	public static final String CHROME_DRIVER_PATH=System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver";
			
	public static final String GECKO_DRIVER_PATH=System.getProperty("user.dir")+"/src/test/resources/drivers/geckodriver";
	
	public static final int PAGE_LOAD_TIME=30;
	
	public static final int IMPLICIT_LOAD_TIME=10;
	
	public static final int EXPLICIT_LOAD_TIME=30;
	public static final String CREDENTIALS_FILEPATH= System.getProperty("user.dir")+"/src/test/resources/configs/config.txt";
	public static final String XLPATH= System.getProperty("user.dir")+"/src/test/resources/configs/FirstXL.xlsx";
	public static final String REPORT_FILEPATH= System.getProperty("user.dir")+"/target/report/project1.html";
	public static final String OS_NAME=System.getProperty("os.name");
	
	public static final String USER_NAME=System.getProperty("user.name");
	
	public static final String SCREENSHOTS_FILEPATH=System.getProperty("user.dir")+"/src/target/screenshots/";
}

