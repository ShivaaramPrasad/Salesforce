package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;

public class SFO_109_CreateCommunityContact extends PreAndPost {
	

	@BeforeTest
	public void setData() {
		testCaseName = "Create Community Contact";
		testDescription = "To Create a Community Contact";
		authors = "Shivaaram";
		category = "Regression";
		nodes = "Service";
		dataSheetName ="SFO_109_CreateCommunityContact";
	}

	@Test(dataProvider="fetchData")	
	public void login(String uName , String pwd, String ContactTitle, String ContactFirstName, String ContactLastName, String ContactPhoneNumber, String ContactEmail , String OppName, String OppAmount ) throws InterruptedException {
		new pages.LoginPage(driver, test)
		.typeUserName(uName)
		.typePassword(pwd)
		.clickLogIn()
		.clickAppLauncer()
		.clickViewAll()
		.clickSales()
		.clickContactsTab()
		.clickOnNewContact()
		.clickOnSalutaionDD()
		.chooseSalutation()
		.clickonContactSearchAccount()
		.clickContactFirstresultingSearchAccount()
		.typeContactTitle(ContactTitle)
		.typeContactFirstName(ContactFirstName)
		.typeContactLastName(ContactLastName)
		.typeContactPhone(ContactPhoneNumber)
		.typeContactEmail(ContactEmail)
		.clickContactSave()
		.clickNewUnderOpportunitiy()
		.enterOpportunityName(OppName)
		.clickOpportunitySearchAccount()
		.clickOpportunityFirstResultingSearchAccount()
		.clickOnOpportunityTypeDropDown()
		.chooseTypeasCustomer()
		.typeAmount(OppAmount)
		.clickCloseDateCalendarIcon()
		.clickNextMonth()
		.chooseDate()
		.clickOnStageDD()
		.chooseStageasProposalPriceQuote()
		.clickSave();
		
	}		
}
