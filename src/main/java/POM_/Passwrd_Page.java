package POM_;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Passwrd_Page 
{
	@FindBy(css = "input#pass")private WebElement passwrd;
	@FindBy(css = "button#sgnBt")private WebElement signinbttn;
	
	
	public Passwrd_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void EnterPasswrd(WebDriver driver)
	{
		passwrd.sendKeys("suraj007");
	}
	
	public void clickOnSignInButton(WebDriver driver)
	{
		signinbttn.click();
	}

}
