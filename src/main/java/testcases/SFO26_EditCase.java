package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.AppLauncherPage;
import pages.CasesPage;
import pages.EditCasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.SalesPage;

public class SFO26_EditCase extends PreAndPost{
	
	@BeforeTest
	public void setData() {
		testCaseName = "TC002";
		testDescription = "Login Page";
		authors = "Shivaaram";
		category = "smoke";
		nodes = "editField";
	}
		
	@Test
	public void login() throws InterruptedException {
		new LoginPage(driver, test)
		.typeUserName("nupela@testleaf.com")
		.typePassword("Bootcamp$123")
		.clickLogIn()
		.clickAppLauncer().clickViewAll()
		.clickSales()
		.clickMore().clickCases()
		.clickonyourName().clickEdit().clickSave().verify();
}}