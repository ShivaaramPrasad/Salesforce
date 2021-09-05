package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import lib.selenium.PreAndPost;
import pages.HomePage;
import pages.LoginPage;
import pages.newCasePage;

public class TC001_NewCase extends PreAndPost{
	
	@BeforeTest
	public void setData() {
		testCaseName = "TC001";
		testDescription = "Login Page";
		authors = "Shivaaram";
		category = "smoke";
		nodes = "newcasefield";
	}
		
	@Test
	public void login() throws InterruptedException {
		new LoginPage(driver, test)
		.typeUserName("nupela@testleaf.com")
		.typePassword("Bootcamp$123")
		.clickLogIn()
	    .clickGlobalActionsSVGIcon()
		.clickNewCase().selectContactName().selectEscalated().enterSubTesting("testing").clickSave().verficationOnNewCaseCreated();
		
	
	}
	

}
