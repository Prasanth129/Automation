package org.excel;

import org.testng.annotations.Test;

public class TestNg {
	
	
@Test
	private void test1() {
		System.out.println("test1");
	}
	@Test
	private void test2() {
		System.out.println("test2");
}
@Test
private void test3() {
	System.out.println("test3");
	
}
//Grouping method
	
	@Test(groups="pvr")
	private void pvr() {
		System.out.println("pvr");
	}

	@Test(groups="pvr")
	private void vr() {
		System.out.println("vr");
}
	
	@Test(groups="spi")
	private void sathyam() {
		System.out.println("sathyam");
	}
	@Test(groups="spi")
	
	private void skywalk() {
		System.out.println("skywalk");

	}
	
	@Test(groups="inox")
	private void inox() {
		System.out.println("inox");

	}	
	}