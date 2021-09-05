package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class CreateTaskPage extends PreAndPost{

	public CreateTaskPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	

	public CreateTaskPage typeSubject(String subjectName){
	type(locateElement("xpath" ,"//input[@class='slds-input slds-combobox__input']"), subjectName);
	return this;
	}
	
	public CreateTaskPage typeContact(String contactName){
	type(locateElement("xpath","//input[@title='Search Contacts']"), contactName);
	System.out.println("Contact is passed Successfully");
	return this;
	}
	
	public CreateTaskPage clickContact () {
    click(locateElement("xpath", "//div[@title='Sarath M']"));
    System.out.println("contact is clicked");
    return this;
   	}

	public CreateTaskPage clickStatus () {
    click(locateElement("xpath", "//a[@class='select']"));
    System.out.println("Status is clicked");
     return this;
	}
	
	public CreateTaskPage chooseStatus () {
	click(locateElement("xpath", "(//a[contains(text(),'Waiting on someone else')])[1]"));
    System.out.println("Status is selected Successfully");
	return this;
	}
	
	public CreateTaskPage clickSave () {
	click(locateElement("xpath", "(//span[contains(text(),'Save')])[3]"));
    System.out.println("Save button is clicked");
	return this;
	}
    
	
	public HomePage getSuccessMessage(String expectedText) {
	verifyExactText(locateElement("xpath" ,"//div[@class='toastContent slds-notify__content']"), expectedText);
	System.out.println("Save button is clicked");
	return new HomePage(driver, test);
	}
	
}
