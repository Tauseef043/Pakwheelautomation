package POM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.CustomCommands;

public class HeaderPageOB {
	public WebDriver driver;

private By mainLogo=By.xpath("//div[@class='navbar-header']/a[1]/img");
private By downloadAppPopup=By.xpath("//div[@class='mt20']");
private By downloadAppBtn=By.xpath("//a[@class='pull-left btn-mini-app']");
private By urduBtn=By.className("urdu-img");
private By newsLetter_cancelBTN=By.xpath("//button[@id='onesignal-slidedown-cancel-button']");
	public HeaderPageOB(WebDriver driver) throws IOException
	{
		
		 
		 
		this.driver=driver;
		
	}
public WebElement mainLogoIMG() {
	return driver.findElement(mainLogo);
}


public WebElement downlaodAppBtn() {
	return driver.findElement(downloadAppBtn);
}
public WebElement downlaodAppPopup() {
	return driver.findElement(downloadAppPopup);
}

public WebElement urduBtn() {
	return driver.findElement(urduBtn);
}

public WebElement newsLetter_cancelBTN() {
	return driver.findElement(newsLetter_cancelBTN);
}


}
