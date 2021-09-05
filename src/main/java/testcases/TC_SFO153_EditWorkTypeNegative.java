package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.EditWorkTypePage;
import pages.LoginPage;

public class TC_SFO153_EditWorkTypeNegative extends PreAndPost{
	
	@BeforeTest
	public void setData() {
		testCaseName = "TC_SFO153";
		testDescription = "EditWorkTypeNegative";
		authors = "Srikanth";
		category = "Functional";
		nodes = "WorkType";
		dataSheetName="EditWorkTypeNegative";
	}
	@Test(dataProvider = "fetchData")
	public void editWorkTypeNegative(String TimeFrameStart,String TimeFrameEnd, String TimeFrameStartAlert, String TimeFrameEndAlert) {
		new LoginPage(driver, test)
		.typeUserName("nupela@testleaf.com")
		.typePassword("Bootcamp$123")
		.clickLogIn()
		.clickAppLauncer()
		.clickViewAll()
		.clickOnWorkTypes()
		.clickArrowOnFirstResultRow()
		.clickOnEdit()
		.enterTimeFrameEnd(TimeFrameStart)
		.enterTimeFrameEnd(TimeFrameEnd)
		.clickOnSave();
		new EditWorkTypePage(driver, test)
		.timeFrameStartAlertVerification(TimeFrameStartAlert)
		.timeFrameEndAlertVerification(TimeFrameEndAlert);
		
	}

}
