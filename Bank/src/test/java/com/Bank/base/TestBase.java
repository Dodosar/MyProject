package com.Bank.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.Bank.Utilitus.ExcelReader;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;



public class TestBase {
	
	/*
	 * WebDriver -done
	 * Properties -done
	 * Logs -log4j.jar .log, log.properies ,Logger
	 * ExtentReports
	 * DB
	 * Excel
	 * Mail
	 * ReportNG ExtentReports  
	 * Jenkins
	 * 
	 */
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel= new ExcelReader("C:\\Users\\tyudm\\eclipse-workspace\\MyExamples\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public static int b;
	private static TestBase instance  = null;

	@BeforeSuite(alwaysRun = true)
	public void setUp() {
		//org.apache.log4j.BasicConfigurator.configure();
		if(driver== null) {
			try {
				fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded!!!");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("Config file loaded!!!");
			} catch (IOException e) {
				e.printStackTrace();
			}	
			
			if(config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", config.getProperty("Geckofriver_path"));
				driver = new FirefoxDriver();
				log.debug("FireFox Opened!!!");
			}
			else if(config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", config.getProperty("Chromewebdriver_path"));
				ChromeOptions chrome = new ChromeOptions();
				chrome.addArguments("disable-infobars");
				chrome.addArguments("--start-maximized");
				chrome.addArguments("--disable-notifications");
				chrome.addArguments("--disable-extenstions");
				driver = new ChromeDriver(chrome);
				log.debug("Chrome Opened!!!");
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
				driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
			}				
			else if(config.getProperty("browser").equals("opera")) {
				System.setProperty("webdriver.chrome.driver", config.getProperty("Opera_path"));
				OperaOptions opera = new OperaOptions();
				opera.addArguments("--disable-infobars");
				opera.addArguments("--start-maximized");
				opera.setBinary(config.getProperty("binery_opera"));
				driver = new OperaDriver(opera);
				log.debug("Opera Opened!!!");
			}
			else if(config.getProperty("browser").equals("ie")) {
				System.setProperty("webdriver.chrome.driver", config.getProperty("IEServer_path"));
				
			}
			else {
				driver = new ChromeDriver();
			}
			
			driver.get(OR.getProperty("testsiteurl"));
			log.debug("Navigae to :" + OR.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt((config.getProperty("implicityTime"))), TimeUnit.SECONDS);
			wait = new WebDriverWait(driver , 5);
			
		}
	}
	
	public boolean isElementPresent(By cssSelector) {
		
		try {
			driver.findElement(cssSelector);
			return true;
		}
		catch(NoSuchElementException e)  {
			return false;
		}		
		

	}
	
	//@AfterMethod(alwaysRun = true)
	/*public static void takeScreenShot(ITestResult result) {
			if(!result.isSuccess()) {
				String a = result.getMethod().getMethodName().toString();
				try {
					if (new File(a).exists()) {
						a = String.format(result.getMethod().getMethodName().toString() + "%d", b++);
						captureScreenshot(driver, a);
					} else {
						captureScreenshot(driver, a);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	

		}
			else {
				String a = result.getMethod().getMethodName().toString();
				captureScreenshot(driver, a);
			}
	}
	
	
	
	public static void captureScreenshot(WebDriver driver, String screenshotName ) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("D:\\Selenium\\Screens" + "\\" + screenshotName	+ ".png"));
			String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
			System.setProperty(ESCAPE_PROPERTY, "false");
			String path = "D:\\Selenium\\Screens" + "\\" + screenshotName
					 + ".png";
			String test = "<a target=\"_blank\" href=\\" +  path + "\\><img src=\\" + path + "\\" + " height=200 width=200>click to open screenshot of "
					+ screenshotName + "</a>";
			Reporter.log("TEST CASE");
			Reporter.log(screenshotName + test + "<br>");
			Reporter.log("<br>");			
			
		}

		catch (Exception e) {
			System.out.println("Exception while taking screenshot "
					+ e.getMessage());
		}
		
	}*/
	
	public String ScrShot(ITestResult result) {
		String a = result.getMethod().getMethodName().toString();
		return captureScreenshot(driver, a);
	}
	
	public static String captureScreenshot(WebDriver driver, String screenshotName ) {
		String path = null;
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
		return path;
		
	}
	

	@AfterSuite
	public void tearDown() throws IOException {
		
		if(driver!=null) {
			if (config.getProperty("browser").equalsIgnoreCase("Opera")) {
				Runtime.getRuntime().exec("taskkill /f /im opera.exe");
				log.debug("Closed Opera");
				driver.quit();
			}
			driver.quit();
		}
		
	}
	
	public static TestBase getInstance(){
		if(instance  == null)
		{
			instance  = new TestBase();
		}
		return instance ;
	}

}
