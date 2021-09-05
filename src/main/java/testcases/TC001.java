package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import lib.selenium.PreAndPost;
import pages.LoginPage;

public class TC001 extends PreAndPost{
	
	@BeforeTest
	public void setData() {
		testCaseName = "TC001";
		testDescription = "Login Page";
		authors = "sarath";
		category = "smoke";
		nodes = "Service";
	}
		
	@Test
	public void login() {
		new LoginPage(driver, test)
		.typeUserName("makaia@testleaf.com")
		.typePassword("Bootcamp$123")
		.clickLogIn()
		.clickAppLauncer()
		.clickViewAll()
		.clickService();
		
	}
	

}
