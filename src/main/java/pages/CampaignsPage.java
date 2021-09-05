package pages;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class CampaignsPage extends PreAndPost{

	String Campaign_name;
	public CampaignsPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public CampaignsPage clickNewCampaign() {

		click(locateElement("xpath","//a[@title='New'][1]"));
		return this;
	}

	public CampaignsPage enterCampaignName(String Name) {
		type(locateElement("xpath","//span[text()='Active']//preceding::input[@class=' input']"),Name);
		Campaign_name = driver.findElement(By.xpath("//span[text()='Active']//preceding::input[@class=' input']")).getAttribute("value");
		System.out.println(Campaign_name);
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

	public CampaignsPage selectStartDate() {
		String startDate = selectDate(1);
		String startdate_xpath = "//td[@data-datevalue='"+startDate+"']";
		scrollToElementUsingJS("xpath","(//div[@class='form-element']//following::span[text()='Date Picker'])[1]");
		clickUsingJS("xpath","(//div[@class='form-element']//following::span[text()='Date Picker'])[1]");
		click(locateElement("xpath",startdate_xpath));
		return this;

	}

	public CampaignsPage selectEndDate() {
		String endDate = selectDate(2);
		String enddate_xpath = "//td[@data-datevalue='"+endDate+"']";
		scrollToElementUsingJS("xpath","(//div[@class='form-element']//following::span[text()='Date Picker'])[2]");
		clickUsingJS("xpath","(//div[@class='form-element']//following::span[text()='Date Picker'])[2]");
		click(locateElement("xpath",enddate_xpath));
		return this;

	}

	public SalesPage clickSave() {
		click(locateElement("xpath","//button[@title = 'Save']"));
		sleep(3000);
		return new SalesPage(driver,test);

	}
	
	public CampaignsPage clickSaveCampaign() {
		click(locateElement("xpath","//button[@title = 'Save']"));
		sleep(3000);
		return this;

	}
	
	public CampaignsPage verifyNewCampaignCreated() {
		String camp_xpath = "//div[text()='Campaign']//following::span[text()='"+ Campaign_name +"']";
		String camp_name = getText(locateElement("xpath",camp_xpath));

		if(Campaign_name.equals(camp_name))
			System.out.println("Campaign creation is successful.");
		else
			System.out.println("Campaign creation is not successful.");
		return this;
	}
	
	public CampaignsPage verifyCampaignCreation(String Name) {
		sleep(3000);
		String camp_xpath = "//a[text()='"+ Name +"']";
		String camp_name = getText(locateElement("xpath",camp_xpath));

		if(Name.equals(camp_name))
			System.out.println("Campaign creation is successful.");
		else
			System.out.println("Campaign creation is not successful.");
		return this;

	}
	
	public OpportunitiesPage createNewOpportunity() {
		click(locateElement("xpath","(//span[text()='Opportunities']//following::div[text()='New'])[2]"));
		return new OpportunitiesPage(driver,test);
		
	}
	
	public CampaignsPage verifyOppCreated(String Opp_name){
		sleep(4000);
		String opp_xpath = "//a[text()='"+Opp_name+"']";
		scrollToElementUsingJS("xpath",opp_xpath);
		System.out.println(getText(locateElement("xpath",opp_xpath)));
		return this;
	}
	
	public CampaignsPage navigateToActionKey(String Opp_name) {
		String actionkey_xpath = "//a[text()='"+Opp_name+"']//preceding::a[1]"; 
		scrollToElementUsingJS("xpath", actionkey_xpath);
		clickUsingJS("xpath", actionkey_xpath);
		return this;
	}
	public OpportunitiesPage selectEditOpp() {
		click(locateElement("xpath","//a[@title='Edit']"));
		return new OpportunitiesPage(driver,test);
	}
	
	public CampaignsPage verifyOppAmount(String amtvalue){
		sleep(3000);
		String amt_xpath = "//div[@title='Amount:']//following::span[text()='"+amtvalue+"']";
		String verifyamt = driver.findElement(By.xpath(amt_xpath)).getText();
		String actualval = amtvalue;
		if(verifyamt.equalsIgnoreCase(actualval))
			System.out.println("Amount:" + actualval);
		else
			System.out.println("Incorrect Amount:" + actualval);
		return this;
	}
	
	public CampaignsPage selectDeleteOpp() {
		click(locateElement("xpath","(//a[@title='Delete'])[2]"));
		click(locateElement("xpath","//span[text()='Delete']"));
		return this;
	}
	
	public CampaignsPage verifyOpportunity(String Opp_name) {
		sleep(3000);
		String opp_xpath = "//a[text()='"+Opp_name+"']";
		List<WebElement> opp_list = locateElements("xpath",opp_xpath);
		if(opp_list.isEmpty())
			System.out.println(Opp_name+"is deleted successfully");
		else
			System.out.println(Opp_name+"is not deleted successfully");
		return this;
	}
	
}
