package com.nopcommerce.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageobjects.AddCustomerPage;
import com.nopcommerce.pageobjects.LoginPage;
import com.nopcommerce.pageobjects.SearchCustomerPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_SearchCustomer_004 extends BaseClass
  {
	@Test
	 public void searchCustomerByEmail() throws InterruptedException, IOException
	 {
		logger.info("******starting TC_SearchCustomer_004*******" );		
		driver.get(configProObj.getProperty("baseURL"));
	     LoginPage lp = new LoginPage(driver);
	     lp.setUsername(configProObj.getProperty("useremail"));
	     lp.setPassword(configProObj.getProperty("password"));
	     lp.clickLogin();
	     Thread.sleep(3000);
	     
	     AddCustomerPage addcust = new AddCustomerPage(driver);
	     addcust.clickCustomerMenu();
	     addcust.clickCustomerMenuItem();
	     
	     SearchCustomerPage searchcust = new SearchCustomerPage(driver);
	     searchcust.setEmail("victoria_victoria@nopCommerce.com");
	     searchcust.clickSearch();
	     Thread.sleep(3000);
	     
	   Boolean status= searchcust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
	   if (status==true) 
	   {
		   logger.info("***Search customer by email is passed****");
		   Assert.assertTrue(true);		
	    }
	   else {
		   logger.info("***Search customer by email is failed****");
		   captureScreen(driver, "searchCustomerByEmail");
		   Assert.assertTrue(false);
	     }	     
	   logger.info("*******TC_SearchCustomer_004 finished*********");   
	     
	   driver.close();  
	 }
  }
