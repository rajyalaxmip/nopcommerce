package com.nopcommerce.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseClass {
	public WebDriver driver;
	public Properties configProObj;
	public Logger logger=LogManager.getLogger(this.getClass()); 
	
	@BeforeClass
	@Parameters("browser")
	   public void setUp(String br) throws IOException
	     {
		configProObj = new Properties();
		FileInputStream configFile = new FileInputStream(".\\resources\\config.properties");
		configProObj.load(configFile);
		
		if( br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if ( br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if ( br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.edge.driver", "F:/drivers/msedgedriver.exe");
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
			
	     }
	@AfterClass	
	void tearDown()
	{
		driver.close();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\screenshots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randonString()
	{
		String genetratedString1 = RandomStringUtils.randomNumeric(5);
		return genetratedString1;		
	}
	
	public int randonNum()
	{
		String genetratedString2 = RandomStringUtils.randomNumeric(5);
		return(Integer.parseInt(genetratedString2));		
	}
	
	


}
