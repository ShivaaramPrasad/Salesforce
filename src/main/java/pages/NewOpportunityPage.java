package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class NewOpportunityPage extends PreAndPost {
	public NewOpportunityPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public NewOpportunityPage enterOpportunityName(String OppName) {
		type(locateElement("xpath", "//span[text()='Opportunity Name']/parent::label/following::input[1]"),OppName);
		return this;
	}

	public NewOpportunityPage chooseDateAsToday(String todDate) {
		type(locateElement("xpath", "(//span[text()='Close Date'])[2]/parent::label/following::div/child::input"),todDate);
		return this;
	}

	public NewOpportunityPage selectStage() {
		click(locateElement("xpath", "//a[text()='--None--']"));
		click(locateElement("xpath", "//a[text()='Needs Analysis']"));
		return this;
	}

	public NewOpportunityPage clickSave() {
		click(locateElement("xpath", "(//span[text()='Save'])[2]"));	
		return this;
	}

	public NewOpportunityPage verifyErrorMessage() {
		String text = getText(locateElement("Xpath","(//span[text()='Opportunity']"));
		System.out.println(text);
		if(text.contains("Salesforce")) {
			System.out.println("Success");
		}else
		{
			System.out.println("Failure");
		}
		return this;
	}
	
	public NewOpportunityPage clickOpportunitySearchAccount() {
		click(locateElement("xpath", "//span[@class='deleteIcon']"));	
		click(locateElement("xpath", "//input[@title='Search Accounts']"));	
		System.out.println("Opportunity Search account filed is clicked");
		return this;
	}
    
	public NewOpportunityPage clickOpportunityFirstResultingSearchAccount() throws InterruptedException {
	    Thread.sleep(2000);
		click(locateElement("xpath", "(//ul[@class='lookup__list  visible']/li/a/div/span/img)[1]"));	
		System.out.println("Opportunity First resulting account is selected");
		return this;
	}
		
	public NewOpportunityPage clickOnOpportunityTypeDropDown() {
	   	click(locateElement("xpath", "//span[contains(text(),'Type')]/parent::span/following-sibling::div"));	
		System.out.println("Opportunity Type dropdown is clicked");
		return this;
	}

	public NewOpportunityPage chooseTypeasCustomer() {
	   	click(locateElement("xpath", "//a[@title='New Customer']"));	
		System.out.println("Type is choosen as new customer");
		return this;
	}
 	
	public NewOpportunityPage typeAmount(String OppAmount) {
	   	type(locateElement("xpath", "//span[contains(text(),'Amount')]/parent::label/following-sibling::input"),OppAmount);	
		System.out.println("Amount is typed as 350000");
		return this;
	}
	
	public NewOpportunityPage clickCloseDateCalendarIcon() throws InterruptedException {
		Thread.sleep(3000);
	   	click(locateElement("xpath", "//a[@class='datePicker-openIcon display']"));	
		System.out.println("Close date Calendar icon is clicked");
		return this;
	}
	
	public NewOpportunityPage clickNextMonth() {
	   	click(locateElement("xpath", "//a[@class='navLink nextMonth']"));	
		System.out.println("Next button is clicked");
		return this;
	}
  
	public NewOpportunityPage chooseDate() {
	   	click(locateElement("xpath", "//span[text()='15']"));	
		System.out.println("Date 15 is clicked");
		return this;
	}
			
	public NewOpportunityPage clickOnStageDD() {
	   	click(locateElement("xpath", "//span[contains(text(),'Stage')]/parent::span/following-sibling::div"));	
		System.out.println("Stage dropdown is clicked");
		return this;
	}
	
	public NewOpportunityPage chooseStageasProposalPriceQuote() {
	   	click(locateElement("xpath", "//a[@title='Proposal/Price Quote']"));	
		System.out.println("Stage is choosen as proposal price quote");
		return this;
	}
	
	public NewOpportunityPage maxOppPage() throws InterruptedException {
		sleep(2000);
		click(locateElement("xpath","//button[@title='Maximize']"));
		return this;
	}
	
	public NewOpportunityPage enterOppName() {
		locateElement("xpath","(//label[@data-aura-class='uiLabel']/span[text()='Opportunity Name']/following::input)[1]").sendKeys("Test");
		return this;
	}
	
	public NewOpportunityPage selectStages() {
		click(locateElement("xpath","//a[@class='select']"));
		click(locateElement("xpath","//a[text()='Prospecting']"));
		return this;
	}
	
	public NewOpportunityPage saveOpp() {
		click(locateElement("xpath","(//span[text()='Save'])[2]"));
		return this;
	}
	
}
