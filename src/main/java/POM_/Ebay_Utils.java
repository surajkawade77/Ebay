package POM_;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class Ebay_Utils 
{
	public static  String readDataFromExcel(int row, int cell) throws EncryptedDocumentException, IOException
	{
		File myfile = new File("D:\\My Folder\\Suraj\\NeoStox.xlsx");
		
		String value = WorkbookFactory.create(myfile).getSheet("Sheet1").getRow(row).getCell(cell).getStringCellValue();
				
		Reporter.log("reading data from excel", true);
		return value;
	}
	
	public static void screenshot(WebDriver driver,String screenShotName) throws IOException
	{
		wait(driver,500);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    File dest=new File("D:\\My Folder\\Suraj\\"+screenShotName+".png");
	    org.openqa.selenium.io.FileHandler.copy(src, dest);
	    Reporter.log("taking screenshot", true);
	}
	
	public static void scrollIntoView(WebDriver driver, WebElement element)
	{ 
	wait(driver, 500);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)", element);
	Reporter.log("SCrolling into view",true);
	}
	
	public static void wait(WebDriver driver, int waitTime)
	{
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
	Reporter.log("Waiting for "+waitTime+"ms",true);
	}

}
