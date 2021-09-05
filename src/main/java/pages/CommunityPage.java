package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class CommunityPage extends PreAndPost{

	public CommunityPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public CommunityPage clickContactOption () {
	clickUsingJS("xpath", "//span[text()='Contacts']");
	System.out.println("Contacts tab is clicked");
	 return this;
   }
	
	public CommunityPage clickOnFirstShowActionsDropdown () {
	clickUsingJS("xpath", "(//span[contains(text(),'Show Actions')])[1]");
	System.out.println("First resulting Show Actions Drop down icon is clicked");
	return this;
   }
	
	public CommunityPage clickOnEditOption () {
	clickUsingJS("xpath", "//div[contains(text(),'Edit')]");
	System.out.println("Edit option is selected");
	return this;
   }
	
	public CommunityPage clickBirthCalendarIcon () {
	clickUsingJS("xpath", "//a[@class='datePicker-openIcon display']");
	System.out.println("Birthdate Calendar icon is clicked");
	return this;
   }
	
	public CommunityPage clickPreviousMonth() {
	clickUsingJS("xpath", "//a[@class='navLink prevMonth']");
	System.out.println("Previous button is clicked");
	return this;
   }	
	
	public CommunityPage chooseDate() {
	clickUsingJS("xpath", "//span[text()='24']");
	System.out.println("Date 24 is clicked");
	return this;
   }	
		
	public CommunityPage ClickOnSaveButton() {
	clickUsingJS("xpath", "(//span[text()='Save'])[2]");
	System.out.println("Contact is edited and saved successfully");
	return this;
   }	
	
	public CommunityPage geteditedSuccessMessage() {
	String text = getText(locateElement("xpath" ,"//span[contains(@class,'toastMessage slds-text-heading--small')]"));
	System.out.println(text);
	return this;
	}
}
