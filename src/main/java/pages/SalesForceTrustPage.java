package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class SalesForceTrustPage extends PreAndPost {

	public SalesForceTrustPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public SalesForceTrustPage switchToSalesForceTrustWindow() {
		switchToWindow(1);
		return this;
	}
	
	public SalesForceTrustPage selectTrustFromDD() {
		click(locateElement("xpath", "//div[@id='dropdown-list']/p"));
		click(locateElement("xpath", "//li[@id='Compliance']//p[contains(text(),'Compliance')]"));
		return this;
	}
	
	public SalesForceTrustPage clickShowFilters() {
		webDriverWait("visibility", "xpath", "//*[@id='filterList']/..");
		click(locateElement("xpath", "//*[@id='filterList']/.."));
		return this;
	}
	
	public SalesForceTrustPage selectNonProfit() {
		click(locateElement("xpath", "//label[@for='Nonprofit']"));
		scrollToElementUsingJS("xpath", "//label[@for='Nonprofit']");
		return this;
	}
	
	public SalesForceTrustPage verifyOnly20AreDisplayed(String expectedSize) {
		int actualSize = sizeOfWebElements(locateElements("xpath", "//div[@class='slds-card__body slds-card__body_inner']"));
		compareWebElementsSize("equals",actualSize,Integer.parseInt(expectedSize));
		return this;
	}
}
