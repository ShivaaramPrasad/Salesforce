package testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;

public class SFO_201_IssuesInContact extends PreAndPost {
	

	@BeforeTest
	public void setData() {
		testCaseName = "FixBugInEditContact";
		testDescription = "To fix issues in the edit contact test case";
		authors = "Shivaaram";
		category = "Regression";
		nodes = "Service";
		dataSheetName ="SFO_201_FixIssuesInContact";
	}
	
	
	@Test(dataProvider="fetchData")	
	public void login(String uName , String pwd) throws InterruptedException {
		new pages.LoginPage(driver, test)
		.typeUserName(uName)
		.typePassword(pwd)
		.clickLogIn()
		.clickAppLauncer()
		.clickViewAll()
		.clickonCommunityApp()	
		.clickContactOption()
		.clickOnFirstShowActionsDropdown()
		.clickOnEditOption()
		.clickBirthCalendarIcon()
		.clickPreviousMonth()
		.chooseDate()
		.ClickOnSaveButton()
		.geteditedSuccessMessage();
	}	
				
		
}
