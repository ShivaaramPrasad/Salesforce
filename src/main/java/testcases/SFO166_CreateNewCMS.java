package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.LoginPage;



public class SFO166_CreateNewCMS extends PreAndPost {
	
	@BeforeTest
	public void setData() {
		testCaseName = "TC_SFO166";
		testDescription = "CreateNewCMS";
		authors = "Shivaaram";
		category = "smoke";
		nodes = "CMSHome";
		dataSheetName="CreateCMSTC";
	}
	
	@Test(dataProvider = "fetchData")
	public void createCMSAccount(String uname,String pwd,String Name,String VName) throws Exception{
		
	
			new LoginPage(driver,test)
			.typeUserName(uname)
			.typePassword(pwd)
			.clickLogIn()
			.clickAppLauncer()
			.clickViewAll()
			.collapseAll()
			.clickCMSHome()
			.clickCreateCMS()
			.enterName(Name)
			.clickNext()
			.clickOnCreateChannel()
			.enterChannelName(VName)
			.selectConnectionType()
			.clickCreateChannel()
			.verifyChannelMessage()
			.selectChannel(VName)
			.clickNext()
			.selectContributors()
			.clickNext()
			.selectFirstUserContibutor()
			.selectSecondUserContibutor()
			.clickNext()
			.selectDefaultLanguage()
			.clickNext()
			.clickDone()
			.verifyCMSMessage();
		
	}

}
