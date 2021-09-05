package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class AppLauncherPage extends PreAndPost {

	public AppLauncherPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public ServicePage clickService() {
		click(locateElement("link", "Service"));
		return new ServicePage(driver, test);
	}

	public ContactsPage clickContacts() {
		collapseAll();
		scrollToElementUsingJS("xpath", "//p[@class='slds-truncate' and text()='Contacts']");
		click(locateElement("xpath", "//p[@class='slds-truncate' and text()='Contacts']"));
		return new ContactsPage(driver, test);
	}

	public SalesPage clickSales() {
		click(locateElement("xpath", "//p[text()='Sales']"));
		return new SalesPage(driver, test);

	}

	public AppLauncherPage collapseAll() {
		click(locateElement("xpath", "//span[text()='All Apps']"));
		return this;
	}

	public CMSPage clickCMSHome() {
		// To scroll and select CMS Home link
		WebElement cms_home = locateElement("xpath", "//p[text()='CMS Home']");
		scrollToElementUsingJS("xpath", "//p[text()='CMS Home']");
		clickUsingJS("xpath", "//p[text()='CMS Home']");
		return new CMSPage(driver, test);

	}

	public BoltSolutionsPage clickBoltSolutions() {
		click(locateElement("xpath", "//p[text()='Bolt Solutions']"));
		return new BoltSolutionsPage(driver, test);
	}

	public ContactPointTypeConsentPage clickContactPointTypeConsent() {
		clickUsingJS("xpath", "//span[text()='Contact Point Type Consent']");
		return new ContactPointTypeConsentPage(driver, test);
	}

	public WorkTypePage clickOnWorkTypes() {

		clickUsingJS("xpath", "//p[contains(text(),'Work Types')]");
		return new WorkTypePage(driver, test);
	}

	public ContentPage clickonContentApp() {
		click(locateElement("xpath", "//p[text()='Content']"));
		System.out.println("Content App is Clicked");

		return new ContentPage(driver, test);
	}

	public CommunityPage clickonCommunityApp () {
		click(locateElement("xpath", "//p[text()='Community']"));
		System.out.println("Content App is Clicked");
		return new CommunityPage(driver, test);
	}

}
