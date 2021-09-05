package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;

public class SFO_160_CreateTaskWithoutMandatoryFields extends PreAndPost {

	@BeforeTest
	public void setData() {
		testCaseName = "CreateTaskWithoutMandatoryFields";
		testDescription = "To Create an Task without Mandatory fields and capture the message";
		authors = "Shivaaram";
		category = "Regression";
		nodes = "Service";
		dataSheetName ="SFO_160_CreateTaskWithoutMandatoryFields";
	}
	

	@Test(dataProvider="fetchData")	
	public void login(String uName , String pwd, String taskComment, String expectedText ) throws InterruptedException {
		new pages.LoginPage(driver, test)
		.typeUserName(uName)
		.typePassword(pwd)
		.clickLogIn()
		.clickAppLauncer()
		.clickViewAll()
		.clickSales()
		.clickTaskDropDown()
		.clickOnNewTask()
		.typeTaskComment(taskComment)
		.clickOnSaveTask()
		.getTaskErrorMessage(expectedText);
	
	}
}
