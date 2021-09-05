package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class NewWorkTypePage extends PreAndPost{
	
	public NewWorkTypePage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	
	public NewWorkTypePage enterWorkTypeName(String wtName) {
		type(locateElement("xpath", "//span[contains(text(),'Work Type Name')]//parent::label//following-sibling::input"), wtName);
		return this;
	}
	
	public NewWorkTypePage enterDescription(String desc) {
		type(locateElement("tagname", "textarea"), desc);
		return this;
	}
	
	public NewOperatingHoursPage searchOperatingHours() {
		clickUsingJS("xpath", "//input[@title='Search Operating Hours']");
		return new NewOperatingHoursPage(driver, test);
	}
	
	public NewWorkTypePage enterEstimatedDuration(String durationHours) {
		type(locateElement("xpath", "//span[starts-with(text(),'Estimated Duration')]//parent::label//following-sibling::input"), durationHours);
		return this;
	}
	
	public WorkTypeViewPage clickOnSave() {
		click(locateElement("xpath", "//button[@title='Save']/span[starts-with(text(),'Save')]"));
		return new WorkTypeViewPage(driver, test);
	}
	
	public NewWorkTypePage verifyMandatoryField(String validationMessage) {
		verifyExactText(locateElement("xpath", "//span[starts-with(text(),'Estimated Duration')]//parent::label//following-sibling::input/../following-sibling::ul/li"), validationMessage);
		return this;
	}

}
