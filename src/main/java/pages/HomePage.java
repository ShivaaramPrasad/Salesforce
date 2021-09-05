package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class HomePage extends PreAndPost{
	
	public HomePage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public HomePage clickAppLauncer() {
		sleep(10000);
		click(locateElement("class", "slds-icon-waffle"));
		return this;
	}
	
	public AppLauncherPage clickViewAll() {
		sleep(10000);
		click(locateElement("xpath", "//button[text()='View All']"));
		return new AppLauncherPage(driver, test);
	}
	
	public HomePage clickGlobalActionsSVGIcon() {
		sleep(10000);
		click(locateElement("xpath", "//*[@data-key='add']"));
		return this;
	}

   	//Click on New Task	
	public CreateTaskPage clickNewTask() throws InterruptedException {
		Thread.sleep(3000);
		click(locateElement("xpath", "//a[@title='New Task']"));
		System.out.println("New Task is clicked Successfully");
		return new CreateTaskPage(driver, test);
	}
	
	public CustomerServicePage clickLearnMore() throws InterruptedException {
		Thread.sleep(2000);
		click(locateElement("xpath", "//span[text()='Learn More']"));
		return new CustomerServicePage(driver, test);
	}	
	public HomePage findAndClickElementInScrollBarOpenInNewWindow(String elementText) throws InterruptedException {
		Thread.sleep(5000);
		List<WebElement> locateElements = locateElements("xpath", "//li[@data-aura-class='uiCarouselPageIndicatorItem']//a");

		int num =locateElements.size();
		System.out.println("Number of Scroll "+num);

		int x=0;

		while ( x <=num) {
			
			if (!locateElement("xpath","//span[text()='"+elementText+"']").isDisplayed()) {
				
				System.out.println(" element is not visble ");
				//WebDriverWait wait = new WebDriverWait(driver,5);
				Thread.sleep(5000);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='rightScroll']//button[1]")));
				click(locateElement("xpath", "//div[@class='rightScroll']//button[1]"));

				x++;

			} 
			else {
				
				System.out.println(" element is visble ");
                break;
			}

		}
		
		Thread.sleep(5000);		

		return this;
	}
	
	public newCasePage clickNewCase() {
	     sleep(40000);
	     click(locateElement("xpath","//span[text()='New Case']"));
			return new newCasePage(driver, test);
	}
	
	public HomePage verficationOnNewCaseCreated() {
		String text = getText(locateElement("xpath","//div[@data-key='success']"));
		System.out.println(text);if (text.contains("Case")) {
			System.out.println("passed");
		}else {
			System.out.println("failed");
		}
		return this ;
		}
	
	public AppStorePage clickAppStore() {
	     click(locateElement("xpath","//span[text()='App Store']"));
			switchToWindow(1);

			return new AppStorePage(driver, test);
	}
	
	public SystemStatusPage clickGetStarted() {
	     click(locateElement("xpath","(//span[text()='See System Status']/following::span)[2]"));
			switchToWindow(1);

			return new SystemStatusPage(driver, test);
	}

	public HomePage clickSliderUntilSystemStatus() {
		WebElement sysStatus = driver.findElement(By.xpath("//div[@class='carousel']//article//span[text()='See System Status']"));
		WebElement rightArr = driver.findElement(By.xpath("//button[contains(@class,'rightArrowButton uiButton')]"));
		
		boolean value = true;
		while(value) {
			if(sysStatus.isDisplayed()) {
				System.out.println("Element is displayed: "+sysStatus.getText());
				value = false;
				break;
			}
			else {
				rightArr.click();
			}
		}
		return this;
	}
	
	public SalesForceTrustPage getStartedSystemStatus() {
		click(locateElement("xpath", "//span[text()='See System Status']/following::span[text()[normalize-space()='Get Started']]"));
		return new SalesForceTrustPage(driver,test);
	}
	
	public OpportunitiesPage clickNewOpportunity() throws InterruptedException {
		Thread.sleep(3000);
		click(locateElement("xpath", "//a[@title='New Opportunity']"));
		System.out.println("New Opportunity is clicked Successfully");
		return new OpportunitiesPage(driver, test);
	}
	
	public NewOpportunityPage clickNewOpp() {
		click(locateElement("xpath", "//a[@title='New Opportunity']"));
		return new NewOpportunityPage(driver, test);
	}
	
	public HomePage clickSliderUntilDownloadSalesForceA() {
		WebElement salesForce = driver.findElement(By.xpath("//div[@class='carousel']//span[text()='Download SalesforceA']"));
		WebElement rightArr = driver.findElement(By.xpath("//button[contains(@class,'rightArrowButton uiButton')]"));
		
		boolean value = true;
		while(value) {
			if(salesForce.isDisplayed()) {
				System.out.println("Element is displayed: "+salesForce.getText());
				value = false;
				break;
			}
			else {
				rightArr.click();
			}
		}
		return this;
	}
	
	
	  public GooglePlayStorePage clickGooglePlayLinkSalesForceA() {
	  click(locateElement("xpath",
	  "//button[@title='Google Play']/span[contains(@class,'label bBody')]"));
	  switchToWindow(1); getTitle();
	  
	  return new GooglePlayStorePage(driver,test);
	  }
	 
}

