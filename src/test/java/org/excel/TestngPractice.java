package org.excel;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestngPractice {
	@BeforeSuite
	private void BeforeSuite() {
		System.out.println("before Suite");
	}

/*	@BeforeClass
	private void beforeClass() {
		System.out.println("before Class");
	}
	@BeforeTest
	private void BeforeTest() {
		System.out.println("before Test");
	}
	
	@BeforeMethod 
	private void beforeMethod() {
		System.out.println("before Method");
	}*/
	@Test(invocationCount=2)
	private void test2() {
		System.out.println("abc");
	}
	@Test(invocationCount=5)@Ignore
	private void test() {
		System.out.println("test");
	}
	@Test(invocationCount=2)
	private void test1() {
		System.out.println("test1");
	}
	@Test(priority= -1)
	private void test3() {
		System.out.println("efg");
	}
	/*@AfterMethod
	private void AfterMethod() {
		System.out.println("afterMethod");
	}
	@org.testng.annotations.AfterClass
	private void AfterClass() {
		System.out.println("after Class");
	}
	@AfterTest
	private void AfterTest() {
		System.out.println("after Test");
	}*/
	@AfterSuite
	private void AfterSuite() {
		System.out.println("after suite");
	}
}
