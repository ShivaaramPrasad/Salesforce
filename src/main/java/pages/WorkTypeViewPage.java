package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class WorkTypeViewPage extends PreAndPost{
	public WorkTypeViewPage(EventFiringWebDriver driver,ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	
	public WorkTypeViewPage verifyWorkTypeCreatedMessage(String expText) {
		verifyExactText(locateElement("xpath", "//span[starts-with(text(),'Specimen')]"), expText);
		return this;
	}
}
