package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class AppStorePage extends PreAndPost{
	int genrated_id=0;
	public AppStorePage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public AppStorePage getTheLinkDisplayed() {
		System.out.println("Genrated Url "+getText(locateElement("class", "warning")));
		String genrated_id_num=getText(locateElement("class", "warning")).substring(46, 55);
		genrated_id=Integer.parseInt(genrated_id_num); 
		System.out.println("Genrated Sesssion ID "+genrated_id);
		return this;
	}
	
	public AppStorePage clickTheLinkDisplayed() {
		click(locateElement("link", "Confirm"));

		return this;
	}
	
	
	public AppStorePage verifyTheLinkDisplayed() {
		String launch_url = driver.getCurrentUrl();
		String launch_id_num=launch_url.replaceAll("\\D","");
		int launch_id=Integer.parseInt(launch_id_num); 
		System.out.println("Launced Url "+launch_url);
		System.out.println("Launced Sesssion ID "+launch_id);
		if (launch_id==(genrated_id)) {

			System.out.println("URL is same and verifed  successfully ");

		} else {
			System.out.println("URL is not same and need be verifed  ");	
	}
		return this;
}
}