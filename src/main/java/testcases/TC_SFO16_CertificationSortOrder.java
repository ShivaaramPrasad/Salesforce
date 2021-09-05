package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.LoginPage;

public class TC_SFO16_CertificationSortOrder  extends PreAndPost{

	@BeforeTest
	public void setData() {
		testCaseName = "TC_SFO16";
		testDescription = "CertificationSortOrder";
		authors = "Shivaaram";
		category = "smoke";
		nodes = "Service";
		dataSheetName="SFO16";
	}
		
	@Test(dataProvider="fetchData")
	public void login(String elementText) throws InterruptedException {
		new LoginPage(driver, test)
		.typeUserName("nupela@testleaf.com")
		.typePassword("Bootcamp$123")
		.clickLogIn()
		.findAndClickElementInScrollBarOpenInNewWindow(elementText)
		.clickGetStarted()
		.clickTrustHome()
		.clickTrustCompliance()
		.clickSortByPopularity()
		.clickSortAlphabetically()
		.verifyCertifications();
		
		
	}
}
