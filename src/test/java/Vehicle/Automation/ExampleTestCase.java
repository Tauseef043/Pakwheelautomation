package Vehicle.Automation;

import java.io.Console;
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

public class ExampleTestCase extends base {

	@BeforeTest
	public void initialization() throws IOException {
	
		driver = initializeDriver();
		driver.manage().deleteAllCookies();

		
		driver.manage().window().maximize();
		 
	}

	@BeforeMethod
	public void waitMethod() throws IOException {
		
		
//		 comand.ImlicitWait(driver);

	}

	
	
	
	@Test
	public void log4js()
	{
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.xpath("//div[@class='container']//div[1]//div[1]//div[1]//button[1]")).click();
	}
	
	
}
