package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class GooglePlayStorePage extends PreAndPost{

	public GooglePlayStorePage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public GooglePlayStorePage verifyInstallBtnForSalesForce(String expectedString) {
		String actualText = getText(locateElement("xpath", "//h1[@class='AHFaub']"));
		verifyIfEnabled(locateElement("xpath", "//h1[@class='AHFaub']"));
		
		return this;		
	}
}
