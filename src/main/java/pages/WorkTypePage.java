package pages;



import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class WorkTypePage extends PreAndPost{
	
	public WorkTypePage(EventFiringWebDriver driver,ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	
	public NewWorkTypePage clickOnNew() {
		click(locateElement("xpath", "//div[contains(text(),'New')]"));
		return new NewWorkTypePage(driver, test);
	}
	
	public WorkTypePage clickArrowOnFirstResultRow() {
		click(locateElement("xpath", "//tbody/tr/td[5]"));
		return this;
	}
	
	public EditWorkTypePage clickOnEdit() {
		click(locateElement("xpath", "//a[@title='Edit']"));
		return new EditWorkTypePage(driver, test);
	}
	
	public WorkTypePage verifyEditMessage(String verifyText) {
		verifyPartialText(locateElement("xpath", "//button[@title='Close']/preceding-sibling::div//child::span"), verifyText);
		return this;
	}
	
	public WorkTypePage selectDelete() {
		click(locateElement("xpath", "//a[@title='Delete']"));
		return this;
	}
	
	public WorkTypePage clickOnDelete() {
		click(locateElement("xpath", "//h2[text()='Delete Work Type']/../..//span[text()='Delete']"));
		return this;
	}
	
	public WorkTypePage verifyDeleteMessage(String deleteMessage) {
		verifyPartialText(locateElement("xpath", "//button[@title='Close']/preceding-sibling::div//child::span"), deleteMessage);
		return this;
	}

}
