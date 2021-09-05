package pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class CalendarPage extends PreAndPost{

	public CalendarPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}


	public String selectDate() {
		//get current date and time
		Calendar cal = Calendar.getInstance();
		Date tday = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");//change format as required
		String select_date= formatter.format(tday);
		return select_date;
	}

	public CalendarPage clickOnDate() {
		sleep(3000);
		String sdate = selectDate();
		String date_xpath = "//td[@data-datevalue='"+sdate+"']";
		click(locateElement("xpath",date_xpath));
		return this;
	}

	public EventPage clickOnDay() {
		Calendar cal = Calendar.getInstance();
		Date tday = cal.getTime();
		SimpleDateFormat formatter_a = new SimpleDateFormat("EEE d");//TO get date as SUN 1
		String eDate = formatter_a.format(tday);
		System.out.println(eDate.toUpperCase());
		String xDate = "//strong[text() = '"+eDate.toUpperCase()+"']";
		click(locateElement("xpath",xDate));
		return new EventPage(driver,test);
	}

	public CalendarPage verifyMessage(String event) {
		String eventsub = driver.findElement(By.xpath("//a[@class='subject-link']")).getText();
		if(eventsub.equals(event))
			System.out.println("Event Created Successfully:"+ eventsub );
		else
			System.out.println("Event Creation is not successful" );
		return this;
	}

	public CalendarPage selectEvent(String day,String type,String timeslot) {
		String event_xpath = "//strong[text()='"+day+"']/following::a[text() = '"+type+"']/following::span[contains(text(),'"+timeslot+"')]";
		List<WebElement> email_events = locateElements("xpath",event_xpath);
		if(email_events.isEmpty())
			System.out.println("No Email Event available." );
		else {
			WebElement eventElement = locateElement("xpath",event_xpath);
			Actions action = new Actions(driver);
			action. moveToElement(eventElement).perform();
		}
		return this;
	}
	
	public CalendarPage deleteEvent() {
		click(locateElement("xpath","//a[@title='Delete']"));
		sleep(2000);
		click(locateElement("xpath","//span[text()='Delete']"));
		return this;
	}
	
	public CalendarPage verifyDeletion(String day,String type,String timeslot) {
		String event_xpath = "//strong[text()='"+day+"']/following::a[text() = '"+type+"']/following::span[contains(text(),'"+timeslot+"')]";
		List<WebElement> events = locateElements("xpath",event_xpath);
		if(events.isEmpty())
			System.out.println("Event deleted successfully." );
		else
			System.out.println("Event is not deleted successfully." );
		return this;
	}
	
	public ContactsPage selectDOB() {
		clickOnDate();
		return new ContactsPage(driver,test);
	}

}