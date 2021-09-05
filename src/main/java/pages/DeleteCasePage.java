package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class DeleteCasePage  extends PreAndPost{
	public DeleteCasePage(EventFiringWebDriver driver, ExtentTest test ){
		this.driver = driver;
		this.test = test;
		
	}
	public DeleteCasePage confirmDelete() {
		sleep(5000);
		click(locateElement("xpath", "//span[text()='Delete']"));
		return this;
	}
	public CasesPage verficationOnDeleteCase() {
		String text = getText(locateElement("xpath","//span[contains(@class,'toastMessage slds-text-heading--small')]"));
		System.out.println(text);
		
		if (text.contains("Case")) {
			System.out.println("case got deleted");
		}else {
			System.out.println("case was not deleted");
		}
		return new CasesPage(driver, test) ;
		}
}
