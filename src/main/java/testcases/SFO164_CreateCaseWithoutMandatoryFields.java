package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.LoginPage;

public class SFO164_CreateCaseWithoutMandatoryFields extends PreAndPost{
	
	@BeforeTest
	public void setData() {
		testCaseName = "CreateCaseWithoutMandatoryFields";
		testDescription = "CreateCaseWithoutMandatoryFields and to verify error message";
		authors = "Shivaaram";
		category = "smoke";
		nodes = "CreateCaseWithoutMandatoryField";
	}
		
	@Test
	public void login() throws InterruptedException {
		new LoginPage(driver, test)
		.typeUserName("nupela@testleaf.com")
		.typePassword("Bootcamp$123")
		.clickLogIn()
		.clickAppLauncer().clickViewAll()
		.clickSales()
		.clickMore().clickCases().clicknew().selectContactName().selectStatusNone().enterSubjTesting("testing").enterDescrTesting("dummy")
		.ClickSave().errorMsgVerfication();
	
	}

}
