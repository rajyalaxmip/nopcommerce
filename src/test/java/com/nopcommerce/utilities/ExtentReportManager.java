package com.nopcommerce.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	
	
	@Override
	public void onStart(ITestContext context) 
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName="Test-Report-"+timeStamp+".html";
		
		
		htmlReporter=new ExtentHtmlReporter(".\\reports\\"+repName);
		htmlReporter.config().setDocumentTitle("nopCommerce Automation Report");
		htmlReporter.config().setReportName("nopCommerce testing");
		htmlReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Environ", "QA");
		extent.setSystemInfo("user", "puli");
		extent.setSystemInfo("os", "window 10");
		
	}	


	@Override
	public void onTestSuccess(ITestResult result) {
		test=  extent.createTest(result.getTestContext().getName());
		test.createNode(result.getName());
		test.log(Status.PASS, "Test case is Passed:" + result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		test=  extent.createTest(result.getTestContext().getName());
		test.createNode(result.getName()); // create new entry in th report
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
					
		String screenshotPath=System.getProperty("user.dir")+"\\screenshots\\"+result.getName()+".png";
		try {
			test.addScreenCaptureFromPath(screenshotPath);// adding screen shot	
		} catch (IOException e) {
				e.printStackTrace();
		} 
	}


	@Override
	public void onTestSkipped(ITestResult result) 
	{
		test=  extent.createTest(result.getTestContext().getName());
		test.createNode(result.getName());
		test.log(Status.SKIP, "Test case is Skipped:" + result.getName());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		//empty
		
	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		//EMPTY
		
	}


}
 
