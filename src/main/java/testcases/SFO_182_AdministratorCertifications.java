package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.LoginPage;

public class SFO_182_AdministratorCertifications extends PreAndPost {
	@BeforeTest
	public void setData() {
		testCaseName = "SFO_182_AdministratorCertifications";
		testDescription = "AdministratorCertifications";
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
		.certAvailableAdmin();
		
	}

}
