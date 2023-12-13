package Vehicle.Automation;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM.HeaderPageOB;
import POM.HomePage;
import jdk.internal.org.jline.utils.Log;
import resources.CustomCommands;
import resources.base;
import resources.dataProviderClass;

public class HomePageTests extends base {
	private CustomCommands comand;
	private HomePage hp;
	private HeaderPageOB headerPG;
	private Logger log;
	@BeforeTest
	public void initialization() throws IOException {
		 log = (Logger) LogManager.getLogger();
		driver = initializeDriver();

		driver.get(prop.getProperty("baseURL"));

	}

	@BeforeMethod
	public void waitMethod() throws IOException {

		hp = new HomePage(driver);
		headerPG = new HeaderPageOB(driver);
		comand = new CustomCommands();

		comand.ImlicitWait(driver);
//		Log.info("redirecting to URL");
	}

//	@Test(priority = 1)
//	public void SubscribeNewsLetterCancel() {
//		if(driver.findElement(By.id("om-lightbox-modern-optin-wrap")).isDisplayed()) {
//			
//			driver.findElement(By.xpath("//div[@id='om-lightbox-modern-optin-wrap']/div[1]")).click();
//		}
//		else
//			System.out.println("Testt");
//	}
	@Test(priority = 2)
	public void mainLogoVisibility() throws InterruptedException {
		
		log.info("VIsibity verifeid");
		Assert.assertTrue(headerPG.mainLogoIMG().isDisplayed());
		
	}

//	@Test(priority = 3)
//	public void DownloadAppBtn() {
//		headerPG.downlaodAppBtn().click();
//		
//
//		if(headerPG.downlaodAppPopup().isDisplayed())
//		{
//			headerPG.downlaodAppBtn().sendKeys(Keys.ENTER);
//		}
//		else {
//			System.out.println("Download buttons is not visible");
//		}
//	}
//	@Test(priority = 4)
//	public void urduLanguageBtn() throws IOException
//	{
//		if(headerPG.urduBtn().isDisplayed()) {
//			headerPG.urduBtn().click();
//			
//			comand.webPageVarication(driver.getCurrentUrl(),"urduLandingPageURL");
//			
//			driver.navigate().back();
//		}
//		else {
////		
//		Assert.assertTrue(headerPG.urduBtn().isDisplayed());
//		}
//		
//	}
	@Test(priority = 5)
	public void main_banner_text_verification() throws IOException {

		// text 1 verification
		Assert.assertEquals(hp.mainBannerTxt1().getText().toString().toLowerCase(),
				prop.getProperty("mainBanner_text1").toLowerCase());
		// text 2 verification
		Assert.assertEquals(hp.mainBannerTxt2().getText().toString().toLowerCase(),
				prop.getProperty("mainBanner_text2").toLowerCase());

	}

	@Test(priority = 6)
	public void search_query_test() throws IOException {

		// enter car model
		hp.searchEnterModels().sendKeys("Honda");
//		hp.searchEnterModels().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);

		// select city
//		

		hp.search_selectCityDropDown().click();
		hp.search_selectCityDropDownInputField().sendKeys("Lahore");
		hp.search_selectCityDropDownInputField().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		// select price range filter

		// select price range filter
//	
		hp.search_priceRange_FIlter().click();
		hp.search_priceRange_Min().sendKeys("20");
		hp.search_priceRange_Max().sendKeys("80");
//	
//	//search
//	
		hp.searchBtn().click();

//	Validations

		comand.ContainsTextAssertion(driver.getTitle(), titleprop.getProperty("searchPage"));
//	verify url
		comand.ContainsTextAssertion(driver.getCurrentUrl(), titleprop.getProperty("searchURl"));

		driver.navigate().back();

	}

//@Test(priority=7)	
//public void verify_categriesButtons() throws InterruptedException
//{
//	int i = 0, sum = 0;
//	String[] categoriesList = { "automaticCar", "familyCar", "bigCar", "smallCar", "importedCar", "oldCar","1300Car","10000Car","lowPriceCar","lowMilage","660Car","JapaneseCar" };
//
//	Actions act = new Actions(driver);
//	Set<String> windows = driver.getWindowHandles();
//	Iterator<String> it = windows.iterator();
//
//	for (WebElement button : hp.categoryBtns()) {
//		
//		System.out.println(button.getText().toString());
//		act.keyDown(Keys.CONTROL).click(button).keyUp(Keys.CONTROL).perform();
//	i++;
//		
////	Validations
//
//	
//	}
//	System.out.println(i);
//	String mainWindowHandle = driver.getWindowHandle();
//	Set<String> handles = driver.getWindowHandles();
//	for (String handle : handles) {
//		
//	
//		driver.switchTo().window(handle);
//		Thread.sleep(2000);
//		
//	
//			System.out.println("title : " + driver.getTitle());
//			if(!driver.getTitle().equals("Buy & Sell Cars, Bikes & Autoparts - Find Car Prices, News & Reviews | PakWheels"))
//			{
////				Assert.assertEquals(driver.getTitle(), titleprop.getProperty(categoriesList[i-1]));
//				i--;
//			}
//					
//			if(!handles.equals(mainWindowHandle))
//			{
//			driver.close();
//			}			
//						
//		
//	
//		
//
//	}
//
//}
	@Test(priority = 8)
	public void pakWheelsProduct_ButtonTXT_Verifications() {
		scrollDOwnToElement(hp.exploreProductTitleTXT());
		if(headerPG.newsLetter_cancelBTN().isDisplayed())
		{
			headerPG.newsLetter_cancelBTN().click();
		}
		int i = 0;
		String[] pName = { "PakWheels Certified Cars", "PakWheels Car Inspection", "Auction Sheet Verification",
				"PakWheels Sell It For Me", "Car Finance", "Car Insurance", "Pakwheels Partner Workshop",
				"Car Registration", "Car Ownership Transfer" };

		Actions act = new Actions(driver);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		for (WebElement button : hp.paksWheelsProductsBTnTXT()) {
			System.out.println(button.getText().toString());
			Assert.assertEquals(button.getText().toString().toLowerCase(), pName[i].toLowerCase());
			i++;
			
}
//		act.keyDown(Keys.CONTROL).click(button).keyUp(Keys.CONTROL).perform();

		
		
		
	}
	
	@Test(priority = 9)
	public void pakWheelsProduct_Button_Verifications() throws InterruptedException {
		Thread.sleep(3000);
//		scrollDOwnToElement(hp.exploreProductTitleTXT());
//		if(headerPG.newsLetter_cancelBTN().isDisplayed())
//		{
//			headerPG.newsLetter_cancelBTN().click();
//		}
		for (WebElement button : hp.paksWheelsProductsBTn()) {

			if(button.getText().toString().equals("Car Inspection"))
				button.click();
			Thread.sleep(2000);
//		Assert.assertEquals("Car Inspection Service | Vehicle Inspection | PakWheels", driver.getTitle());
//		driver.navigate().back();
//		break;
		}
		
		
//		
//			if(button.getText().toString().contains("Car Inspection"))
//			{
//				
//			
//				button.click();
////			
//				if(driver.getTitle().contains(titleprop.getProperty("carInspectionTitle")))
//				{
//					Assert.assertEquals(true, true);
//				}
//				else {
//					Assert.assertEquals(false, true);
//				}
//				if(driver.getCurrentUrl().contains(titleprop.getProperty("carInspectionURL")))
//				{
//					Assert.assertEquals(true, true);
//				}
//				else {
//					Assert.assertEquals(false, true);
//				}
			}
			
		
//		act.keyDown(Keys.CONTROL).click(button).keyUp(Keys.CONTROL).perform();

//		}
		
	
	

}
