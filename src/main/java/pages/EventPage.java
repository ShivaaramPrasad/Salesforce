package pages;

import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class EventPage extends PreAndPost{

	public EventPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	Calendar cal = Calendar.getInstance();
	Date tday = cal.getTime();
	
	public EventPage uncheckAlldayEvent() {
		click(locateElement("xpath","//span[text() = 'All-Day Event']"));
		return this;
	}

	public EventPage clickStartTimeslot() {
		click(locateElement("xpath","(//input[@class='slds-input slds-combobox__input'])[3]"));
		return this;
	}

	public EventPage selectStartTime(String starttime) {
		String from_xpath = "//span[@title='"+ starttime+"']";
		WebElement start_time = locateElement("xpath",from_xpath);
		//To scroll and select 10 AM
		scrollToElementUsingJS("xpath",from_xpath);
		clickUsingJS("xpath",from_xpath);
		return this;
	}

	public EventPage clickEndTimeslot() {
		click(locateElement("xpath","(//label[text()='Time'])[2]//following::div/input"));
		return this;
	}

	public EventPage selectEndTime(String endtime) {
		String to_xpath = "(//span[@title='"+ endtime+"'])[2]";
		WebElement to_time = locateElement("xpath",to_xpath);
		scrollToElementUsingJS("xpath",to_xpath);
		clickUsingJS("xpath",to_xpath);
		return this;
	}

	public EventPage selectSubject(String event) {
		type(locateElement("xpath","(//input[@class='slds-input slds-combobox__input'])[2]"),event);
		return this;
	}

	public EventPage enterDesc(String desc) {
		type(locateElement("tagname","textarea"),desc);
		return this;
	}

	public CalendarPage clickSaveEvent() {
		click(locateElement("xpath","//button[@title = 'Save']"));
		return new CalendarPage(driver,test);
	}

}
