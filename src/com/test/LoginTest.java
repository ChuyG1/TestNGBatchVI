package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class LoginTest extends CommonMethods {
	
//	@BeforeMethod
//	public void openBrowser() {
//		setUp();
//		initialize(); 
//	}
//
//	@AfterMethod
//	public void closeBrowser() {
//		tearDown();
//	}
	
	@Test
	public void validAdminLogin() throws InterruptedException {
		//LoginPageElements login=new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.LoginBtn);
		wait(2);
		
		//DashBoardPageElements db= new DashBoardPageElements();
		String expectedUsers="Welcome Admin";
		String actualUser=dashboard.welcome.getText();
		Assert.assertEquals(actualUser, expectedUsers, "Admin is NOT logged in");
		Assert.assertTrue(actualUser.contains(ConfigsReader.getProperty("username")));
		
	}
	
	
	@Test
	public void invalidPasswordLogin() {
		//LoginPageElements login= new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, "uiuguig");
		click(login.LoginBtn);
		
		String expected="Invalid credentials";
		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
	}
	
	@Test(enabled=true)
	public void emptyUsernameLogin() {
		//LoginPageElements login= new LoginPageElements();
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.LoginBtn);
		
		String expected="Username cannot be empty";
		
		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");  
	}
}
