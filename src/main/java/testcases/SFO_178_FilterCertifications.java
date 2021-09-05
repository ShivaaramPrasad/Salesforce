package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.ContactsPage;
import pages.LoginPage;

public class SFO_178_FilterCertifications extends PreAndPost {

	@BeforeTest
	public void setData() {
		testCaseName = "TC_SFO178";
		testDescription = "FilterCertifications";
		authors = "Shivaaram";
		category = "smoke";
		nodes = "Service";
		dataSheetName="SFO_178_FilterCertifications";
	}
		
	@Test(dataProvider="fetchData")
	public void filterCertifications(String expectedSize) {
		ContactsPage cp = new ContactsPage(driver,test);
		new LoginPage(driver, test)
		.typeUserName("nupela@testleaf.com")
		.typePassword("Bootcamp$123")
		.clickLogIn()
		.clickSliderUntilSystemStatus()
		.getStartedSystemStatus()
		.switchToSalesForceTrustWindow()
		.selectTrustFromDD()
		.clickShowFilters()
		.selectNonProfit()
		.verifyOnly20AreDisplayed(expectedSize);	
	}
}
