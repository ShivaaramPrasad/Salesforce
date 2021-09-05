package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class NewChartPage extends PreAndPost {

	public NewChartPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public NewChartPage typeChartName(String ChartName) {
	type(locateElement("xpath", "//input[@class='chartNameInputBox input']]"), ChartName);
	System.out.println("Chart name is typed as Unschedule Task Chart");
	return this;
	}
	
	public NewChartPage clickOnChartTypeDropDown() throws InterruptedException {
	Thread.sleep(2000);
	click(locateElement("xpath", "(//a[contains(text(),'Horizontal Bar Chart')])[1]"));
	System.out.println("Chart dropdown is clicked");
	return this;
	}
	
	public NewChartPage chooseDonutChart() {
	click(locateElement("xpath", "//a[@title='Donut Chart']"));
	System.out.println("Chart option is selected as Donut");
	return this;
	}
	
	public NewChartPage clickOnAggregateDropDown() {
	click(locateElement("xpath", "(//a[contains(text(),'Account')])[1]"));
	System.out.println("Aggregrate Dropdown is clicked");
	return this;
	}		
			
	public NewChartPage chooseAggegrateAsPriority() {
	click(locateElement("xpath", "//a[@title='Priority']"));
	System.out.println("Aggegrate is choosed as priority");
	return this;
	}			

	public NewChartPage clickOnGroupingDropDown() {
	click(locateElement("xpath", "(//a[contains(text(),'Account')])[1]"));
	System.out.println("Grouping dropdown is clicked");
	return this;
	}		
	
	public NewChartPage chooseGropuingAsStatus() {
	click(locateElement("xpath", "(//a[@title='Status'])[2]"));
	System.out.println("Grouping is selected as Status");
	return this;
	}	
	
	public NewChartPage clickSaveChart() {
	click(locateElement("xpath", "//button[@title='Save']"));
	System.out.println("Save button is clicked");	
	return this;
	}	
}
