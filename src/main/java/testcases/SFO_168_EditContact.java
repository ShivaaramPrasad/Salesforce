package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.ContactsPage;
import pages.CreateContactPage;
import pages.LoginPage;

public class SFO_168_EditContact extends PreAndPost{
	private ContactsPage cp;

	@BeforeTest
	public void setData() {
		testCaseName = "TC_SFO168";
		testDescription = "EditContact";
		authors = "Shivaaram";
		category = "smoke";
		nodes = "Service";
		dataSheetName="SFO_168_EditContact";
	}
		
	@Test(dataProvider="fetchData")
	public void login(String contactName, String title, String phone) {
		cp = new ContactsPage(driver,test);
		new LoginPage(driver, test)
		.typeUserName("nupela@testleaf.com")
		.typePassword("Bootcamp$123")
		.clickLogIn()
		.clickGlobalActionsSVGIcon()
		.clickAppLauncer()
		.clickViewAll()
		.clickSales()
		.clickContactsTab();
		int initialSize = cp.initialSizeOfContacts();
		cp.searchContact(contactName)
		.clickDDOfContactName()
		.clickEditBtnFromDD()
		.enterTitleInsideEditView(title)
		.clickCalendar()
		.selectDOB()
		.enterLeadSourceInsideEditView()
		.enterPhNoInsideEditView(phone)
		.verifyPhoneNo(phone);
		
	}

}
