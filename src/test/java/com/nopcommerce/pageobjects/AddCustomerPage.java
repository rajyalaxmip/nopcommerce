package com.nopcommerce.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	WebDriver ldriver ;
	WebElement listitem;
	
	public AddCustomerPage(WebDriver rDriver)
	{
		this.ldriver = rDriver;
	}
	
	By lnkCustomer_menu = By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
	By lnkCustomer_menuItem = By.xpath("/html/body/div[3]/div[2]/div/ul/li[4]/ul/li[1]/a/span"); 
	
	By btnAddnew = By.xpath("//a[@class='btn bg-blue']");//Add new
	
	By txtEmail = By.name("Email");
	By txtPassword = By.xpath("//input[@id ='Password'] ");
	
	By txtFirstName = By.name("FirstName");
	By txtLastName = By.name("LastName");
	By rdMaleGender = By.id("Gender_Male");
	By rdFemaleGender = By.id("Gender_Female"); 
	By txtDob = By.id("DateOfBirth");
	By txtCompanyName = By.id("Company");
	By cbIsTaxExempt = By.id("IsTaxExempt");
	
	By txtCutomerRoles =By.xpath("//div[ @class ='k-multiselect-wrap k-floatwrap']" );
	
	By lstitemAdministrators = By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemRegistered = By.xpath("//li[contains(text(),'Registered')]");	
	By lstitemGuests = By.xpath("//li[contains(text(),'Guests')]");
	By lstitemVendors = By.xpath("//li[contains(text(),'Vendors')]");
	
	By drpmgrOfVendor =By.xpath("//*[@id ='VendorId']");
	By txtAdminContent = By.xpath("//textarea[@id='AdminComment']");
	By btnSave = By.xpath("//button[@name='save']");
	
	By txtmsg=By.xpath("//div[@class='alert alert-success alert-dismissable']");

	
 	public void clickCustomerMenu() {
		ldriver.findElement(lnkCustomer_menu).click();
	}
	
	public void clickCustomerMenuItem() {
		ldriver.findElement(lnkCustomer_menuItem).click();
		
	}
	public void clickOnAddnew() {
		ldriver.findElement(btnAddnew).click();		
	}
	
	public void setEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		ldriver.findElement(txtPassword).sendKeys(password);
	}	
	
	
	public void setFirstName(String fname)
	{
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		ldriver.findElement(txtLastName).sendKeys(lname);
	}
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(rdMaleGender).click();
		}
		else if(gender.equals("Female"))
		{
			ldriver.findElement(rdMaleGender).click();
		}
		else
		{
			ldriver.findElement(rdMaleGender).click();//Default
		}		
	}
	
	public void setDob(String dob)
	{
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	
	public void setCompanyName(String comname)
	{
		ldriver.findElement(txtCompanyName).sendKeys(comname);
	}
	public void setCustomerRoles(String role) throws InterruptedException 
	{
		//ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
	
		ldriver.findElement(txtCutomerRoles).click();
					
		
		Thread.sleep(3000);
		
		/*switch(role)
		{
		case "Administrators":
				listitem=ldriver.findElement(lstitemAdministrators); break;
		case "Guests":
				listitem=ldriver.findElement(lstitemGuests); break;
		case "Registered":
			listitem=ldriver.findElement(lstitemRegistered); break;
		case "Vendors":
			listitem=ldriver.findElement(lstitemVendors); break;
		default:
			listitem=ldriver.findElement(lstitemGuests);
		}*/
					
		if (role.equals("Registered"))
		{
		listitem =ldriver.findElement(lstitemRegistered);
		}
		else if (role.equals("Administrators")) 
		{
			listitem=ldriver.findElement(lstitemAdministrators);
		}
		else if (role.equals("Vendors")) 
		{
			listitem=ldriver.findElement(lstitemVendors);
		}
		else if (role.equals("Guests")) 
		{
			listitem=ldriver.findElement(lstitemGuests);
		}
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
       js.executeScript("arguments[0].click", listitem)	;	
		
}

public void setManagerOfVendor(String value)
{
	Select drp=new Select(ldriver.findElement(drpmgrOfVendor));
	drp.selectByVisibleText(value);
}
  
	public void setAdminContent(String content)
	{
		ldriver.findElement(txtAdminContent).sendKeys(content);
	}
	
	public void clickOnSave()
	{
		ldriver.findElement(btnSave).click();
	}
	
	public boolean verifyConfirmationMsg()
	{
		String msg=ldriver.findElement(txtmsg).getText();
		if (msg.contains("The new customer has been added successfully"))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	
	
}
	



