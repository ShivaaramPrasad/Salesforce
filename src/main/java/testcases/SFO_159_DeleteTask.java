package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;

public class SFO_159_DeleteTask extends PreAndPost {
	
	@BeforeTest
	public void setData() {
		testCaseName = "CreateTask";
		testDescription = "Create a new task";
		authors = "Shivaaram";
		category = "Regression";
		nodes = "Service";
		dataSheetName ="SFO_159_DeleteTask";
	}
		
	@Test(dataProvider="fetchData")	
	public void login(String uName , String pwd , String expectedText) throws InterruptedException {
		new pages.LoginPage(driver, test)
		.typeUserName(uName)
		.typePassword(pwd)
		.clickLogIn()
		.clickAppLauncer()
		.clickViewAll()
		.clickSales()
		.clickTaskTab()
		.clickonDropdown()
		.chooseRecentlyViewed()
		.clickBootcamp()
		.clickOnActionDropdown()
		.clickOnDeleteOption()
		.clickOnDelete()
		.getDeletedMessage(expectedText);
			
	}
}
