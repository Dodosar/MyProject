package com.Bank.Utilitus;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.Bank.base.TestBase;

public class TestUtil extends TestBase{

	public static String path;
	
	public static void captureScreenshot(ITestResult result) {
		String screenshotName = result.getMethod().getMethodName().toString();
		try {
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("D:\\Selenium\\Screens" + "\\" + screenshotName	+ ".png"));
			String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
			System.setProperty(ESCAPE_PROPERTY, "false");
			path = "D:\\Selenium\\Screens" + "\\" + screenshotName
					 + ".png";				
		}

		catch (Exception e) {
			System.out.println("Exception while taking screenshot "
					+ e.getMessage());
		}			
	}
	
}
