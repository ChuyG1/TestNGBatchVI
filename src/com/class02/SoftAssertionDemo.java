package com.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pages.DashBoardPageElements;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class SoftAssertionDemo extends CommonMethods {
//	open application
//	verify logo is displayed
//	enter valid credentials
//	verify user successful logged in, by verify welcome Msg
	
	@BeforeMethod
	public void openBrowserAndNavigate(){
		setUp();
	}
	
	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

	@Test
	public void logoAndWelcomeValidation() {
		LoginPageElements login=new LoginPageElements();
		DashBoardPageElements dashboard=new DashBoardPageElements();
		
		//logo assertion
		boolean logoDisplayed = login.logo.isDisplayed();
		
		//if i do a hard assert, the code will not continue executing
		//Assert.assertTrue(logoDisplayed, "Logo is not displayed");
		
		//if i do a soft assert, the code will continue executing
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(logoDisplayed, "logo is not displayed");
		
		//logging in
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.LoginBtn);
		
		//welcome msg assertion
		boolean msgDisplayed=dashboard.welcome.isDisplayed();
		//Assert.assertTrue(msgDisplayed);
		soft.assertTrue(msgDisplayed);
		
		//this will check if all assertions passed or failed
		soft.assertAll();
}


}
