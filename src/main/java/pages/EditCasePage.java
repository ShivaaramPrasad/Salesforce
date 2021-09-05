package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class EditCasePage extends PreAndPost {
	public EditCasePage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	
		public EditCasePage clickEdit() throws InterruptedException {
			sleep(10000);
			click(locateElement("xpath","//button[text()='Edit']"));
			return this;
		}
	
	public EditCasePage clickSave() {
		sleep(5000);
		click(locateElement("xpath","(//span[text()='Save'])[2]"));
		return this;

	}
	public CasesPage verify() {
		sleep(5000);
		String status = getText(locateElement("xpath","//lightning-formatted-text[text()='New']"));
		if (status.contains("New")) {
			System.out.println("status is working");
			
		}else {
			System.out.println("status is not workng");
		}
	return new CasesPage(driver, test);
	}
}
