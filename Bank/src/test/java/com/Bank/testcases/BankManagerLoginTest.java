package com.Bank.testcases;

import org.testng.annotations.Test;
import com.Bank.base.TestBase;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;



public class BankManagerLoginTest extends TestBase{
	
	@Test(priority = 0)
	public void loginAsBankManager() throws InterruptedException {
		log.debug("Inside Login Test");
		driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		
		AssertJUnit.assertTrue("Login is not successfull", isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))));
		
		log.debug("Successfully executed");
		
	}

}


