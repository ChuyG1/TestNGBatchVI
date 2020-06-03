package com.test;

import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class AddEmployeeTest extends CommonMethods {
	
//	public void openBrowser() {
//		setUp();
//	}
//	
//	@AfterMethod
//	public void closeBrowser() {
//		tearDown();
//	}
	
	@Test
	public void addEmployeePage() {
		
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmployee();
		
		
	//	sendText(addEmp.empFirstName, ConfigsReader.getProperty("employeeFirstname"));
	//	sendText(addEmp.empLastName, ConfigsReader.getProperty("employeeLastname"));
	//	sendText(addEmp.addPhoto, ConfigsReader.getProperty("filePath"));
	//	waitAndClick(addEmp.saveEmp);
	}
}
