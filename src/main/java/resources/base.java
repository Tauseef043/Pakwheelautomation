package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;

public class base {
	
	public Logger log;
	public WebDriver driver;
	public Properties prop, titleprop;
	FileInputStream fis, tiltefis;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions(); // for headless runing browser open nai hoga

//			options.addExtensions(
//					new File(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\addbloker.crx")); // Replace
//																													// with
																													// the
																													// actual
																													// path

			options.addArguments("window-size=1366,768");

			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			// execute browser

			driver = new ChromeDriver(options);
		} else if (browserName.contains("firefox")) {

		} else if (browserName.contains("IE")) {

			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		titleprop = new Properties();
		tiltefis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\pageTitles.properties");

		titleprop.load(tiltefis);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}

	public void scrollUpToElement(WebElement element) {
		// Create a JavascriptExecutor object
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll to the element
		js.executeScript("arguments[0].scrollIntoView(flase);", element);

	}
	public void scrollDOwnToElement(WebElement element) {
		// Create a JavascriptExecutor object
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll to the element
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

}
