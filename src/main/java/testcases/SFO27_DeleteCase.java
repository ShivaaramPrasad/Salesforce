package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.LoginPage;

public class SFO27_DeleteCase  extends PreAndPost{
	
	@BeforeTest
	public void setData() {
		testCaseName = "DeleteCase";
		testDescription = "Testing on DeletCase";
		authors = "Shivaaram";
		category = "smoke";
		nodes = "DeleteField";
	}
		
	@Test
	public void login() throws InterruptedException {
		new LoginPage(driver, test)
		.typeUserName("nupela@testleaf.com")
		.typePassword("Bootcamp$123")
		.clickLogIn()
		.clickAppLauncer().clickViewAll()
		.clickSales()
		.clickMore().clickCases().clickonName().clickDelete().confirmDelete().verficationOnDeleteCase();
}

}
