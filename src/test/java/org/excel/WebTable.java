package org.excel;

import java.util.List;

import org.apache.commons.math3.geometry.spherical.oned.ArcsSet.Split;
import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {
	public static WebDriver driver;
	
	public static void launchBrowser() throws Exception {
		String property = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", property+"\\drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static void getAllData() {
		driver.get("https://www.toolsqa.com/automation-practice-table/");
		WebElement table = driver.findElement(By.tagName("table"));
		
		List<WebElement> trow =driver.findElements(By.tagName("tr"));
		for (int i = 0; i < trow.size(); i++) {
		
			
			List<WebElement> tdata =trow.get(i).findElements(By.tagName("td"));
		
			for (int j = 0; j < tdata.size(); j++) {
			String text = tdata.get(j).getText();
			System.out.println(text);
		}
		}}
	public static void getAllHeaderDatas() {
		driver.get("https://www.toolsqa.com/automation-practice-table/");
		WebElement table = driver.findElement(By.tagName("table"));
		List<WebElement> trow = driver.findElements(By.tagName("tr"));
		for (int i = 0; i < trow.size(); i++) {
			
			List<WebElement> tdata = trow.get(i).findElements(By.tagName("th"));
			
			for (int j = 0; j < tdata.size(); j++) {
				String text = tdata.get(j).getText();
				System.out.println(text);
			}
		}
	}
	public static void innerText() {
		driver.get("https://www.toolsqa.com/automation-practice-table/");
		String innertext = driver.findElement(By.xpath("//table/tbody/tr[3]")).getText();
		System.out.println(innertext);
		driver.quit();
	}
	
public static void main(String[] args) throws Exception {
	launchBrowser();
	//getAllData();
	//getAllHeaderDatas();
	innerText();
}
}
