package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements {

	@FindBy(id="txtUsername")
	public WebElement username;
	
	@FindBy(name="txtPassword")
	public WebElement password;
	
	@FindBy(css="input#btnLogin")
	public WebElement LoginBtn;
	
	@FindBy(xpath="//div[@id='divLogo']/img")
	public WebElement logo;
	
	@FindBy(id="spanMessage")
	public WebElement errorMsg;
	
	public LoginPageElements() {
		PageFactory.initElements(com.utils.BaseClass.driver, this);
	}
}