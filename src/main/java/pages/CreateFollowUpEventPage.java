package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class CreateFollowUpEventPage extends PreAndPost{
	
	public CreateFollowUpEventPage(EventFiringWebDriver driver,ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	
	public CreateFollowUpEventPage clickDeleteIconOnAssignedTo() {
		click(locateElement("xpath", "(//span[text()='Assigned To'])[2]/../following-sibling::div//descendant::span[text()='Press Delete to Remove']"));
		return this;
	}
	
	

}
