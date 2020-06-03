package com.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.LoginPageElements;
import com.utils.CommonMethods;

public class AssertionDemo extends CommonMethods {
	//this is also called hard Assertion
	//@BeforeMethod
//	public void openBrowserAndNavigate(){
//		setUp();
//	}
//	
	//@AfterMethod
//	public void quitBrowser() {
//		tearDown();
//	}
	
	//assertion error is handled within TestNG
	//even if one test fails, the others will still execute
	@Test
	public void titleValidation() {
		String expectedTitle="Human Management System";
		String actualTitle=driver.getTitle();
		
		//1st way
		//Assert.assertEquals(actualTitle, expectedTitle);
		
		//2nd way, in this version you also leave a Msg
		Assert.assertEquals(actualTitle, expectedTitle, "Title does not match");
		//if the assertion fails, this statement will not be executed.
		System.out.println("Text after Assertion");
		
}
	@Test
	public void logoValidation() {
		LoginPageElements login=new LoginPageElements();
		boolean logoDisplayed=login.logo.isDisplayed();
		
		//1st way
		//Assert.assertEquals(logoDisplayed, true, "Logo is not displayed");
		
		//2nd way
		Assert.assertTrue(logoDisplayed, "Logo is displayed");
		
	}
}
