package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class CreateContactPage extends PreAndPost{


	public CreateContactPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public CreateContactPage clickNewContact() {
		click(locateElement("xpath", "//span[text()='New Contact']"));
		return this;
	}
	
	public CreateContactPage selectSalutation() {
		click(locateElement("xpath", "//a[@class='select']"));
		click(locateElement("xpath", "//a[text()='Mr.']"));
		return this;
	}
	
	public CreateContactPage enterFirstName(String firstname) {
		type(locateElement("xpath", "//input[contains(@class,'firstName ')]"), firstname);
		return this;
	}
	
	public CreateContactPage enterLastName(String lastname) {
		type(locateElement("xpath", "//input[contains(@class,'lastName ')]"), lastname);
		return this;
	}
	
	public CreateContactPage enterEmail(String email) {
		type(locateElement("xpath", "//div[contains(@class,'uiInputEmail')]//input"), email);
		return this;
	}
	
	
	public CreateContactPage clickCreateNewAccountFromDD() {
		click(locateElement("xpath", "//input[contains(@class,'uiAutocomplete')]"));
		click(locateElement("xpath", "//span[text()='New Account']"));
		return this;
	}
	
	public CreateContactPage enterAccNameInPopUp(String accName) {
		type(locateElement("xpath", "(//span[text()='Account Name'])[2]/parent::label/following-sibling::input"), accName);
		return this;
	}
	
	public CreateContactPage clickSaveInNewAccPopUp() {
		click(locateElement("xpath", "//button[contains(@class,'default uiButton--brand uiButton')]/span"));
		return this;
	}
	
	public CreateContactPage clickSaveInCreateAcc() {
		sleep(10000);
		clickUsingJS("xpath","//button[contains(@class,'cuf-publisherShareButton uiButton')]/span");
		return this;
	}
	
	public CreateContactPage verifyNewContactCreated(String expectedText) {
		verifyExactText(locateElement("xpath", "//a[@class='forceActionLink']/div"), expectedText);
		return this;
	}
	
}
