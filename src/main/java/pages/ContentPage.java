package pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class ContentPage extends PreAndPost
{	
	
	public ContentPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
		
	public ContentPage clickonTaskTab() {
	clickUsingJS("xpath", "//a[@Title='Tasks']");
	System.out.println("Task tab is clicked Successfully");
	return this;
	}

	public ContentPage clickOnDropdown() {
	click(locateElement("xpath", "//a[@title='Select List View']"));
	System.out.println("Droped is clicked Successfully");
	return this;
	}
	
	public ContentPage clickOnRecentlyViewed() {
	click(locateElement("xpath", "(//span[contains(text(),'Recently Viewed')])[3]"));
	System.out.println("Recently Viewed option is selected");
	return this;
	}
	
	public ContentPage clickOnBootcamp() {
	click(locateElement("xpath", "(//div[@class='forceRecordLayout'])[1]"));
	System.out.println("First Bootcamp task is clicked");
	return this;
	}
	
	public ContentPage clickEditDueDate() {
	click(locateElement("xpath", "//button[@title='Edit Due Date']"));	
	System.out.println("Due date is in editbale mode");
	return this;
	}
	
	
	public ContentPage clickCalendarIcon() {
	click(locateElement("xpath", "//a[@class='datePicker-openIcon display']"));
	System.out.println("Calendar is Clicked");
	return this;
	}
    
	public ContentPage setDeuDate() {
	 Date today = new Date();               
	SimpleDateFormat formattedDate = new SimpleDateFormat("MM/dd/yyyy");            
	Calendar c = Calendar.getInstance();  
	// number of days to add  
	String currentdate = (String)(formattedDate.format(c.getTime()));
	System.out.println("Current date is " + currentdate);
	click(locateElement("//input[@class='inputDate input']"));
	type(locateElement("xpath","//input[@class='inputDate input']"), currentdate);
	System.out.println("Due date is selected as today");
	return this;
	}
	
	public ContentPage clickPriorityDropDown() throws InterruptedException {
	Thread.sleep(3000);
	click(locateElement("xpath", "(//a[@class='select'])[2]"));
	System.out.println("Priority Drop down is clicked");
	return this;
	}
		
	public ContentPage clickPriorityAsLow() {
	click(locateElement("xpath", "(//a[contains(text(),'Low')])[1]"));
	System.out.println("Priority is set to low");
	return this;
	}
	
	public ContentPage clickonSaveBtn() {
	click(locateElement("xpath", "//span[contains(text(),'Save')]"));
	System.out.println("Task is edited and saved successfully");
	return this;
	}
		
	public TaskPage clickonViewAllTasks() {
		clickUsingJS("xpath", "//span[text()='View All']/parent::a[@aria-label='View All Tasks']");
		return new TaskPage(driver, test);
	}
		
	public TaskPage clickViewAllFromTodayTask() {
	click(locateElement("xpath", "(//span[contains(text(),'View All')])[2]"));
	System.out.println("View all button is clicked from Today's task section");
	return new TaskPage(driver,test);
	}
}
