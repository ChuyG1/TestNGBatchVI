package com.class03;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.CommonMethods;

public class DataProviderDemo extends CommonMethods {
	
	@Test(dataProvider="getData")
	public void login(String username, String password, int age) {
		System.out.println(age);
		sendText(login.username, username);
		sendText(login.password, password);
		click(login.LoginBtn);
		
		boolean isDisplayed = dashboard.welcome.isDisplayed();
		Assert.assertEquals(isDisplayed, "Welcome msg is not displayed");
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data= {
				{"Admin", "Hum@nhrm123", 23},
				{"Syntax", "Syntax123", 25},
				{"SyntaxUser", "Syntax123!", 20}
		};
		
		//2nd way of initializing a 2D-Array
		Object[][] data2=new Object[3][3];
		
		return data;
	}

	
}
