package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class LoginPage extends PreAndPost{
	
	public LoginPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public LoginPage typeUserName(String uName) {
		type(locateElement("username"), uName);
		return this;
	}
	
	public LoginPage typePassword(String pwd) {
		type(locateElement("password"), pwd);
		return this;
	}
	
	public HomePage clickLogIn() {
		click(locateElement("Login"));
		return new HomePage(driver, test);
	}

}
