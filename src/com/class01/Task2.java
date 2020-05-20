package com.class01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task2 {
	
	@BeforeClass
	public void beforeClass1(){
		System.out.println("before class 1");
	}
	
	@BeforeMethod
	public void beforeMethod1() {
		System.out.println("before method 1");
	}
	
	@Test
	public void test1() {
		System.out.println("test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("test 2");
	}
	
	@AfterClass
	public void afterClass1() {
		System.out.println("after class 1");
	}
	
	@AfterMethod
	public void afterMethod1() {
	System.out.println("after method 1");
	}
}
