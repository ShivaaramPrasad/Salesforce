package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;

public class SFO_186_NewChart  extends PreAndPost {
	

	@BeforeTest
	public void setData() {
		testCaseName = "NewChart";
		testDescription = "To Create a new chart and print the chart values";
		authors = "Shivaaram";
		category = "Regression";
		nodes = "Service";
		dataSheetName ="SFO_186_NewChart";
	}


	@Test(dataProvider="fetchData")	
	public void login(String uName , String pwd, String ChartName) throws InterruptedException {
		new pages.LoginPage(driver, test)
		.typeUserName(uName)
		.typePassword(pwd)
		.clickLogIn()
		.clickAppLauncer()
		.clickViewAll()
		.clickonContentApp()
		.clickViewAllFromTodayTask()
		.clickListViewDropDown()
		.chooseUnscheduleTask()
		.chooseDisplayasSplitView()
		.chooseOptionasTable()
		.clickOnShowChartIcon()
		.clickNewChart()
		.typeChartName(ChartName)
		.clickOnChartTypeDropDown()
		.chooseDonutChart()
		.clickOnAggregateDropDown()
		.chooseAggegrateAsPriority()
		.clickOnGroupingDropDown()
		.chooseGropuingAsStatus()
		.clickSaveChart();
	}
		
}
