package pages;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class CasesPage extends PreAndPost {

	public CasesPage(EventFiringWebDriver driver, ExtentTest test ){
		this.driver = driver;
		this.test = test;
		
	}
	public EditCasePage clickonyourName() throws InterruptedException {
		sleep(20000);
		click(locateElement("xpath", "//*[@title='00001132']"));
		return new EditCasePage(driver, test);
	}
	public CasesPage clickonName() throws InterruptedException {
		sleep(20000);
		click(locateElement("xpath", "//*[@title='00001135']"));
		return new CasesPage(driver, test);
	}
	public DeleteCasePage clickDelete() {
		sleep(5000);
		click(locateElement("xpath", "//button[text()='Delete']"));
		return new DeleteCasePage(driver, test);
	}
	public newCasePage clicknew() {
		sleep(5000);
		click(locateElement("xpath", "//div[@title='New']"));
		return new newCasePage(driver, test);
	}
}
