package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.CreateContactPage;
import pages.LoginPage;

public class TC_SFO167_CreateContact  extends PreAndPost{
	
	private CreateContactPage ccp;
	@BeforeTest
	public void setData() {
		testCaseName = "TC_SFO167";
		testDescription = "CreateContact";
		authors = "Shivaaram";
		category = "smoke";
		nodes = "Service";
		dataSheetName="SalesForceTestData";
	}
		
	@Test(dataProvider="fetchData")
	public void login(String firstname, String lastname, String email, String accName, String expectedName) {
		ccp= new CreateContactPage(driver,test); 	
		new LoginPage(driver, test)
		.typeUserName("nupela@testleaf.com")
		.typePassword("Bootcamp$123")
		.clickLogIn()
		.clickGlobalActionsSVGIcon();
		ccp.clickNewContact()
		.selectSalutation()
		.enterFirstName(firstname)
		.enterLastName(lastname)
		.enterEmail(email)
		.clickCreateNewAccountFromDD()
		.enterAccNameInPopUp(accName)
		.clickSaveInNewAccPopUp()
		.clickSaveInCreateAcc()
		.verifyNewContactCreated(expectedName);
		
		
	}
}
