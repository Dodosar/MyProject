package com.Bank.Utilitus;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.Bank.base.TestBase;

public class TestUtil extends TestBase{

	public static String path;
	public static File file;
	
	public static void captureScreenshot(ITestResult result) {
		String screenshotName = result.getMethod().getMethodName().toString();
		try {
			Date d = new Date(); 
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			file = new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html" + "\\" + screenshotName	+ d.toString().replace(":", "_").replace(" ", "_") + ".png");
			FileUtils.copyFile(source,file);
			String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
			System.setProperty(ESCAPE_PROPERTY, "false");
			path = file.getAbsolutePath();
		}
		catch (Exception e) {
			System.out.println("Exception while taking screenshot "
					+ e.getMessage());
		}			
	}
	
}
