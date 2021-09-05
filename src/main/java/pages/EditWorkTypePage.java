package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class EditWorkTypePage extends PreAndPost{

	public EditWorkTypePage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}

	public EditWorkTypePage enterTimeFrameStart(String timeFrameStart) {
		type(locateElement("xpath", "//span[text()='Timeframe Start']/../following-sibling::input"), timeFrameStart);
		return this;
	}

	public EditWorkTypePage enterTimeFrameEnd(String timeFrameEnd) {
		type(locateElement("xpath", "//span[text()='Timeframe End']/../following-sibling::input"), timeFrameEnd);
		return this;
	}

	public WorkTypePage clickOnSave() {
		click(locateElement("xpath", "//div[@data-aura-class='forceRecordEditActions']//descendant::button[@title='Save']"));
		return new WorkTypePage(driver, test);
	}

	public EditWorkTypePage timeFrameStartAlertVerification(String frameStartAlert) {

		verifyExactText(locateElement("xpath", "//li[contains(text(),'.: Timeframe Start')]"), frameStartAlert);
		return this;

	}

	public EditWorkTypePage timeFrameEndAlertVerification(String frameEndAlert) {

		verifyExactText(locateElement("xpath", "//li[contains(text(),'.: Timeframe End')]"), frameEndAlert);
		return this;

	}

}
