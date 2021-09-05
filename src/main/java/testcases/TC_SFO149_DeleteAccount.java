package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.AccountPage;
import pages.LoginPage;

public class TC_SFO149_DeleteAccount  extends PreAndPost{

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
	public void login(String accName, String expectedName) throws InterruptedException {
		new LoginPage(driver, test)
		.typeUserName("nupela@testleaf.com")
		.typePassword("Bootcamp$123")
		.clickLogIn()
		.clickAppLauncer()
		.clickViewAll()
		.clickSales()
		.clickAccountsTab()
		.searchAccountName(accName)
		.selectDeleteFromDropdown()
		.verifyDeleteAccount(expectedName);
		}
}
