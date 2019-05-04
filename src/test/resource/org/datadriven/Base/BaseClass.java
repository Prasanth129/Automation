package org.datadriven.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.functions.Value;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.xml.stream.ElementFilter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	static WebDriver driver;
	static WebDriverWait wait;
	public static WebDriver launchBrowser(String browserName) throws Exception {
		try {
			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\drivers\\chromedriver.exe");
				driver=new ChromeDriver();	
			}else if (browserName.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "\\drivers\\chromedriver.exe");
				driver=new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	public static String getUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	public static boolean isDisplayed(WebElement element ) throws Exception {
		
		try {
			boolean displayed = element.isDisplayed();
			return displayed;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}	}
	public static boolean isEnabled(WebElement element) throws Exception {
		try {
			boolean enabled = element.isEnabled();
			return enabled;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}}
	public static void waitForVisibilityOfElements(WebElement element) throws Exception {
		try {
			WebDriverWait wb=new WebDriverWait(driver, 30);
			wb.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}	}
	public static boolean isSelected(WebElement element) throws Exception {
		try {
			waitForVisibilityOfElements(element);
			boolean selected = element.isSelected();
			return selected;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}	}
	public static boolean elementToBeVisible(WebDriver driver,int time,WebElement element) {
		boolean flag= false;
		try {
			wait=new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOf(element));
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}
	
	public static void elementClear(WebElement element) throws Exception {
		try {
			waitForVisibilityOfElements(element);
			element.clear();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}	}
	public static void inputValueMethod(WebElement element, String value) throws Exception {
		try {
			if (isDisplayed(element) && isEnabled(element)) {
				waitForVisibilityOfElements(element);
				elementClear(element);
				element.sendKeys(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}}
	public static void elementClick(WebElement element) throws Exception {
		
		try {
			waitForVisibilityOfElements(element);
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Element not clickable"+ element);	
			}	}
	public static String getText(WebElement element) throws Exception {
		String name=null;
		if (isDisplayed(element)) {
			name=element.getAttribute("Value");
		}
		return name;
	}
	public static void setText(WebElement element,String name) throws Exception {
		if (name!=null&&isDisplayed(element)) {
			element.clear();
			element.sendKeys(name);
			
		}
	
	}
	
}
		
