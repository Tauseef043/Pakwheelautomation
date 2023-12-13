package POM;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public WebDriver driver;

	private By mainbannerTxt1=By.xpath("//div[@id='main-container']/section[2]/div/h1");
	private By mainbannerTxt2=By.xpath("//div[@id='main-container']/section[2]/div/p");
	private By searchEnterModel=By.id("home-query");
	private By search_selectCityDropDown=By.xpath("//li[@class='home-chzn']");
	private By search_selectCityDropDownInputField=By.xpath("//div[@id='UsedCity_chzn']/div/div/input");

	private By search_selectCityDropDownInput_noResult=By.xpath("//div[@class='no-results']");
	private By search_priceRange_FIlter=By.id("pr-range-filter");
	private By search_priceRange_Min=By.id("pr_from");
	private By search_priceRange_Max=By.id("pr_to");
	private By searchBtn=By.id("home-search-btn");
	
	private By categoryBtns=By.xpath("//div[@id='browesCTGSlider']/div[1]/ul[1]/li");
	private By categoryTxt=By.xpath("//h2[normalize-space()='Browse Used Cars']");
	
	private By paksWheelsProductsBTnTXT=By.xpath("//div[@class='row our-product-widget']/div/a/div[2]/h3");
	private By paksWheelsProductsBTn=By.xpath("//div[@class='row our-product-widget']/div/a");

	private By exploreProductTitleTXT=By.xpath("//h2[normalize-space()='Explore Products by PakWheels']");

	
	
	
	
	
	
	public HomePage(WebDriver driver) throws IOException
	{
		
		 
		 
		this.driver=driver;
		
	}
	public WebElement mainBannerTxt1()
	{
		return driver.findElement(mainbannerTxt1);
	}
	public WebElement mainBannerTxt2()
	{
		return driver.findElement(mainbannerTxt2);
	}
	public WebElement searchEnterModels()
	{
		return driver.findElement(searchEnterModel);
	}
	public WebElement search_selectCityDropDown()
	{
		return driver.findElement(search_selectCityDropDown);
	}
	public WebElement search_priceRange_FIlter()
	{
		return driver.findElement(search_priceRange_FIlter);
	}
	public WebElement searchBtn()
	{
		return driver.findElement(searchBtn);
	}
	public WebElement search_selectCityDropDownInputField()
	{
		return driver.findElement(search_selectCityDropDownInputField);
	}
	public WebElement search_priceRange_Min()
	{
		return driver.findElement(search_priceRange_Min);
	}
	public WebElement search_priceRange_Max()
	{
		return driver.findElement(search_priceRange_Max);
	}
	public WebElement search_selectCityDropDownInput_noResult()
	{
		return driver.findElement(search_selectCityDropDownInput_noResult);
	}
	public List<WebElement> categoryBtns() {
		
		return driver.findElements(categoryBtns);
	}
	public WebElement categoryTxt()
	{
		return driver.findElement(categoryTxt);
	}
	public List<WebElement> paksWheelsProductsBTnTXT()
	{
		return driver.findElements(paksWheelsProductsBTnTXT);
	}
	public List<WebElement> paksWheelsProductsBTn()
	{
		return driver.findElements(paksWheelsProductsBTn);
	}
	public WebElement exploreProductTitleTXT() {
		return driver.findElement(exploreProductTitleTXT);
	}
	
}
