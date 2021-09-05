package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.LoginPage;

public class TC_SFO147_CreateAccount  extends PreAndPost{

	@BeforeTest
	public void setData() {
		testCaseName = "TC_SFO147";
		testDescription = "CreateAccount";
		authors = "Shivaaram";
		category = "smoke";
		nodes = "Service";
		dataSheetName="CreateAccount";
	}
		
	@Test(dataProvider="fetchData")
	public void login(String accName, String expectedName) {
		new LoginPage(driver, test)
		.typeUserName("nupela@testleaf.com")
		.typePassword("Bootcamp$123")
		.clickLogIn()
		.clickAppLauncer()
		.clickViewAll()
		.clickSales()
		.clickAccountsTab()
		.clickNewButton()
		.enterAccountName(accName)
		.selectOwnership()
		.clickSaveAccount()
		.verifyAccount(expectedName);
	}
}
