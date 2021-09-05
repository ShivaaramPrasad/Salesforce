package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class CertificationWindowPage extends PreAndPost {

	public CertificationWindowPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public CertificationWindowPage selectSaleforceArchitect() throws InterruptedException {
		Thread.sleep(5000);
		   locateElement("xpath","//div[text()='Salesforce Architect']").click();
         return this;
	}
	
	public CertificationWindowPage moreDetailslinkTechnicalArchitCert() {
		locateElement("xpath","//a[text()='More Details']").click();
		return this;
	}
	
	public ArchitectReviewBoardPage navigateArchitectReviewBoardwindow() {
		switchToWindow(3);
		return new ArchitectReviewBoardPage(driver, test);

	}
	
	public CertificationWindowPage certAvailableAdmin() {
		 List<WebElement> path = locateElements("xpath","//div[@class='cs-card tile']/div[3]/a");
        for (WebElement cell: path) {
	          System.out.println(cell.getText());
		
       }
		return this;
	}	
	
	public CertificationWindowPage verifyThePageTile() {
		String Act = driver.getTitle();
		   String exe = "Certification - Architect Overview";
		   if (Act.equals(exe)) {
           System.out.println("Verified Title -> Certification - Architect Overview");
} else {
           System.out.println("Title is incorrect");
}
		   return this;

	}
	
	public CertificationWindowPage certListArchitect() {
		 List<WebElement> path = locateElements("xpath","//div[@class='cs-card tile']/div[3]/a");
       for (WebElement cell: path) {
	          System.out.println(cell.getText());
      }
		return this;
	}	
}
