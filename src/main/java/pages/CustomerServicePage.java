package pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class CustomerServicePage extends PreAndPost {

	public CustomerServicePage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public CustomerServicePage navigateToCustomerServicePage() {
		switchToWindow(1);
		return this;
	}
	
	public CustomerServicePage verifyTabDisplayed() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> path = locateElements("xpath", "//li[contains(@id,'menu_item')][not(contains(@class,'hide'))]/button/span[1]");
				for (WebElement cell: path) {
					String name = cell.getText();
					System.out.println(name);
					}
		return this;
	}
	
	public CustomerServicePage supportAndService() {
		Actions actions = new Actions(driver);
		   WebElement menu = locateElement("support-service_menu_item");
		   actions.moveToElement(menu);
		return this;

	} 
	
	public CustomerServicePage clickOnCertificationsLink() {
		WebElement subMenu = locateElement("xpath","//span[text()='Learning & Tutorials']/following::span[text()='Certification ']");
		   JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", subMenu);
		return this;
	}
	
	public CertificationWindowPage navigateToCertificationWindow() {
		switchToWindow(2);
		return new CertificationWindowPage(driver, test);
	}
}
