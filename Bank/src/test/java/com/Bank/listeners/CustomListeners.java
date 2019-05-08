package com.Bank.listeners;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.Bank.Utilitus.TestUtil;
import com.Bank.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;


public class CustomListeners extends TestBase implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		test = rep.startTest(result.getName().toUpperCase());
		TestUtil.captureScreenshot(result);	
		
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.path + "><img src=" + TestUtil.path + " height=200 width=200>Start Test Screenshot</a>" + "<br>");

	}


	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(LogStatus.PASS, result.getName().toUpperCase() + " PASS");
		rep.endTest(test);
		rep.flush();
	}


	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		TestUtil.captureScreenshot(result);
		test.log(LogStatus.FAIL, result.getName().toUpperCase()  +"Failed with exceprion: " + result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.path));
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.path + "><img src=" + TestUtil.path + " height=200 width=200>Failed Screenshot</a>" + "<br>");
		rep.endTest(test);
		rep.flush();
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		TestUtil.captureScreenshot(result);
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.path + "><img src=" + TestUtil.path + " height=200 width=200>Skipped Screenshot</a>" + "<br>");
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
	}


	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	


}
