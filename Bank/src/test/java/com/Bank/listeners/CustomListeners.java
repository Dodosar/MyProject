package com.Bank.listeners;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.Bank.Utilitus.TestUtil;


public class CustomListeners implements ITestListener{
	
	public static String path;

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		TestUtil.captureScreenshot(result);
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.path + "><img src=" + TestUtil.path + " height=200 width=200>Passed Screenshot</a>" + "<br>");
	}


	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		TestUtil.captureScreenshot(result);
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.path + "><img src=" + TestUtil.path + " height=200 width=200>Passed Screenshot</a>" + "<br>");
	}


	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		TestUtil.captureScreenshot(result);
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.path + "><img src=" + TestUtil.path + " height=200 width=200>Passed Screenshot</a>" + "<br>");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		TestUtil.captureScreenshot(result);
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.path + "><img src=" + TestUtil.path + " height=200 width=200>Passed Screenshot</a>" + "<br>");
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
