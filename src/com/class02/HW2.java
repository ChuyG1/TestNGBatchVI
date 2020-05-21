package com.class02;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.utils.CommonMethods;

public class HW2 extends CommonMethods {

	@BeforeMethod
	public void openBrowserAndNavigate(){
		setUp();
	}
	
	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
	
}
