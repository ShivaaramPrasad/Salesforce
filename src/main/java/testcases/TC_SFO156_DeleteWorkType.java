package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.LoginPage;

public class TC_SFO156_DeleteWorkType extends PreAndPost{
	@BeforeTest
	public void setData() {
		testCaseName="TC_SFO155";
		testDescription="Delete WorkType";
		nodes="WorkType";
		authors = "Shivaaram";
		category="Functional";
	}
	
	@Test
	public void deleteWorkType() {
		new LoginPage(driver, test)
		.typeUserName("nupela@testleaf.com")
		.typePassword("Bootcamp$123")
		.clickLogIn()
		.clickAppLauncer()
		.clickViewAll()
		.clickOnWorkTypes()
		.clickArrowOnFirstResultRow()
		.selectDelete()
		.clickOnDelete()
		.verifyDeleteMessage("was deleted");
	}

}
