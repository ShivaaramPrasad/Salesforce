package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.LoginPage;

public class TC_SFO154_EditWorkType extends PreAndPost{
	
	@BeforeTest
	public void setData() {
		testCaseName = "TC_SFO154";
		testDescription = "EditWorkType";
		authors = "Shivaaram";
		category = "Functional";
		nodes = "WorkType";
		dataSheetName="EditWorkType";
	}
	
	@Test(dataProvider = "fetchData")
	public void editWorkType(String TimeFrameStart,String TimeFrameEnd,String EditVerifyText) {
		
		new LoginPage(driver, test)
		.typeUserName("nupela@testleaf.com")
		.typePassword("Bootcamp$123")
		.clickLogIn()
		.clickAppLauncer()
		.clickViewAll()
		.clickOnWorkTypes()
		.clickArrowOnFirstResultRow()
		.clickOnEdit()
		.enterTimeFrameStart(TimeFrameStart)
		.enterTimeFrameEnd(TimeFrameEnd)
		.clickOnSave()
		.verifyEditMessage(EditVerifyText);
	}

}
