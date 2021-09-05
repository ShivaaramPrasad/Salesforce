package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class ContactsPage extends PreAndPost{

	public ContactsPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public ContactsPage clickOnNewContact() {
		click(locateElement("xpath", "//div[contains(text(),'New')]"));
		System.out.println("New contact option is selected");	
		return this;
	}

	public ContactsPage clickOnSalutaionDD() {
		click(locateElement("xpath", "(//a[@class='select'])[1]"));
		System.out.println("Salutation dropdown is clicked");	
		return this;
	}
	
	public ContactsPage chooseSalutation() {
		click(locateElement("xpath", "//a[@title='Mr.']"));
		System.out.println("Salutation is selected as MR");	
		return this;
	}
	public ContactsPage clickonContactSearchAccount() {
		click(locateElement("xpath", "//input[@title='Search Accounts']"));
		System.out.println("Search account filed is clicked");	
		return this;
	}
	
	public ContactsPage clickContactFirstresultingSearchAccount() {
		click(locateElement("xpath", "(//ul[@class='lookup__list  visible']/li/a/div/span/img)[1]"));
		System.out.println("First resulting account is selected");	
		return this;
	}

	public ContactsPage typeContactTitle(String ContactTitle) {
		type(locateElement("xpath", "//span[contains(text(),'Title')]/parent::label/following-sibling::input"),ContactTitle);
		System.out.println("Title is typed as Business Analyst");	
		return this;
	}
	public ContactsPage typeContactFirstName(String ContactFirstName) {
		type(locateElement("xpath", "//span[contains(text(),'First Name')]/parent::label/following-sibling::input"),ContactFirstName);
		System.out.println("contact firstname is typed as jamie");	
		return this;
	}
	
	public ContactsPage typeContactLastName(String ContactLastName) {
		type(locateElement("xpath", "//span[contains(text(),'Last Name')]/parent::label/following-sibling::input"),ContactLastName);
		System.out.println("contact lsatName is typed as fox");	
		return this;
	}
	public ContactsPage typeContactPhone(String ContactPhoneNumber) {
		type(locateElement("xpath", "//span[contains(text(),'Phone')]/parent::label/following-sibling::input"),ContactPhoneNumber);
		System.out.println("Phone Number is Typed");	
		return this;
	}
	
	public ContactsPage typeContactEmail(String ContactEmail) {
		type(locateElement("xpath", "//span[contains(text(),'Email')]/parent::label/following-sibling::input"),ContactEmail);
		System.out.println("Email is Typed");	
		return this;
	}
	public ContactsPage clickContactSave() {
		click(locateElement("xpath", "(//span[contains(text(),'Save')])[3]"));
		System.out.println("contact is saved successfully");	
		return this;
	}	
	
	public NewOpportunityPage clickNewUnderOpportunitiy() {
		clickUsingJS("xpath", "(//div[@title='New'])[2]");
		System.out.println("New button is clicked under Opportunity");	
		return new NewOpportunityPage(driver, test);
	}


	
	public int initialSizeOfContacts() {
		webDriverWait("visibility", "xpath", "//table[contains(@class,'slds-table forceRecordLayout ')]/tbody/tr");
		int size = getTableRowSize(locateElement("xpath","//span[@class='countSortedByFilteredBy']"), "//table[contains(@class,'slds-table forceRecordLayout ')]/tbody/tr");
		return size;
	}
	
	public ContactsPage searchContact(String contactName) {
		pageReload();
		webDriverWait("visibility", "xpath", "//input[@name='Contact-search-input']");
		type(locateElement("xpath", "//input[@name='Contact-search-input']"),contactName);
		click(locateElement("xpath", "//div[@title='List View Controls']/button"));
		
		return this;
	}
	
	public ContactsPage storeContactName() {
		webDriverWait("invisibility", "xpath", "//div[@class='slds-spinner_container slds-grid']");
		String contactName = getText(locateElement("xpath","(//table[contains(@class,'slds-table forceRecordLayout ')]/tbody/tr/th//a)[2]"));
			
		return this;
	}
	
	public ContactsPage clickDDOfContactName() {
		webDriverWait("stalenessRefreshed", "xpath","(//tr[2]/td)[last()]//lightning-primitive-icon");
		click(locateElement("xpath", "(//tr[2]/td)[last()]//lightning-primitive-icon"));
	
		return this;
	}
	
	public ContactsPage clickDeleteBtnFromDD() {
		webDriverWait("clickable", "xpath","//a[@title='Delete']");
		click(locateElement("xpath", "//a[@title='Delete']"));
		click(locateElement("xpath", "//button[contains(@class,'brand uiButton forceActionButton')]/span"));
	
		return this;
	}
	
	public ContactsPage clickEditBtnFromDD() {
		webDriverWait("clickable", "xpath","//a[@title='Edit']");
		click(locateElement("xpath", "//a[@title='Edit']"));
		return this;
	}
	
	public ContactsPage verifyToastMessage(String expectedText) {
		sleep(5000);
		verifyExactText(locateElement("xpath","//span[contains(@class,'small forceActionsText')]"), expectedText);
		return this;
	}
	
	public ContactsPage verifyContactDeleted(int initialSize, String condition) {
		sleep(10000);
		scrollDown();
		int currentSize = sizeOfWebElements(locateElements("xpath", "//table[contains(@class,'slds-table forceRecordLayout ')]/tbody/tr"));
		compareWebElementsSize(condition,initialSize, currentSize);
		
		return this;
	}
	
	public ContactsPage enterTitleInsideEditView(String title) {
		type(locateElement("xpath", "//span[contains(text(),'Title')]/parent::label/following-sibling::input"),title);
			
		return this;
	}
	
	public CalendarPage clickCalendar() {
		click(locateElement("xpath", "//div[@class='form-element']/input"));
			
		return new CalendarPage(driver,test);
	}
	
	public ContactsPage enterLeadSourceInsideEditView() {
		click(locateElement("xpath", "//span[text()='Lead Source']/../following-sibling::div//a[@class='select']"));
		click(locateElement("xpath", "//a[@title='Purchased List']"));
			
		return this;
	}
	
	public ContactsPage enterPhNoInsideEditView(String phone) {
		type(locateElement("xpath", "(//div[contains(@class,'uiInput uiInputPhone uiInput')])[1]/input"),phone);
		click(locateElement("xpath", "//button[@title='Save']"));
		
		return this;
	}
	
	public ContactsPage verifyPhoneNo(String phone) {
		webDriverWait("visibility", "xpath", "(//tbody//span[@class='slds-truncate uiOutputPhone'])[1]");
		String actualPhone = getText(locateElement("xpath", "(//tbody//span[@class='slds-truncate uiOutputPhone'])[1]"));
		actualPhone = actualPhone.replaceAll("\\D", "");
		compareTwoString(actualPhone, phone);
		
		return this;
	}
	
	
	
}
