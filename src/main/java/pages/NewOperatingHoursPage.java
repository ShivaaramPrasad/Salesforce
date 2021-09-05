package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class NewOperatingHoursPage extends PreAndPost{
	
	public NewOperatingHoursPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	
	public NewOperatingHoursPage clickCreateOperatingHour() {
		click(locateElement("xpath", "//span[contains(text(),'New Operating Hours')]"));
		return this;
	}
	
	public NewOperatingHoursPage enterNewOperatingHourName(String hourName) {
		type(locateElement("xpath", "//span[starts-with(text(),'Name')]//parent::label//following-sibling::input"), hourName);
		return this;
	}
	
	public NewOperatingHoursPage clickTimeZone() {
		click(locateElement("xpath", "//div[@class='uiPopupTrigger']//descendant::a[contains(text(),'Pacific')]"));
		return this;
	}
	
	public NewOperatingHoursPage selectTimeZone() {
		clickUsingJS("xpath", "//a[@title='(GMT+00:00) Greenwich Mean Time (GMT)']");
		return this;		
	}
	
	public NewWorkTypePage clickOnSave() {
		click(locateElement("xpath", "//div[@class='modal-footer slds-modal__footer']//child::div//child::button[@title='Save']"));
		return new NewWorkTypePage(driver, test);
	}

}
