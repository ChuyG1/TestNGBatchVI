package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class TitleLogoAndLoginTest extends CommonMethods{
	
	@BeforeMethod
	public void openAndNavigate() throws InterruptedException {
		setUp();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
	@Test
	public void logoValidation() {
		String logoPath="//div[@id='divLogo']/img";
		WebElement logo=driver.findElement(By.xpath(logoPath));
		boolean isDisplayed=logo.isDisplayed();
		if(isDisplayed) {
			System.out.println("logoValidation passed");
		}else {
			System.out.println("logoValidation failed");
		}
	}
	
	@Test
	public void titleValidation() {
		String expectedTitle="Human Management System";
		String actualTitle= driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("titleValidation passed");
		}else {
			System.out.println("titleValidation failed");
		}
	}
	
	@Test
	public void validLogin() throws InterruptedException {
		WebElement username=driver.findElement(By.id("txtUsername"));
		//sendText(username, "Admin");
		sendText(username, ConfigsReader.getProperty("username"));
		
		WebElement password=driver.findElement(By.id("txtPassword"));
		//sendText(password, "Hum@anhrm123");
		sendText(password, ConfigsReader.getProperty("password"));
		
		click(driver.findElement(By.id("btnLogin")));
		
		//hw
		//Validate that welcome Admin is displayed
		//check the reports in test-output folder
		Thread.sleep(2000);
	}
}
