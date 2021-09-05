package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.LoginPage;

public class TC_SFO35_CreateNewWorkType extends PreAndPost{

	@BeforeTest
	public void setData() {
		testCaseName = "TC_SFO35";
		testDescription = "CreateNewWorkType";
		authors = "Shivaaram";
		category = "Functional";
		nodes = "WorkType";
		dataSheetName="CreateNewWorkType";
	}
	
	@Test(dataProvider = "fetchData")
	public void createNewWorkType(String WorkTypeName, String Description, String NewOperatingHours, String EstimatedDuration) {
		new LoginPage(driver, test)
		.typeUserName("nupela@testleaf.com")
		.typePassword("Bootcamp$123")
		.clickLogIn()
		.clickAppLauncer()
		.clickViewAll()
		.clickOnWorkTypes()
		.clickOnNew()
		.enterWorkTypeName(WorkTypeName)
		.enterDescription(Description)
		.searchOperatingHours()
		.clickCreateOperatingHour()
		.enterNewOperatingHourName(NewOperatingHours)
		.clickTimeZone()
		.selectTimeZone()
		.clickOnSave()
		.enterEstimatedDuration(EstimatedDuration)
		.clickOnSave()
		.verifyWorkTypeCreatedMessage(Description);
	}
	
}
