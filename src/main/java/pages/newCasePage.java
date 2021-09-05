
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Sleeper;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;


public class newCasePage extends PreAndPost{
	public newCasePage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public newCasePage selectContactName() throws InterruptedException {
		sleep(10000);
		click(locateElement("xpath", "//input[@title='Search Contacts']"));
		click(locateElement("xpath", "//div[text()='Naveen Elumalai']"));
		return this;
	}

	public newCasePage selectEscalated() throws InterruptedException {
		sleep(10000);
		click(locateElement("xpath", "//*[text()='New']"));
		click(locateElement("xpath", "//a[@title='Escalated']"));

		return this;

	}
	public newCasePage enterSubTesting(String subject) {
		sleep(5000);
		type(locateElement("xpath", "//span[text()='Subject']/following::input"),subject);
		return this;

	}
	public HomePage clickSave() {
		click(locateElement("xpath", "(//span[text()='Save'])[2]"));
		return new HomePage(driver, test);
	}
	public newCasePage selectStatusNone() {
		sleep(5000);
		click(locateElement("xpath", "(//input[@role='textbox'])[2]"));
		click(locateElement("xpath", "//label[text()='Status']/following-sibling::div//span[text()='--None--']"));
		return this;
	}
	public newCasePage enterSubjTesting(String subject) {
		type(locateElement("xpath", "(//span[text()='Subject'])[2]/following::input"), subject);
		return this;
	}
	public newCasePage enterDescrTesting(String Desc) {
		type(locateElement("xpath", "(//span[text()='Subject'])[2]/following::input"), Desc);
		return this;
	}
	public newCasePage ClickSave() {
		sleep(5000);
		click(locateElement("xpath", "(//span[text()='Save'])[2]"));
		return this;
	}
	public newCasePage errorMsgVerfication() {
		String text = getText(locateElement("xpath","//*[text()='These required fields must be completed: Case Origin, Status']"));
		System.out.println(text);if (text.contains("These required fields must be completed:")) {
			System.out.println("error message displayed");
		}else {
			System.out.println("error message not displayed");
		}
		return new newCasePage(driver,test) ;
	}

}
