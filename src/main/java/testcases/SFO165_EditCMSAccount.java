package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.LoginPage;

public class SFO165_EditCMSAccount extends PreAndPost {
	
	
	@BeforeTest
	public void setData() {
		testCaseName = "TC_SFO165";
		testDescription = "EditCMS";
		authors = "Shivaaram";
		category = "smoke";
		nodes = "CMSHome";
		dataSheetName="UpdateCMS";
	}
	
	@Test(dataProvider = "fetchData")
	public void editCMSAccount(String uname,String pwd,String Name) {
		
		new LoginPage(driver,test)
		.typeUserName(uname)
		.typePassword(pwd)
		.clickLogIn()
		.clickAppLauncer()
		.clickViewAll()
		.collapseAll()
		.clickCMSHome()
		.selectCMSRecord()
		.clickEdit()
		.updateCMSName(Name)
		.clickUpdate()
		.verifyEditCMSMessage();
		
	}

}
