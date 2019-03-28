package com.Bank.testcases;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;



import com.Bank.base.TestBase;


public class BankManagerLoginTest extends TestBase{
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		//System.setProperty("org.uncommons.reportng.escape-output","false");
		log.debug("Inside Login Test");
		driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		//driver.findElement(By.xpath("//button[@ng-click='manager()']")).click();	
		
		
		AssertJUnit.assertTrue("Login is not successfull", isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))));
		
		log.debug("Successfully executed");
		
	}

}
