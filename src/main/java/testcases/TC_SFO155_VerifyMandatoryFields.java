package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.LoginPage;
import pages.NewWorkTypePage;

public class TC_SFO155_VerifyMandatoryFields extends PreAndPost{
	
	@BeforeTest
	public void setData() {
		testCaseName="TC_SFO155";
		testDescription="Verify Mandatory Fields for Create WorkType";
		nodes="WorkType";
		authors = "Shivaaram";
		category="Functional";
		dataSheetName="TC_SFO155_VerifyMandatoryFields";
	}
	
	@Test(dataProvider = "fetchData")
	public void verifymandatoryfields(String WorkTypeName, String ValidationMessage) {
		new LoginPage(driver, test)
		.typeUserName("nupela@testleaf.com")
		.typePassword("Bootcamp$123")
		.clickLogIn()
		.clickAppLauncer()
		.clickViewAll()
		.clickOnWorkTypes()
		.clickOnNew()
		.enterWorkTypeName(WorkTypeName)
		.clickOnSave();
		new NewWorkTypePage(driver, test)
		.verifyMandatoryField(ValidationMessage);
	}

}
