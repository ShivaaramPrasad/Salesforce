package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.LoginPage;

public class TC_SFO141_CreateNewOpportunity extends PreAndPost {

	@BeforeTest
	public void setData() {
		testCaseName = "TC_SFO141";
		testDescription = "Create New Opportunity";
		authors = "Shivaaram";
		category = "smoke";
		nodes = "Sales";
		dataSheetName="Salesforce_CreateOpp";
	}

	@Test(dataProvider = "fetchData")
	public void login(String Username , String Password ,String OppName , String todDate) {
		new LoginPage(driver, test)
		.typeUserName(Username)
		.typePassword(Password)
		.clickLogIn()
		.clickAppLauncer()
		.clickViewAll()
		.clickSales()
		.clickOpportunitiesTab()
		.clickTheNewButton()
		.enterOpportunityName(OppName) 
		.chooseDateAsToday(todDate)
		.selectStage()
		.clickSave()
		.verifyErrorMessage();

	}

}

