package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.ContactsPage;
import pages.LoginPage;

public class TC_SFO169_DeleteContact  extends PreAndPost{

	@BeforeTest
	public void setData() {
		testCaseName = "TC_SFO169";
		testDescription = "DeleteContact";
		authors = "Shivaaram";
		category = "smoke";
		nodes = "Service";
		dataSheetName="SFO_169_DeleteContact";
	}
		
	@Test(dataProvider="fetchData")
	public void login(String contactName,String expectedText, String condition) {
		ContactsPage cp = new ContactsPage(driver,test);
		new LoginPage(driver, test)
		.typeUserName("nupela@testleaf.com")
		.typePassword("Bootcamp$123")
		.clickLogIn()
		.clickGlobalActionsSVGIcon()
		.clickAppLauncer()
		.clickViewAll()
		.clickContacts();
		int initialSize = cp.initialSizeOfContacts();
		cp.searchContact(contactName)
		.storeContactName()
		.clickDDOfContactName()
		.clickDeleteBtnFromDD()
		.verifyToastMessage(expectedText)
		.verifyContactDeleted(initialSize, condition);		
	}
}
