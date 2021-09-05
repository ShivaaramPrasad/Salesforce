package pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class OpportunitiesPage extends PreAndPost {

	public String Opp_name;
	public String amtvalue;

	public OpportunitiesPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public NewOpportunityPage clickTheNewButton() {
		click(locateElement("xpath", "//div[text()='New']"));
		return new NewOpportunityPage(driver, test);
	}

	public OpportunitiesPage clickOnExpandIcon() throws InterruptedException {
		Thread.sleep(5000);
		click(locateElement("xpath", "//*[@data-key='expand_alt']"));
		System.out.println("Expand Option is Clicked");
		return this;
	}

	public OpportunitiesPage typeOpportunityName(String opportunityName)  {
		type(locateElement("xpath", "(//input[@class=' input'])[1]"), opportunityName);
		System.out.println("OpportunityName is typed");
		return this;
	}

	public OpportunitiesPage clickOnStageDropDown() {
		click(locateElement("xpath", "//span[text()='Stage']/../following-sibling::div"));
		System.out.println("Stage Dropdown option is clicked");
		return this;
	}		

	public OpportunitiesPage chooseProspect() {
		click(locateElement("xpath", "//a[@title='Prospecting']"));
		System.out.println("Prospecting is selected");
		return this;
	}			

	public OpportunitiesPage clickOpportunitySave() {
		click(locateElement("xpath", "(//span[text()='Save'])[2]"));
		System.out.println("Opportunity is Saved Successfully");
		return this;
	}	

	public CampaignsPage clickSaveOpp() {
		driver.findElement(By.xpath("//h2[text()='New Opportunity']//following::button[@title='Save']")).click();
		return new CampaignsPage(driver, test);
	}

	public OpportunitiesPage retrieveOppName() {
		Opp_name = getAttribute(locateElement("xpath","(//span[text()='Opportunity Name']//following::input)[1]"),"value");
		System.out.println(Opp_name);
		return this;
	}

	public String selectDate(int numofdays) {
		Calendar calvalue = Calendar.getInstance();
		calvalue.add(Calendar.DAY_OF_YEAR,numofdays);
		Date tmrw = calvalue.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");//change format as required
		String sdate= formatter.format(tmrw);
		System.out.println(sdate);
		return sdate;
	}

	public OpportunitiesPage openCloseDatePicker(){
		click(locateElement("xpath","//a[@class='datePicker-openIcon display']"));
		return this;

	}

	public OpportunitiesPage selectCloseDate() {
		String closedate = selectDate(2);
		String closedate_xpath = "//td[@data-datevalue='"+closedate+"']";
		click(locateElement("xpath",closedate_xpath));
		return this;
	}

	public OpportunitiesPage enterAmount() {
		typeUsingKeys(locateElement("xpath","(//span[text()='Amount']//following::input)[1]"),"100000000","ENTER");
		return this;
	}

	public OpportunitiesPage clickAccountField() {
		click(locateElement("xpath","//input[@title='Search Accounts']"));
		return this;
	}
	
	public AccountPage clickNewAccount() {
		click(locateElement("xpath","//span[text()='New Account']"));
		System.out.println(driver.findElement(By.xpath("//h2[text()='New Account']")).isDisplayed());
		return new AccountPage(driver,test);
	}

	public OpportunitiesPage enterNextStep(String NextStep) {
		type(locateElement("xpath","(//span[text()='Next Step']//following::input)[1]"),NextStep);
		return this;
	}

	public OpportunitiesPage searchandSelectAccountName(String Acc_name) {
		click(locateElement("xpath","(//a[@class='deleteAction'])[1]"));
		type(locateElement("xpath","//input[@title='Search Accounts']"),Acc_name);
		String acc_xpath = "//mark[text()='"+Acc_name+"']";
		click(locateElement("xpath",acc_xpath));
		return this;
	}

	public OpportunitiesPage selectOppType() {
		click(locateElement("xpath","(//span[text()='Type']//following::a[text()='--None--'])[2]"));
		click(locateElement("xpath","//a[@title='New Customer']"));
		return this;
	}

	public OpportunitiesPage selectStage() {
		click(locateElement("xpath","(//span[text()='Stage']//following::a[text()='--None--'])[1]"));
		click(locateElement("xpath","//a[@title='Qualification']"));
		return this;
	}

	public OpportunitiesPage selectLeadSource() {
		click(locateElement("xpath","(//span[text()='Lead Source']//following::a[text()='--None--'])[1]"));
		click(locateElement("xpath","//a[@title='Web']"));
		return this;
	}

	public OpportunitiesPage enterProbability() {
		driver.findElement(By.xpath("(//span[text()='Probability (%)']//following::input)[1]")).sendKeys(Keys.CONTROL,Keys.chord("a"));
		driver.findElement(By.xpath("(//span[text()='Probability (%)']//following::input)[1]")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("(//span[text()='Probability (%)']//following::input)[1]")).sendKeys("100");
		return this;
	}

	public OpportunitiesPage selectDeliveryStatus() {
		scrollToElementUsingJS("xpath","(//span[text()='Delivery/Installation Status']//following::a)[1]");
		clickUsingJS("xpath","(//span[text()='Delivery/Installation Status']//following::a)[1]");
		click(locateElement("xpath","//a[@title='In progress']"));
		return this;
	}

	public OpportunitiesPage enterCompetitorName(String compname) {
		type(locateElement("xpath","(//span[text()='Main Competitor(s)']//following::input)[1]"),compname);
		return this;
	}

	public OpportunitiesPage enterOppDesc(String OppDesc) {
		type(locateElement("xpath","(//span[text()='Description']//following::textarea)[1]"),OppDesc);
		return this;
	}

	public OpportunitiesPage updateType() {
		click(locateElement("xpath","//span[text()='Type']//following::a[text()='New Customer']"));
		click(locateElement("xpath","//a[@title='Existing Customer - Upgrade']"));
		return this;

	}

	public OpportunitiesPage updateCloseDate() {
		String update_closedate = selectDate(1);
		String update_closedate_xpath = "//td[@data-datevalue='"+update_closedate+"']";
		click(locateElement("xpath","//a[@class='datePicker-openIcon display']"));
		click(locateElement("xpath",update_closedate_xpath));
		return this;
	}

	public OpportunitiesPage updateAmount(String amtvalue){
		sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Amount']//following::input)[1]")).sendKeys(Keys.CONTROL,Keys.chord("a"));
		driver.findElement(By.xpath("(//span[text()='Amount']//following::input)[1]")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("(//span[text()='Amount']//following::input)[1]")).sendKeys(amtvalue,Keys.ENTER);
		return this;
	}

	public OpportunitiesPage updateStage(){
		click(locateElement("xpath","//span[text()='Stage']//following::a[text()='Qualification']"));
		scrollToElementUsingJS("xpath", "//a[@title='Closed Won']");
		clickUsingJS("xpath", "//a[@title='Closed Won']");
		sleep(5000);
		return this;
	}

	public OpportunitiesPage updateDeliveryStatus() {
		scrollToElementUsingJS("xpath", "//a[text()='In progress']");
		clickUsingJS("xpath", "//a[text()='In progress']");
		click(locateElement("xpath","//a[@title='Completed']"));
		return this;
	}
	
	public CampaignsPage clickUpdateOpp() {
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		return new CampaignsPage(driver, test);
		
	}
	
	public String retrieveAmountValue() {
		return getAttribute(locateElement("xpath","//span[text()='Amount']//following::input)[1]"),"value");
		
	}
	

	public OpportunitiesPage enterOppName(String Opportunity) {
		type(locateElement("xpath","(//span[text()='Opportunity Name']//following::input)[1]"),Opportunity);
		return this;
	}


}
