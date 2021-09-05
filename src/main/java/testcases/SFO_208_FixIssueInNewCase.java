package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;

public class SFO_208_FixIssueInNewCase  extends PreAndPost {
	

	@BeforeTest
	public void setData() {
		testCaseName = "Fix Issue in Case";
		testDescription = "To Fix the issues in new case";
		authors = "Shivaaram";
		category = "Regression";
		nodes = "Service";
		dataSheetName ="SFO_208_FixIssueInNewCase";
	}

	
	@Test(dataProvider="fetchData")	
	public void login(String uName , String pwd, String opportunityName) throws InterruptedException {
		new pages.LoginPage(driver, test)
		.typeUserName(uName)
		.typePassword(pwd)
		.clickLogIn()
		.clickGlobalActionsSVGIcon()
		.clickNewOpportunity()
		.clickOnExpandIcon()
		.typeOpportunityName(opportunityName)
		.clickOnStageDropDown()
		.chooseProspect()
		.clickOpportunitySave();
}
}