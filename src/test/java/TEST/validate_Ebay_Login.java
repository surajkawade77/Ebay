package TEST;

import org.testng.annotations.Test;

import Base_EBay.Ebay_Base_Class;
import POM_.Ebay_HomePage;
import POM_.Ebay_Utils;
import POM_.Passwrd_Page;
import POM_.UserID_Page;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.http.WebSocket.Listener;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class validate_Ebay_Login extends Ebay_Base_Class implements ITestListener
{
	 
	public void onTestFailure(ITestResult result) 
	{
				Reporter.log("TC failed please try again..", true);
	}
	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log("TC passed successfull.", true);
	              }
 
	Ebay_Utils util=new Ebay_Utils();
 
	@BeforeClass
	  public void beforeClass() throws InterruptedException
	{
		launchBrowserEbay();
		Thread.sleep(1000);
		Reporter.log("BeforeClass is Running",true);
		
		
		
	  }
  @BeforeMethod
  public void beforeMethod() throws InterruptedException 
  {
	 
	  Ebay_HomePage home= new  Ebay_HomePage(driver);
	  UserID_Page usrid=new UserID_Page(driver);
	  Passwrd_Page psswrd=new Passwrd_Page(driver);
	  
	  home.clickOnSigninLink(driver);
	  Thread.sleep(1000);
	  usrid.Enteruserid(driver);
	  Thread.sleep(1000);
	  usrid.clickOncontinuebutton(driver);
	  Thread.sleep(1000);
	  psswrd.EnterPasswrd(driver);
	  Thread.sleep(1000);
	  psswrd.clickOnSignInButton(driver);
	  Thread.sleep(1000);
  }

  @Test
  public void ValidateLogin() throws InterruptedException 
  {
	  WebElement username = driver.findElement(By.xpath("//b[text()='Suraj']"));
		
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.moveToElement(username).perform();
		
		String actualuser = username.getText();
		
		String expecteduser = "Suraj";
		Reporter.log("TC is Running", true);
		Assert.assertEquals(actualuser, expecteduser, "TC Failed");
		Reporter.log("Actual&Expected matching TC passed", true);
	  
  }
  @AfterMethod
  public void logout() throws InterruptedException
  {
	 WebElement userbutton = driver.findElement(By.xpath("//button[@role='button']"));
	  Actions act=new Actions(driver);
	  act.moveToElement(userbutton);
	  
	  Thread.sleep(1000);
	   WebElement signoutlink=driver.findElement(By.xpath("//a[text()='Sign out']"));
	   signoutlink.click();
	   Thread.sleep(1000);
	   Reporter.log("After method class is Running", true);
	   
	   Reporter.log("LogOut Successfull", true);
	   
  }
  @AfterClass
  public void CloseBrowser()
  {
	  Ebay_Utils util=new Ebay_Utils();
	  util.wait(driver, 1000);
	  driver.close();
	  
  }
  
  

}
