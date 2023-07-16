package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

}
