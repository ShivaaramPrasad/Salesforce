
package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class SalesPage extends PreAndPost{

	public SalesPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public CalendarPage clickCalendar() {
		clickUsingJS("xpath","(//span[text()='Calendar'])");
		return new CalendarPage(driver, test);
	}

	public CampaignsPage clickCampaignsTab() {
		clickUsingJS("xpath","//a[@title='Campaigns']");
		return new CampaignsPage(driver, test);
	}

	public AccountPage clickAccountsTab() {
		clickUsingJS("xpath","//a[@title='Accounts']");
		return new AccountPage(driver, test);
	}

	public ContactsPage clickContactsTab() {
		clickUsingJS("xpath","//a[@title='Contacts']");
		return new ContactsPage(driver, test);
	}

	public DashboardPage clickDashboardTab() {
		clickUsingJS("xpath","//a[@title='Contacts']");
		return new DashboardPage(driver, test);
	}

	public OpportunitiesPage clickOpportunitiesTab() {
		clickUsingJS("xpath","//a[@title='Contacts']");
		return new OpportunitiesPage(driver, test);
	}
	
	public TaskPage clickTaskTab() {
	clickUsingJS("xpath","//a[@title='Tasks']");
	return new TaskPage(driver, test);
	}
		
	public SalesPage clickTaskDropDown() {
	click(locateElement("xpath","(//*[@data-key='chevrondown'])[2]"));
	return this;	
		
	}
	
	public SalesPage clickOnNewTask() {
	clickUsingJS("xpath","//span[contains(text(),'New Task')]");
	return this;
	}
	
	public SalesPage typeTaskComment(String taskComment){
	type(locateElement("xpath","//textarea[@role='textbox']"), taskComment);
	System.out.println("Comment is Typed successfully");
	return this;
	}
	

	public SalesPage clickOnSaveTask() {
	click(locateElement("xpath","//button[@title='Save']"));
	return this;
	}
	
	public SalesPage getTaskErrorMessage(String expectedText) {
	verifyExactText(locateElement("xpath" ,"//ul[@class='errorsList']"), expectedText);
	System.out.println("Error message is captured");
	return this;
	}
	public SalesPage clickMore() {
		sleep(10000);
		click(locateElement("xpath", "//span[text()='More']"));
		return this;
	}
	public CasesPage clickCases() {
		sleep(5000);
				clickUsingJS("xpath","(//span[text()='Cases'])[2]");
				return new CasesPage(driver, test);
	}
	

}