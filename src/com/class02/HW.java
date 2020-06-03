package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.DashBoardPageElements;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;
import com.utils.Constants;

public class HW extends CommonMethods {
	
//	@BeforeMethod
//	public void openBrowserAndNavigate(){
//		setUp();
//	}
//	
//	@AfterMethod
//	public void quitBrowser() {
//		tearDown();
//	}
	
	@Test(priority=2, dependsOnMethods = "invalidLogin")
	public void validLogin2(){
		//WebElement username=driver.findElement(By.id("txtUsername"));
		//1st way
		//username.sendKeys(ConfigsReader.getProperty("username"));
		
		//2nd way
		//sendText(username, ConfigsReader.getProperty("username"));
		
		//3rd way
		LoginPageElements login=new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		
		sendText(login.password, ConfigsReader.getProperty("password"));
		
		//1st way
		//WebDriverWait wait= new WebDriverWait (driver, Constants.EXPLICIT_WAIT_TIME);
		//wait.until(ExpectedConditions.elementToBeClickable(login.LoginBtn));
		//login.LoginBtn.click();
		
		//2nd way
		//waitForClickability(login.LoginBtn);
		//login.LoginBtn.click();
		
		//3rd way
		click(login.LoginBtn);
		
		DashBoardPageElements dashboard=new DashBoardPageElements();
		
		boolean displayed = dashboard.logo.isDisplayed();
		if(displayed) {
			System.out.println("logo is displayed");
		}else {
			System.out.println("logo is not displayed");
		}
	
		
	}
	//case 1: if this test method is disabled 
	@Test(priority=3, enabled = true)
	public void invalidLogin() throws Exception{
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		click(login.LoginBtn);
		
		String expectedText ="Password cannot be empty";
		String actualText= login.errorMsg.getText();
		boolean errorDisplayed= login.errorMsg.isDisplayed();
		
		if(errorDisplayed) {
			System.out.println("Error is displayed");
			
			if(expectedText.equals(actualText)) {
				System.out.println("Error msg is correct");
			}else {
				System.out.println("Error msg is not correct");
			}
		}else {
			System.out.println("Error msg is not displayed");
		}
		
		
		//throw new Exception();
	}
}
