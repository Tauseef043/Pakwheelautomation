package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CustomCommands extends base {

	protected Properties propp;
	private FileInputStream fiss;
	
	

	
	public void ImlicitWait(WebDriver driverr) {
		driverr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void buttonClick(WebElement element)
	{

		Assert.assertTrue(element.isDisplayed());
	element.click();
	}
	public void webPageVarication(String CurretURL,String ActualURL) throws IOException
	{
		propp = new Properties();
		 fiss = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\pageTitles.properties");

			propp.load(fiss);
			
			
			 Assert.assertEquals(CurretURL,propp.getProperty(ActualURL) );

	}
	public void textVerification(String currentText,String validText)
	{
		

			 Assert.assertEquals(currentText,validText);
	
	
			 
	}
	public void ContainsTextAssertion(String currentText,String validText) {
		
		
		Assert.assertTrue(validText.toLowerCase().contains(validText.toLowerCase()));
	}

	public void explicitWaitFOrELement(int seconds, WebElement element)
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		  wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
		 
	}
	
	

}
