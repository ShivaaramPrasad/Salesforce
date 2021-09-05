package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class TaskPage extends PreAndPost{

	public TaskPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public TaskPage clickonDropdown() {
		click(locateElement("xpath","//a[@title='Select List View']"));
		return this;
	}

	public TaskPage chooseRecentlyViewed() {
		click(locateElement("xpath","(//span[contains(text(),'Recently Viewed')])[3]"));
		System.out.println("Recently Viewed option is selected");
		return this;
	}

	public TaskPage clickBootcamp() {
		click(locateElement("xpath","(//div[@class='forceRecordLayout'])[1]"));
		System.out.println("First Bootcamp task is clicked");
		return this;
	}	

	public TaskPage clickOnActionDropdown() {
		click(locateElement("xpath","//a[@title='Show 13 more actions']"));
		System.out.println("Action Dropdown is clicked");
		return this;
	}

	public TaskPage clickOnDeleteOption() throws InterruptedException {
		Thread.sleep(3000);
		clickUsingJS("xpath","//div[@class='branding-actions actionMenu']//div[contains(text(),'Delete')]");
		System.out.println("Deleted option is clicked Successfully");	 
		return this;
	}

	public TaskPage clickOnDelete() {
		click(locateElement("xpath","//span[contains(text(),'Delete')]"));
		System.out.println("Delete button is clicked");
		return this;
	}		   

	public TaskPage getDeletedMessage(String expectedText) {
		verifyExactText(locateElement("xpath" ,"//div[@class='toastContent slds-notify__content']"), expectedText);
		System.out.println("Save button is clicked");
		return this;
		}
		    
	public TaskPage clickViewType() {
		click(locateElement("xpath", "//button[@title='Display as Split View']"));
		return this;
		
	}
	
	public TaskPage selectTableView() {
		click(locateElement("xpath", "//span[text()='Display as']/..//following-sibling::li//child::span[text()='Table']/.."));
		return this;
	}
	
	public TaskPage clickFirstResultDropdown() {
		click(locateElement("xpath", "(//span[text()='Show Actions'])[1]/ancestor::a\""));
		return this;
	}
	
	public CreateFollowUpEventPage selectCreateFollowupEvent() {
		click(locateElement("xpath", "//a[@title='Create Follow-Up Event']"));
		return new CreateFollowUpEventPage(driver, test);
	}
		
	public TaskPage clickListViewDropDown() throws InterruptedException {
		Thread.sleep(2000);
		click(locateElement("xpath", "//a[@title='Select List View']"));
		System.out.println("ListView Drodpown is clicked Successfully");
		return this;
	}

	public TaskPage chooseUnscheduleTask() throws InterruptedException {
		Thread.sleep(3000);
		click(locateElement("xpath", "(//span[contains(text(),'Unscheduled Tasks')])[1]"));
		System.out.println("Unscheduled tasks option is selected");
		return this;
	}

	public TaskPage chooseDisplayasSplitView()  {
		click(locateElement("xpath", "//button[@title='Display as Split View']"));
		System.out.println("Display as Split view icon is clicked");
		return this;
	}

	public TaskPage chooseOptionasTable() {
		clickUsingJS("xpath", "//span[contains(text(),'Table')]");
		System.out.println("Table option is clicked");
		return this;
	}

	public TaskPage clickOnShowChartIcon() {
		clickUsingJS("xpath", "//span[contains(text(),'Show charts')]");
		System.out.println("Show chart icon is clickedd");
		return this;
	}

	public NewChartPage clickNewChart()  {
	click(locateElement("xpath", "//span[contains(text(),'New Chart')]"));
	System.out.println("New chart button is clicked");
	return new NewChartPage (driver, test);
	}
}
