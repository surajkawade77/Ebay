package POM_;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserID_Page 
{
	@FindBy(css = "input#userid") private WebElement userid;
	@FindBy(css = "button#signin-continue-btn")private WebElement continuebutton;
	
	public UserID_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void Enteruserid(WebDriver driver)
	{
		userid.sendKeys("surajkawade9477@gmail.com");
	}
	public void clickOncontinuebutton(WebDriver driver)
	{
		continuebutton.click();
	}
}
