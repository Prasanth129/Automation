package org.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Element;

public class BaseClass {
	public static WebDriver driver;
	
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
	public static void selectDropDown(WebElement element, String options, String values) {
		Select sc=new Select(element);
		if (options.equals("values")) {
			sc.selectByValue(values);
		}else if (options.equals("index")) {
			sc.selectByIndex(Integer.parseInt(values));
		}else if (options.equals("visibilityOfText")) {
			sc.selectByVisibleText(values);
		}
	}


}

