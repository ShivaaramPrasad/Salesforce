package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.LoginPage;

public class SFO_179_GooglePlayStore extends PreAndPost{


	@BeforeTest
	public void setData() {
		testCaseName = "GooglePlayStore";
		testDescription = "Testing on googleplaystorepage";
		authors = "Shivaaram";
		category = "smoke";
		nodes = "GooglePlayStore";
		dataSheetName="SFO_179_GooglePlayStore";
	}
		
	@Test(dataProvider = "fetchData")
	public void login(String expectedString) throws InterruptedException {
		new LoginPage(driver, test)
		.typeUserName("nupela@testleaf.com")
		.typePassword("Bootcamp$123")
		.clickLogIn()
		.clickSliderUntilDownloadSalesForceA()
		.clickGooglePlayLinkSalesForceA()
		.verifyInstallBtnForSalesForce(expectedString);
		
}

}

