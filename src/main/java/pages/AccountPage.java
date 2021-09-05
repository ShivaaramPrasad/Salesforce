package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class AccountPage extends PreAndPost {
	
	public String Acc_name;
	
	public AccountPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
		public AccountPage clickNewButton() {
			click(locateElement("xpath", "//div[text()='New']"));
			return this;

		}

		public AccountPage enterAccountName(String accName) {
			type(locateElement("xpath", "(//span[text()='Account Name'])[2]/parent::label/following-sibling::input"), accName);
			return this;
		}
		public AccountPage selectOwnership() {
			click(locateElement("xpath", "//span[text()='Ownership']/following::a"));
			click(locateElement("xpath", "//a[text()='Public']"));
			return this;
		}
		public AccountPage clickSaveAccount() {
			click(locateElement("xpath", "(//span[text()='Save'])[2]"));
			return this;
		}
		public AccountPage verifyAccount(String expectedName) {
			sleep(4000);
			
			String createText = getText(locateElement("xpath","//span[text()='Account']"));
			System.out.println(createText);
			if (createText.contains(expectedName)) {
				System.out.println("Account is Created successfully");
			}else {
				System.out.println("Account is not Created ");
			}
			
			return this;
		}
		
		public AccountPage searchAccountName(String accName) throws InterruptedException {
			String keyvalue = "ENTER";
			typeUsingKeys(locateElement("xpath","//span[text()='Accounts']/following::input[@name='Account-search-input']"),accName,keyvalue);
			sleep(4000);

			return this;
		}
		
		public AccountPage selectDeleteFromDropdown() throws InterruptedException {
			//webDriverWait("presence", "xapath", "//a[contains(@class,'slds-truncate outputLookupLink')]");
			click(locateElement("xpath", "//a[contains(@class,'slds-button slds-button--icon-x-small')]"));
			click(locateElement("xpath", "//a[@title='Delete']"));
			click(locateElement("xpath", "//span[text()='Delete']"));
			System.out.println("Acccount is deleted successfully");
			sleep(4000);

			return this;
		}
		
		public AccountPage verifyDeleteAccount(String expectedName) throws InterruptedException {
			
			String deleteText = getText(locateElement("xpath","//a[contains(@class,'slds-truncate outputLookupLink')]"));
			System.out.println(deleteText);
			if (deleteText.contains(expectedName)) {
				System.out.println("Account is still avaible");
			}else {
				System.out.println("Account is not shown");
			}
			
			return this;

		}
	
		public AccountPage retrieveAccountName() {
			Acc_name = getAttribute(locateElement("xpath","//span[text()='Phone']//preceding::input[1]"),"value");
			System.out.println(Acc_name);
			return this;
		}

		public AccountPage selectRating() {
			click(locateElement("xpath","(//span[text()='Rating']//following::div[@class='uiMenu'])[1]"));
			click(locateElement("xpath","//a[@title='Warm']"));
			return this;
		}

		public AccountPage enterPhoneNumber(String phonenumber) {
			type(locateElement("xpath","(//span[text()='Phone']//following::input[@class=' input'])[1]"),phonenumber);
			return this;
		}

		public AccountPage enterAccountNumber(String accnumber) {
			type(locateElement("xpath","(//span[text()='Account Number']//following::input[@class=' input'])[1]"),accnumber);
			return this;
		}

		public AccountPage selectType() {
			scrollToElementUsingJS("xpath","(//span[text()='Type']//following::a[text()='--None--'])[5]");
			clickUsingJS("xpath","(//span[text()='Type']//following::a[text()='--None--'])[5]");
			scrollToElementUsingJS("xpath","//a[@title='Technology Partner']");
			clickUsingJS("xpath","//a[@title='Technology Partner']");
			return this;
		}

		public AccountPage selectIndustry() {
			click(locateElement("xpath","(//span[text()='Industry']//following::a[text()='--None--'])[1]"));
			click(locateElement("xpath","//a[@title='Technology']"));
			return this;
		}

		public AccountPage selectCustomerPriority() {
			scrollToElementUsingJS("xpath","(//span[text()='Customer Priority']//following::a[text()='--None--'])[1]");
			clickUsingJS("xpath","(//span[text()='Customer Priority']//following::a[text()='--None--'])[1]");
			click(locateElement("xpath","//a[@title='High']"));
			return this;
		}

		public AccountPage selectSLA() {
			click(locateElement("xpath","(//span[text()='SLA']//following::a[text()='--None--'])[1]"));
			click(locateElement("xpath","//a[@title='Gold']"));
			return this;
		}
		
		public AccountPage selectActive() {
			click(locateElement("xpath","(//span[text()='Active']//following::a[text()='--None--'])[1]"));
			click(locateElement("xpath","//a[@title='Yes']"));
			return this;
		}
		
		public AccountPage enterAccountDesc(String Accdesc) {
			scrollToElementUsingJS("xpath","//h2[text()='New Account']//following::span[text()='Description']//following::textarea");
			clickUsingJS("xpath","//h2[text()='New Account']//following::span[text()='Description']//following::textarea");
			type(locateElement("xpath","//h2[text()='New Account']//following::span[text()='Description']//following::textarea"),Accdesc);
			return this;
		}
		
		public AccountPage clickSaveandNew() {
			click(locateElement("xpath","//h2[text()='New Account']//following::button[@title='Save & New']"));
			return this;
		}
		
		public OpportunitiesPage clickCancel(){
			sleep(2000);
			click(locateElement("xpath","//h2[text()='New Account']//following::button[@title='Cancel']"));
			return new OpportunitiesPage(driver,test);
		}

	}
