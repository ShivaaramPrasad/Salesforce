package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.LoginPage;

public class TC_SFO13_VerifyApp_Store  extends PreAndPost{

	@BeforeTest
	public void setData() {
		testCaseName = "TC_SFO137";
		testDescription = "Verify App Store";
		authors = "Shivaaram";
		category = "smoke";
		nodes = "Service";
		dataSheetName="SFO137";
	}
		
	@Test(dataProvider="fetchData")
	public void login(String elementText) throws InterruptedException {
		new LoginPage(driver, test)
		.typeUserName("nupela@testleaf.com")
		.typePassword("Bootcamp$123")
		.clickLogIn()
		.findAndClickElementInScrollBarOpenInNewWindow(elementText)
		.clickAppStore()
		.getTheLinkDisplayed()
		.clickTheLinkDisplayed()
		.verifyTheLinkDisplayed();
		
	}
}
