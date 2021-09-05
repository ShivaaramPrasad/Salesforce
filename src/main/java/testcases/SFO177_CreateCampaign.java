package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.LoginPage;

public class SFO177_CreateCampaign extends PreAndPost{
	
	@BeforeTest
	public void setData() {
		testCaseName = "TC_SFO177";
		testDescription = "Create_Campaign";
		authors = "Shivaaram";
		category = "smoke";
		nodes = "Sales";
		dataSheetName="CampaignTC";
	}
	
	@Test(dataProvider = "fetchData")
	public void createCampaign(String uname,String pwd,String Name) {
		
		new LoginPage(driver,test)
		.typeUserName(uname)
		.typePassword(pwd)
		.clickLogIn()
		.clickAppLauncer()
		.clickViewAll()
		.clickSales()
		.clickCampaignsTab()
		.clickNewCampaign()
		.enterCampaignName(Name)
		.selectStartDate()
		.selectEndDate()
		.clickSave()
		.clickCampaignsTab()
		.verifyCampaignCreation(Name);
		
		
		
		
	}

}
