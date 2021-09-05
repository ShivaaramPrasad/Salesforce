package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class CMSPage extends PreAndPost{
	public CMSPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	
	public CMSPage clickCreateCMS() {
		String getPageTitle = driver.getTitle();
		if(getPageTitle.equals("CMS Home | Salesforce"))
			System.out.println("Page Title:"+ getPageTitle);
		click(locateElement("xpath","//span[text()='Create a CMS Workspace']"));
		return this;

	}
	public CMSPage enterName(String CMSName) {
		String keyvalue = "TAB";
		typeUsingKeys(locateElement("xpath","//label[text()='Name']/following::input[@type='text'][1]"),CMSName,keyvalue);
		return this;
	}

	public CMSPage clickNext() {
		click(locateElement("xpath","//button[text()='Next']"));
		return this;
	}

	public CMSPage clickOnCreateChannel() {
		WebElement create_channel = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create Channel']")));
		click(create_channel);
		return this;
	}

	public CMSPage enterChannelName(String VName) {
		type(locateElement("xpath","//h2[text()='Create Channel']/following::input[@type='text']"),VName);
		return this;
	}

	public CMSPage selectConnectionType() {
		click(locateElement("xpath","//h2[@title='Public']"));
		return this;
	}

	public CMSPage clickCreateChannel() {
		click(locateElement("xpath","//button[text()='Create']"));
		return this;
	}

	public CMSPage verifyChannelMessage() throws Exception{
		sleep(3000);
		String verify_message = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@class,'toastMessage')]"))).getText();
		if(verify_message.equals("Channel settings were saved."))
			System.out.println(verify_message);
		else
			System.out.println("Create Channel is not successful");
		return this;
	}

	public CMSPage selectChannel(String VName) {
		String channel_xpath = "//span[text()='"+VName+"'][1]//ancestor::div[@class='slds-checkbox_add-button']/label[1]";
		WebElement select_channel = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(channel_xpath)));
		click(select_channel);
		return this;

	}

	public CMSPage selectContributors() {
		click(locateElement("xpath","//td//input[@type='checkbox']/following::div[1]"));
		click(locateElement("xpath","//td//input[@type='checkbox']/following::div[2]"));
		return this;
	}

	public CMSPage selectFirstUserContibutor() {
		click(locateElement("xpath","//h1[text()='Integration User']/following::input[1]"));
		click(locateElement("xpath","//h1[text()='Integration User']/following::span[@title='Content Manager']"));
		return this;
	}

	public CMSPage selectSecondUserContibutor() {
		click(locateElement("xpath","//h1[text()='Security User']/following::input[1]"));
		click(locateElement("xpath","//h1[text()='Security User']/following::span[@title='Content Admin']"));
		return this;
	}

	public CMSPage selectDefaultLanguage() {
		click(locateElement("xpath","//span[text()='English (United States)']"));
		click(locateElement("xpath","//button[@title='Move selection to Selected']"));
		WebElement default_lang = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Default Language']/following::input")));
		scrollToElementUsingJS("xpath","//label[text()='Default Language']/following::input");
		click(locateElement("xpath","//label[text()='Default Language']/following::input"));
		WebElement Eng_lang = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='slds-media__body']/following::span[@title='English (United States)'][2]")));
		click(Eng_lang);
		return this;
	}

	public CMSPage clickDone() {
		System.out.println(driver.findElement(By.xpath("//button[text()='Done']")).isDisplayed());
		click(locateElement("xpath","//button[text()='Done']"));
		return this;
	}

	public CMSPage verifyCMSMessage(){
		sleep(3000);
		String success_msg = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@class,'toastMessage')]"))).getText();
		if(success_msg.equals("Workspace successfully created"))
			System.out.println(success_msg);
		else
			System.out.println("Create Workspace is not successful");
		return this;
	}

	public CMSPage selectCMSRecord(){
		sleep(4000);
		click(locateElement("xpath","//div[@class='slds-scrollable_y'][1]//td[@role='gridcell']//button[1]"));
		return this;
	}

	public CMSPage clickEdit() {
		click(locateElement("xpath","//a/following::span[text()='Edit']"));
		return this;
	}

	public CMSPage updateCMSName(String Name) {
		String keyvalue = "TAB";
		typeUsingKeys(locateElement("xpath","//label[text()='Name']/following::input[@type='text'][1]"),Name,keyvalue);
		return this;
	}

	public CMSPage clickUpdate() {
		click(locateElement("xpath","//button[text()='Update']"));
		return this;
	}

	public CMSPage verifyEditCMSMessage(){
		sleep(2000);
		String verify_message = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		if(verify_message.equals("Your settings have been successfully saved."))
			System.out.println(verify_message);
		else
			System.out.println("Edit CMS Action is not successful");
		return this;
	}

	
}
