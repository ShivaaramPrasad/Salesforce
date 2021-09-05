package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.LoginPage;

public class SFO172_SalesNewEventCreation extends PreAndPost{

	@BeforeTest
	public void setData() {
		testCaseName = "TC_SFO45";
		testDescription = "NewEventCreation";
		authors = "Shivaaram";
		category = "smoke";
		nodes = "Sales";
		dataSheetName="NewEvent";
	}

	@Test(dataProvider = "fetchData")
	public void createEvent(String username,String password,String event,String starttime, String endtime , String desc) {

		new LoginPage(driver, test)
		.typeUserName(username)
		.typePassword(password)
		.clickLogIn()
		.clickAppLauncer()
		.clickViewAll()
		.clickSales()
		.clickCalendar()
		.clickOnDate()
		.clickOnDay()
		.uncheckAlldayEvent()
		.clickStartTimeslot()
		.selectStartTime(starttime)
		.clickEndTimeslot()
		.selectEndTime(endtime)
		.selectSubject(event)
		.enterDesc(desc)
		.clickSaveEvent()
		.verifyMessage(event);

	}


}
