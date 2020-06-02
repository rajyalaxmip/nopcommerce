package com.nopcommerce.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageobjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_LoginTest_001 extends BaseClass {	

	@Test
	public void loginTest () throws IOException
	{
		logger.info("*****Starting TC001*****");
		driver.get(configProObj.getProperty("baseURL"));
		
		logger.info("*****Providing login Details*****");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(configProObj.getProperty("useremail"));
		lp.setPassword(configProObj.getProperty("password"));
		lp.clickLogin();
		
		logger.info("*****Validating login Details*****");
		
		String exp_Title =("Dashboard / nopCommerce administration");
		String act_Title = driver.getTitle();
		if (exp_Title.equals(act_Title))
		{   logger.info("*****Login is successful*****");
			Assert.assertTrue(true);
			
		}
		else
		{  logger.error("*****Login is Failed*****");
		    captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
		}
		lp.clickLogOut();
		driver.close();
		
	}
	
 
}
