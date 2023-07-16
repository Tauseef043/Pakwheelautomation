package Vehicle.Automation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM.HeaderPageOB;
import POM.HomePage;
import resources.CustomCommands;
import resources.base;

public class HomePageTests  extends base{
	private CustomCommands comand;
	private HomePage hp;
	private HeaderPageOB headerPG;
	@BeforeTest
	public void initialization() throws IOException {

		driver = initializeDriver();
		
		driver.get(prop.getProperty("baseURL"));
		
	}
	@BeforeMethod
	public void waitMethod() throws IOException {

		hp = new HomePage(driver);
		headerPG=new HeaderPageOB(driver);
		 comand=new CustomCommands();

//		 comand.ImlicitWait(driver);
		

	}
	@Test(priority = 1)
	public void SubscribeNewsLetterCancel() {
//		if(driver.findElement(By.id("om-lightbox-modern-optin-wrap")).isDisplayed()) {
//			
//			driver.findElement(By.xpath("//div[@id='om-lightbox-modern-optin-wrap']/div[1]")).click();
//		}
//		else
			System.out.println("Testt");
	}
	@Test(priority = 2)
	public void mainLogoVisibility() throws InterruptedException
	{
		Thread.sleep(3000);
		Assert.assertTrue(headerPG.mainLogoIMG().isDisplayed());
	}
	@Test(priority = 3)
	public void DownloadAppBtn() {
		headerPG.downlaodAppBtn().click();
		

		if(headerPG.downlaodAppPopup().isDisplayed())
		{
			headerPG.downlaodAppBtn().sendKeys(Keys.ENTER);
		}
	}
	@Test(priority = 4)
	public void urduLanguageBtn() throws IOException
	{
//		
		Assert.assertTrue(headerPG.urduBtn().isDisplayed());
		headerPG.urduBtn().click();
		
		comand.webPageVarication(driver.getCurrentUrl(),"urduLandingPageURL");
		
		driver.navigate().back();
	}
	@Test(priority =5)
	public void main_banner_text_verification() throws IOException
	{
	
		//text 1 verification
		Assert.assertEquals(hp.mainBannerTxt1().getText().toString().toLowerCase(),prop.getProperty("mainBanner_text1").toLowerCase());
		//		text 2 verification
		Assert.assertEquals(hp.mainBannerTxt2().getText().toString().toLowerCase(),prop.getProperty("mainBanner_text2").toLowerCase());
	
	}
	@Test(priority =6)
	public void search_query_test() throws IOException {
		
		//enter car model
		hp.searchFeild().sendKeys("honda");
		hp.searchFeild().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		
		//select city
		
		hp.search_selectCityDropDown().click();
		hp.search_selectCityDropDownInputField().sendKeys("lahore");
		if(hp.search_selectCityDropDownInput_noResult().getText().toString().toLowerCase().contains("No results matched"))
		{	
			hp.search_selectCityDropDown().click();
			
			
			}
	
	//select price range filter
//	
	hp.search_priceRange_FIlter().click();
	hp.search_priceRange_Min().sendKeys("20");
	hp.search_priceRange_Max().sendKeys("80");
	
	//search
	
	hp.searchBtn().click();
	
//	Validations
//	
	comand.webPageVarication(driver.getCurrentUrl(),prop.getProperty("searchURl"));
	comand.textVerification(driver.getTitle(), prop.getProperty("searchPage"));
	
//	
//	
		
		
		
	}
//		
	
}
