package com.nopcommerce.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageobjects.AddCustomerPage;
import com.nopcommerce.pageobjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test	
	public void addnewCustomer() throws InterruptedException, IOException
	{
		logger.info("******starting TC_AddCustomerTest_003*******" );		
		driver.get(configProObj.getProperty("baseURL"));
	     LoginPage lp = new LoginPage(driver);
	     lp.setUsername(configProObj.getProperty("useremail"));
	     lp.setPassword(configProObj.getProperty("password"));
	     lp.clickLogin();
	     Thread.sleep(3000);
	    	
     logger.info("******Adding New Customer*******" );
     
     AddCustomerPage addCust = new AddCustomerPage(driver);
     addCust.clickCustomerMenu();
     addCust.clickCustomerMenuItem();
     addCust.clickOnAddnew();
     Thread.sleep(3000);
     
     logger.info("******Providing  Customer Details*******" );
     
     String email = randonString()+"@gmail.com";
     addCust.setEmail(email);
     addCust.setPassword("test123");
		addCust.setFirstName("Pavan");
		addCust.setLastName("Kumar");
		addCust.setGender("Male");
		addCust.setDob("7/05/1985"); // Format: MM/DD/YYY
		addCust.setCompanyName("busyQA");
		addCust.setCustomerRoles("Vendors");
		addCust.setCustomerRoles("Registered");
		Thread.sleep(3000);
		addCust.setManagerOfVendor("Vendor 2");
		addCust.setAdminContent("This is for testing.........");
		addCust.clickOnSave();
		Thread.sleep(3000);
//validation
		if (addCust.verifyConfirmationMsg()) 
		{
			logger.info("Customer Added successfully");
		  Assert.assertTrue(true);			
		}
		else
		{
			logger.info("Customer not Added successfully");
			 Assert.assertTrue(false);
			 captureScreen(driver, "addNewCustomer");			
		}
     
		logger.info("******TC_AddCustomerTest_003 Finished*******" );   
     
	}
}
