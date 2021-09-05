package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class SystemStatusPage extends PreAndPost{
	
	public SystemStatusPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public SystemStatusPage clickTrustHome() {
		click(locateElement("xpath", "//div[@id='dropdown-list']//p"));

		return this;
	}
	
	public SystemStatusPage clickTrustCompliance() {
		click(locateElement("xpath", "//p[text()='   Compliance']"));

		return this;
	}
	public SystemStatusPage clickSortByPopularity() {
		clickUsingJS("xpath", "//button[text()=' Show filters ']/following-sibling::button");

		return this;
	}
	public SystemStatusPage clickSortAlphabetically() {
		clickUsingJS("xpath", "//button[text()=' Show filters ']/following-sibling::button");

		return this;
	}
	public SystemStatusPage verifyCertifications() {
		List<WebElement> elementCertification = locateElements("xpath", "//h2[contains(@class,'lh-title')]//a");
		List<String> lstName = new ArrayList<String>();
		List<String> sortName = new ArrayList<String>();
		System.out.println("********All Services***********"); 
		for (int i = 0; i < elementCertification.size(); i++) {
			lstName.add(elementCertification.get(i).getText());
			}
		System.out.println(lstName);
		sortName.addAll(lstName);
		Collections.sort(sortName);
		System.out.println("********Sorted All Services***********"); 
      	System.out.println(sortName);
      	System.out.println("Is the Certification is in sorted order"+lstName.equals(sortName));
		return this;
	}

	
}
