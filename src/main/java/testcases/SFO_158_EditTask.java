package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;

public class SFO_158_EditTask extends PreAndPost {
	

	@BeforeTest
	public void setData() {
		testCaseName = "DeleteTask";
		testDescription = "Delete an Existing Task";
		authors = "Shivaaram";
		category = "Regression";
		nodes = "Service";
		dataSheetName ="SFO_189_EditTask";
	}

	@Test(dataProvider="fetchData")	
	public void login(String uName , String pwd) throws InterruptedException {
		new pages.LoginPage(driver, test)
		.typeUserName(uName)
		.typePassword(pwd)
		.clickLogIn()
		.clickAppLauncer()
		.clickViewAll()
		.clickonContentApp()
		.clickonTaskTab()
		.clickOnDropdown()
		.clickOnRecentlyViewed()
		.clickOnBootcamp()
		.clickEditDueDate()
		.clickCalendarIcon()
		.setDeuDate()
		.clickPriorityDropDown()
		.clickPriorityAsLow()
		.clickonSaveBtn();
	
		
	}
}

