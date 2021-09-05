package lib.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;

public class TestngListener implements IAnnotationTransformer,IRetryAnalyzer{
	
	int maxcount = 1;
	
	public void transform(ITestAnnotation annotation,Class testClass, Constructor testConstructor,
			Method testMethod) {
		annotation.setRetryAnalyzer(this.getClass());
		if(testMethod.getName().equals("TestcaseName")) {
			annotation.setInvocationCount(1);
		}
	}
		
	public boolean retry(ITestResult result) {
		if (!result.isSuccess() & maxcount < 2) {
			maxcount++;
			return true;
		}
		return false;
	}
	
	
	
	

}
























