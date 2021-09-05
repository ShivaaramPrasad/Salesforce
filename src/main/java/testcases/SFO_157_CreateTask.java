package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import lib.selenium.PreAndPost;


public class SFO_157_CreateTask extends PreAndPost{
	
	@BeforeTest
	public void setData() {
		testCaseName = "CreateTask";
		testDescription = "Create a new task";
		authors = "Shivaaram";
		category = "Regression";
		nodes = "Service";
		dataSheetName ="SFO_157_CreateTask";
	}
		
	@Test(dataProvider="fetchData")	
	public void login(String uName , String pwd , String subjectName, String contactName, String exepectedText) throws InterruptedException {
		new pages.LoginPage(driver, test)
		.typeUserName(uName)
		.typePassword(pwd)
		.clickLogIn()
		.clickGlobalActionsSVGIcon()
		.clickNewTask()
		.typeSubject(subjectName)
		.typeContact(contactName)
		.clickStatus()
		.chooseStatus()
		.clickSave()
		.getSuccessMessage(exepectedText);
		
	}
	

}
