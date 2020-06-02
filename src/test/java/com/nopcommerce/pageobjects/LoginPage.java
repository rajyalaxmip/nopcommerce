package com.nopcommerce.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	 WebDriver driver;
	 //locators
	 @FindBy(id="Email") 
	 @CacheLookup
	 WebElement txtEmail;
	 
	 @FindBy(id="Password")
	 WebElement txtPassword;
	 
	 @FindBy(xpath="//input[@class='button-1 login-button']")
	 WebElement btnlogin;
	 
	 @FindBy(linkText ="Logout")
	 WebElement lnklogout;
	 
	public  LoginPage(WebDriver driver)
	 {
		this.driver= driver; 
		PageFactory.initElements(driver, this);
	 }
	 
	 
	public void setUsername(String uname)
	{
		txtEmail.clear(); 
		txtEmail.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		txtPassword.clear(); 
		txtPassword.sendKeys(pwd);
	}
	 
	public void clickLogin()
	{
		btnlogin.click();
	} 
	
	public void clickLogOut()
	{
		lnklogout.click();
	}


	


}
