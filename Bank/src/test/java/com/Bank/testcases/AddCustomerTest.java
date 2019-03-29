package com.Bank.testcases;

import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import com.Bank.base.TestBase;

public class AddCustomerTest extends TestBase{
	
	@Test(priority = 1,dataProvider="getData")
	public void addCustomer(String firstname, String lastname, String postcode,String alerttext) throws InterruptedException {
		
		log.debug("inside AddCustomer Test");
		driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();		
		driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(firstname);
		driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(lastname);
		driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(postcode);
		driver.findElement(By.cssSelector(OR.getProperty("addBtn"))).click();
		
		 Alert alert =wait.until(ExpectedConditions.alertIsPresent());
		 
		 Assert.assertTrue(alert.getText().contains(alerttext));
		 
		 alert.accept();		 

	}
	
	@DataProvider
	public Object[][] getData() throws IOException {

		String sheetName = "AddCustomerTest";
		int rows = excel.getRowCount(sheetName)+1;
		int cols = excel.getColomnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {// 2
			for (int colNum = 0; colNum < cols; colNum++) {
				// data[0][0]
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
				// -2
			}

		}

		return data;

	}
	
}
