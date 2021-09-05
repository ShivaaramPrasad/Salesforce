package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.LoginPage;

public class SFO_12_BoardExamSchedule extends PreAndPost {

	@BeforeTest
	public void setData() {
		testCaseName = "SFO_12_BoardExamSchedule";
		testDescription = "BoardExamSchedule";
		authors = "Shivaaram";
		category = "smoke";
		nodes = "Service";
	}
		
	@Test
	public void login() throws InterruptedException {
		new LoginPage(driver, test)
		.typeUserName("nupela@testleaf.com")
		.typePassword("Bootcamp$123")
		.clickLogIn()
		.clickLearnMore()
		.navigateToCustomerServicePage()
		.supportAndService()
		.clickOnCertificationsLink()
		.navigateToCertificationWindow()
		.selectSaleforceArchitect()
		.moreDetailslinkTechnicalArchitCert()
		.navigateArchitectReviewBoardwindow()
		.verifyLocationandDates();
		
	}
}
