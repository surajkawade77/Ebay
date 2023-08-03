package Base_EBay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

public class Ebay_Base_Class 
{
     protected WebDriver driver;
	public void launchBrowserEbay() throws InterruptedException
	{
  
		
		
	
		
		System.setProperty("webdriver.chrome.driver", "D:\\My Folder\\Suraj\\My Documents\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
        
		 driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		Reporter.log("launching Browser For Ebay", true);
		Thread.sleep(1000);
	}

}
