package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class ServicePage extends PreAndPost{
	
	public ServicePage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public ServicePage clickService() {
		click(locateElement("link", "Service"));
		return this;
	}
	
	
}
