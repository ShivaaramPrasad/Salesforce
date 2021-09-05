package lib.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import lib.listeners.WebDriverListener;

public class WebDriverServiceImpl extends WebDriverListener implements WebDriverService{

	public String sUrl,sHubUrl,sHubPort;
	public Properties prop;

	public WebDriverServiceImpl() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			sUrl = prop.getProperty("URL");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public WebElement locateElement(String locator, String locValue) {

		try {

			switch (locator) {
			case "id": return driver.findElement(By.id(locValue));

			case "name": return driver.findElement(By.name(locValue));

			case "class": return driver.findElement(By.className(locValue));

			case "link" : return driver.findElement(By.linkText(locValue));

			case "xpath": return driver.findElement(By.xpath(locValue));	

			case "tagname": return driver.findElement(By.tagName(locValue));

			default:
				break;
			}
		} catch (NoSuchElementException e) {
			reportStep("The element with locator "+locator+" not found.","FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while finding "+locator+" with the value "+locValue, "FAIL");
		}
		return null;
	}

	public By returnByValue(String locator, String locValue) {

		try {

			switch (locator) {
			case "id": return By.id(locValue);

			case "name": return By.name(locValue);

			case "class": return By.className(locValue);

			case "link" : return By.linkText(locValue);

			case "xpath": return By.xpath(locValue);	

			default:
				break;
			}
		} catch (NoSuchElementException e) {
			reportStep("The element with locator "+locator+" not found.","FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while finding "+locator+" with the value "+locValue, "FAIL");
		}
		return null;
	}

	public List<WebElement> locateElements(String locator, String locValue) {

		try {

			switch (locator) {
			case "id": return driver.findElements(By.id(locValue));

			case "name": return driver.findElements(By.name(locValue));

			case "class": return driver.findElements(By.className(locValue));

			case "link" : return driver.findElements(By.linkText(locValue));

			case "xpath": return driver.findElements(By.xpath(locValue));	

			default:
				break;
			}
		} catch (NoSuchElementException e) {
			reportStep("The elements with locator "+locator+" not found.","FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while finding "+locator+" with the value "+locValue, "FAIL");
		}
		return null;
	}


	public WebElement locateElement(String locValue) {
		return driver.findElement(By.id(locValue));
	}

	public void verifyIfEnabled(WebElement ele) {
		try {
			if(ele.isEnabled()) {
			reportStep("The weblement: "+ele.getText()+" is enabled :"+ele, "PASS");
			} else {
			reportStep("The weblement: "+ele.getText()+" is disabled :"+ele, "PASS");	
			}
		} catch (InvalidElementStateException e) {
			reportStep("The webelement state is invalid "+ele.getText(),"FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured", "FAIL");
		}
	}
	
	//Remote(bRemote-> True)
	public void startApp(String browser, boolean bRemote) {
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);
			// this is for grid run
			if(bRemote)
				try {
					webdriver = new RemoteWebDriver(new URL("http://"+sHubUrl+":"+sHubPort+"/wd/hub"), dc);
				} catch (MalformedURLException e) {
				}
			else{ // this is for local run
				if(browser.equalsIgnoreCase("chrome")){
					//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

					WebDriverManager.chromedriver().setup();
					ChromeOptions ops = new ChromeOptions();
					ops.addArguments("--disable-notifications");
					webdriver = new ChromeDriver(ops);
				}else {
					//System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
					WebDriverManager.firefoxdriver().setup();
					FirefoxOptions opt = new FirefoxOptions();
					opt.setProfile(new FirefoxProfile());
					opt.addPreference("dom.webnotifications.enabled", false);
					webdriver = new FirefoxDriver(opt);
				}
			}
			driver = new EventFiringWebDriver(webdriver);
			driver.register(this);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(sUrl);
			reportStep("The browser: "+browser+" launched successfully", "PASS");
		} catch (WebDriverException e) {			
			reportStep("The browser: "+browser+" could not be launched", "FAIL");
		}
	}

	//Local
	public void startApp(String browser) {
		startApp(browser, false);
	}


	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			reportStep("The data: "+data+" entered successfully in the field :"+ele, "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+ele,"FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+ele, "FAIL");
		}
	}

	public void click(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));			
			text = ele.getText();
			ele.click();
			reportStep("The element "+text+" is clicked", "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+text+" could not be clicked", "FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :", "FAIL");
		} 
	}

	public void clickWithNoSnap(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));	
			text = ele.getText();
			ele.click();			
			reportStep("The element :"+text+"  is clicked.", "PASS",false);
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+text+" could not be clicked", "FAIL",false);
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :","FAIL",false);
		} 
	}

	public String getText(WebElement ele) {	
		String bReturn = "";
		try {
			bReturn = ele.getText();
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		}
		return bReturn;
	}

	public String getTitle() {		
		String bReturn = "";
		try {
			bReturn =  driver.getTitle();
		} catch (WebDriverException e) {
			reportStep("Unknown Exception Occured While fetching Title", "FAIL");
		} 
		return bReturn;
	}

	public String getAttribute(WebElement ele, String attribute) {		
		String bReturn = "";
		try {
			bReturn=  ele.getAttribute(attribute);
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		} 
		return bReturn;
	}

	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		try {
			new Select(ele).selectByVisibleText(value);
			reportStep("The dropdown is selected with text "+value,"PASS");
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		}

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			new Select(ele).selectByIndex(index);
			reportStep("The dropdown is selected with index "+index,"PASS");
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		} 

	}

	public boolean verifyExactTitle(String title) {
		boolean bReturn =false;
		try {
			if(getTitle().equals(title)) {
				reportStep("The title of the page matches with the value :"+title,"PASS");
				bReturn= true;
			}else {
				reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		} 
		return bReturn;
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).equals(expectedText)) {
				reportStep("The text: "+getText(ele)+" matches with the value :"+expectedText,"PASS");
			}else {
				reportStep("The text "+getText(ele)+" doesn't matches the actual "+expectedText,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Text", "FAIL");
		} 

	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).contains(expectedText)) {
				reportStep("The expected text contains the actual "+expectedText,"PASS");
			}else {
				reportStep("The expected text doesn't contain the actual "+expectedText,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Text", "FAIL");
		} 
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			if(getAttribute(ele, attribute).equals(value)) {
				reportStep("The expected attribute :"+attribute+" value matches the actual "+value,"PASS");
			}else {
				reportStep("The expected attribute :"+attribute+" value does not matches the actual "+value,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Attribute Text", "FAIL");
		} 

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			if(getAttribute(ele, attribute).contains(value)) {
				reportStep("The expected attribute :"+attribute+" value contains the actual "+value,"PASS");
			}else {
				reportStep("The expected attribute :"+attribute+" value does not contains the actual "+value,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Attribute Text", "FAIL");
		}
	}

	public void verifySelected(WebElement ele) {
		try {
			if(ele.isSelected()) {
				reportStep("The element "+ele+" is selected","PASS");
			} else {
				reportStep("The element "+ele+" is not selected","FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}
	}

	public void verifyDisplayed(WebElement ele) {
		try {
			if(ele.isDisplayed()) {
				reportStep("The element "+ele+" is visible","PASS");
			} else {
				reportStep("The element "+ele+" is not visible","FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 
	}

	public void switchToWindow(int index) {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			List<String> allHandles = new ArrayList<>();
			allHandles.addAll(allWindowHandles);
			driver.switchTo().window(allHandles.get(index));
		} catch (NoSuchWindowException e) {
			reportStep("The driver could not move to the given window by index "+index,"PASS");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}
	}

	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			reportStep("switch In to the Frame "+ele,"PASS");
		} catch (NoSuchFrameException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 
	}

	public void switchToDefaultContent() {
		try {
			driver.switchTo().defaultContent();
			reportStep("switch out of the Frame ","PASS");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 
	}	

	public void acceptAlert() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.accept();
			reportStep("The alert "+text+" is accepted.","PASS");
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}  
	}

	public void dismissAlert() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			reportStep("The alert "+text+" is dismissed.","PASS");
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 

	}

	public String getAlertText() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 
		return text;
	}


	public void closeActiveBrowser() {
		try {
			driver.close();
			reportStep("The browser is closed","PASS", false);
		} catch (Exception e) {
			reportStep("The browser could not be closed","FAIL", false);
		}
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			reportStep("The opened browsers are closed","PASS", false);
		} catch (Exception e) {
			reportStep("Unexpected error occured in Browser","FAIL", false);
		}
	}


	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			new Select(ele).selectByValue(value);
			reportStep("The dropdown is selected with text "+value,"PASS");
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		}

	}


	@Override
	public boolean verifyPartialTitle(String title) {
		boolean bReturn =false;
		try {
			if(getTitle().contains(title)) {
				reportStep("The title of the page matches with the value :"+title,"PASS");
				bReturn= true;
			}else {
				reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		} 
		return bReturn;		
	}


	public void clickUsingJS(String locator, String locValue) {
		String text="";
		try {
			WebElement ele = locateElement(locator,locValue);
			text=ele.getText();
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", ele);	

			reportStep("The element "+text+" is clicked", "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+text+" could not be clicked", "FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :", "FAIL");
		} 
	}

	public void scrollToElementUsingJS(String locator, String locValue) {
		String text="";
		try {
			WebElement ele = locateElement(locator,locValue);
			text=ele.getText();
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)", ele);
			reportStep("The control is scrolled to element: "+text, "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The control cannot be scrolled to element: "+text, "FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while scrolling to element :"+text, "FAIL");
		} 
	}

	public void sleep(long seconds) {

		try {
			Thread.sleep(seconds);
			reportStep("Sleep for "+seconds+" seconds", "PASS");
		} catch (InterruptedException e) {
			reportStep("Sleep thrown interrupted exception", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured waiting", "FAIL");
		} 
	}

	public int sizeOfWebElements(List<WebElement> elements) {
		int size=0;
		try {
			size = elements.size();
			reportStep("Size of the list is: "+size, "PASS");
		} catch (IndexOutOfBoundsException e) {
			reportStep("Size throws indexoutofbound exception", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured waiting", "FAIL");
		} 

		return size;
	}

	public void compareWebElementsSize(String condition, int list1Size, int list2Size) {

		try {
			switch(condition) {
			case "greater": {
				if(list1Size>list2Size) {
					reportStep("List1: "+list1Size+" is greater than list2: "+list2Size, "PASS");
				}else {
					reportStep("List1: "+list1Size+" is lesser than list2"+list2Size, "FAIL");
				}
			}
			case "lesser": {
				if(list1Size<list2Size) {
					reportStep("List2: "+list2Size+" is greater than list1: "+list1Size, "PASS");
				}else {
					reportStep("List2: "+list2Size+" is lesser than list1"+list1Size, "FAIL");
				}
			}
			case "equals" : {
				if(list1Size==list2Size) {
					reportStep("List2: "+list2Size+" is equal to list1: "+list1Size, "PASS");
				}else {
					reportStep("List2: "+list2Size+" is not equal to list1"+list1Size, "FAIL");
				}
			}
			default: break;
			}

		} catch (IndexOutOfBoundsException e) {
			reportStep("Size throws indexoutofbound exception", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured waiting", "FAIL");
		} 
	}

	public void webDriverWait(String condition, String locator, String locatorValue) {
		WebElement element=null;
		try {
			WebDriverWait wait = new WebDriverWait(driver,10);	
			condition = condition.toLowerCase();

			switch(condition) {
			case "stalenessRefreshed": {
				element = locateElement(locator, locatorValue);
				wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
				break;
			}
			case "clickable": {
				element = locateElement(locator, locatorValue);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				break;
			}
			case "visibility": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(returnByValue(locator,locatorValue)));
				break;
			}
			case "invisibility": {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(returnByValue(locator,locatorValue)));
				break;
			}
			case "presence": {
				wait.until(ExpectedConditions.presenceOfElementLocated(returnByValue(locator,locatorValue)));
				break;
			}
			default: break;
			}
		}catch (NoSuchElementException e) {
			reportStep("The elements "+element.getText()+" not found.","FAIL");
		}catch (ElementClickInterceptedException e) {
			reportStep("Clicking on the element: "+element.getText()+" is intercepted", "FAIL");
		}catch (ElementNotVisibleException e) {
			reportStep("The element: "+element.getText()+" is not visible", "FAIL");
		}catch (WebDriverException e) {
			reportStep("Unknown exception occured while finding "+element.getText(), "FAIL");
		}
	}
	public void scrollDown() {
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,1000)");
		} catch (NoSuchElementException e) {
			reportStep("Scroll down the page is not working","FAIL");
		}catch (WebDriverException e) {
			reportStep("Scroll down the page is not working", "FAIL");
		}
	}

	public void typeUsingKeys(WebElement ele, String data,String keyvalue) {
		try {
			ele.clear();
			if(keyvalue.equalsIgnoreCase("TAB"))
				ele.sendKeys(data,Keys.TAB);
			else if(keyvalue.equalsIgnoreCase("ENTER"))
				ele.sendKeys(data,Keys.ENTER);
			else if(keyvalue.equalsIgnoreCase("SPACE"))
				ele.sendKeys(data,Keys.SPACE);
			reportStep("The data: "+data+" entered successfully in the field :"+ele, "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+ele,"FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+ele, "FAIL");
		}
	}
	
	public void typeOnlyKeys(WebElement ele, String keyvalue) {
		try {
			ele.clear();
			if(keyvalue.equalsIgnoreCase("TAB"))
				ele.sendKeys(Keys.TAB);
			else if(keyvalue.equalsIgnoreCase("ENTER"))
				ele.sendKeys(Keys.ENTER);
			else if(keyvalue.equalsIgnoreCase("SPACE"))
				ele.sendKeys(Keys.SPACE);
			reportStep("The data: "+keyvalue+" entered successfully in the field :"+ele, "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+keyvalue+" could not be entered in the field :"+ele,"FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+keyvalue+" in the field :"+ele, "FAIL");
		}
	}
	
	public int getTableRowSize(WebElement totalCountInPortal, String tableRowLocatorValue) {
		int totalrows=0;
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			String total = getText(totalCountInPortal);
			total=total.replaceAll("\\D", "");
			int temp = Integer.parseInt(total);
			int count =1;
			while(count<=temp) {
				js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath(tableRowLocatorValue+"["+count+"]")));
				count++;
			}
			System.out.println(count);
			System.out.println(driver.findElements(By.xpath(tableRowLocatorValue+"["+count+"]")));
			totalrows = driver.findElements(By.xpath(tableRowLocatorValue+"["+count+"]")).size();
			reportStep("Total rows in table is: "+totalrows,"PASS");
			return  totalrows;
		}catch (NumberFormatException e) {
			reportStep("NumberFormatException exception occured getting the size","FAIL");
		} 

		catch (Exception e) {
			reportStep("Unknown exception occured while getting row size","FAIL");
		}
		return  totalrows;
	}
	
	public void compareTwoString(String inputString, String expectedString) {
		try {
			if(inputString.equals(expectedString)) {
				reportStep("Two strings are equal: "+inputString, "PASS");
			} else {
				reportStep("Two strings are not equal: "+inputString, "FAIL");
			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while string compare","FAIL");
		}
	}
	
	public void pageReload() {
		try {
			driver.navigate().refresh();
		}catch (Exception e) {
			reportStep("Unknown exception occured while reload","FAIL");
		}

	}
}