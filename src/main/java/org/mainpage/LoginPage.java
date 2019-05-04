package org.mainpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	@FindBy(id="u_0_j")
	private WebElement FirstName;
	@FindBy(id="u_0_l")
	private WebElement SurName;
	@FindBy(id="u_0_o")
	private WebElement MobileNumber;
	
	public LoginPage(WebDriver ldriver) {
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getFirstName() {
	return FirstName;
}
	public WebElement getSurName() {
		return SurName;
	}
	public WebElement getMobileNumber() {
		return MobileNumber;
	}

}
