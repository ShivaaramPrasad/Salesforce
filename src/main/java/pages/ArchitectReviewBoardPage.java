package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class ArchitectReviewBoardPage extends PreAndPost {
	
	public ArchitectReviewBoardPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public ArchitectReviewBoardPage verifyLocationandDates() {
		List<WebElement> path = locateElements("xpath","//div[contains(text(),'Dec')]/following-sibling::div[contains(text(),'Planning')]/preceding-sibling::div[@class='slds-col--padded slds-size--1-of-1 slds-medium-size--4-of-12']");
	    for (WebElement cell: path) {
	         System.out.println(cell.getText());
	}
	    return this;
	}
	
}
	
