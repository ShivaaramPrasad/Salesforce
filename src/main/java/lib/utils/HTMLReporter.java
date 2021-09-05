package lib.utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class HTMLReporter {

	public static ExtentHtmlReporter html;
	public static ExtentReports extent;
	public ExtentTest testSuite, test;
	public String testCaseName, testDescription, nodes, authors,category;

	//@BeforeSuite
	public void startReport() {
		html = new ExtentHtmlReporter("./reports/result.html");
		html.setAppendExisting(true);
		html.loadXMLConfig("./src/main/resources/extent-config.xml");
		extent = new ExtentReports();
		extent.attachReporter(html);		
	}

	//@BeforeClass
	public ExtentTest startTestCase(String testCaseName, String testDescription) {
		testSuite = extent.createTest(testCaseName, testDescription);		
		return testSuite;
	}

	//@BeforeMethod
	public ExtentTest startTestModule(String nodes) {
		test = testSuite.createNode(nodes);
		return test;
	}

	//@AfterSuite
	public void endResult() {
		extent.flush();
	}

	public abstract long takeSnap();

	public void reportStep(String desc,String status, boolean bSnap) {
		
		MediaEntityModelProvider img = null;
		
		if(bSnap && !status.equalsIgnoreCase("INFO")){

			long snapNumber = 100000L;
			snapNumber = takeSnap();
			try {
				img = MediaEntityBuilder.createScreenCaptureFromPath
						("./../reports/images/"+snapNumber+".png").build();
			} catch (IOException e) {
				
			}
		}		

		if(status.equalsIgnoreCase("PASS")) {
			test.pass(desc, img);		
		}else if(status.equalsIgnoreCase("FAIL")) {
			test.fail(desc, img);
			throw new RuntimeException();
		}else if(status.equalsIgnoreCase("WARNING")) {
			test.warning(desc, img);		
		}else {
			test.info(desc);
		}
	}

	public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}


}
