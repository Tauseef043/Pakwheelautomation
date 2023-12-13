package Vehicle.Automation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.HeaderPageOB;
import POM.HomePage;
import resources.CustomCommands;
import resources.base;
import resources.dataProviderClass;

public class HomePageTests2 extends base {
	private CustomCommands comand;
	private HomePage hp;
	private HeaderPageOB headerPG;
	private static Logger log = (Logger) LogManager.getLogger();
	@BeforeTest
	public void initialization() throws IOException {
	
		driver = initializeDriver();
		driver.manage().deleteAllCookies();

		driver.get(prop.getProperty("baseURL"));
		driver.manage().window().maximize();
		 
	}

	@BeforeMethod
	public void waitMethod() throws IOException {
		
		hp = new HomePage(driver);
		headerPG = new HeaderPageOB(driver);
		comand = new CustomCommands();
//		 comand.ImlicitWait(driver);

	}

	
	
	
	@Test
	public void log4js()
	{
		log.info("this is informations");
	}
	
	
//	 public class TestAnnotationDataProvider {
//		   
//		  @Test(dataProviderClass = dataProviderClass.class, dataProvider = "data-provider-PakwheelProducts")		  
////		    @Test(dataProvider = "data-provider")
//		    public void testMethod(String data) {
//		        System.out.println("Data is: " + data);
//		    }
//
//	 }
}
