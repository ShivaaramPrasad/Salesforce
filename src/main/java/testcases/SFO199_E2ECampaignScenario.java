package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.LoginPage;

public class SFO199_E2ECampaignScenario extends PreAndPost {
	
	@BeforeTest
	public void setData() {
		testCaseName = "TC_SFO199";
		testDescription = "E2E_Campaign";
		authors = "Shivaaram";
		category = "Regression";
		nodes = "Sales";
		dataSheetName="E2ECampaign";
	}

	@Test(dataProvider="fetchData")
	public void EndToEndCampaignScenario(
	String username, String pwd,String campaignName,String account_name,String Opportunity,String phonenumber,String accnumber,
	String Accdesc,String NextStep,String compname,String OppDesc,String updateamt) throws Exception{
	
	new LoginPage(driver, test)
	.typeUserName(username)
	.typePassword(pwd)
	.clickLogIn()
	.clickAppLauncer()
	.clickViewAll()
	.clickSales()
	.clickCampaignsTab()
	.clickNewCampaign()
	.enterCampaignName(campaignName)
	.selectStartDate()
	.selectEndDate()
	.clickSaveCampaign()
	.verifyNewCampaignCreated()
	.createNewOpportunity()
	.clickAccountField()
	.clickNewAccount()
	.enterAccountName(account_name)
	.selectRating()
	.enterPhoneNumber(phonenumber)
	.enterAccountNumber(accnumber)
	.selectType()
	.selectIndustry()
	.selectOwnership()
	.selectCustomerPriority()
	.selectSLA()
	.selectActive()
	.enterAccountDesc(Accdesc)
	.clickSaveandNew() 
	.clickCancel()
	.enterAmount()
	.enterOppName(Opportunity)
	.retrieveOppName()
	.openCloseDatePicker()
	.selectCloseDate()
	.enterNextStep(NextStep)
	.searchandSelectAccountName(account_name)
	.selectOppType()
	.selectStage()
	.selectLeadSource()
	.selectDeliveryStatus()
	.enterCompetitorName(compname)
	.enterOppDesc(OppDesc)
	.clickSaveOpp()
	.verifyOppCreated(Opportunity)
	.navigateToActionKey(Opportunity)
	.selectEditOpp()
	.updateType()
	.updateCloseDate()
	.updateStage()
	.updateDeliveryStatus()
	.clickUpdateOpp()
	.navigateToActionKey(Opportunity)
	.navigateToActionKey(Opportunity)
	.selectDeleteOpp()
	.verifyOpportunity(Opportunity);
	}
}
