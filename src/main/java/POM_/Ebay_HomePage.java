package POM_;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ebay_HomePage 
{
	
	@FindBy(xpath = "(//a[text()='Sign in'])[1]") private WebElement signinlink;
	
	
	public Ebay_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnSigninLink(WebDriver driver) throws InterruptedException
	{
		signinlink.click();
		Thread.sleep(2000);
	}
	
	

}
