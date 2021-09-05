package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.LoginPage;

public class SFO173_DeleteEvent extends PreAndPost {

	@BeforeTest
	public void setData() {
		testCaseName = "TC_SFO46";
		testDescription = "DeleteEvent";
		authors = "Shivaaram";
		category = "smoke";
		nodes = "Sales";
		dataSheetName="DeleteEvent";
	}

	@Test(dataProvider = "fetchData")
	public void deleteEvent(String uname,String pwd,String day,String type,String timeslot) {

		new LoginPage(driver,test)
		.typeUserName(uname)
		.typePassword(pwd)
		.clickLogIn()
		.clickAppLauncer()
		.clickViewAll()
		.clickSales()
		.clickCalendar()
		.selectEvent(day, type, timeslot)
		.deleteEvent()
		.verifyDeletion(day, type, timeslot);

	}
}
