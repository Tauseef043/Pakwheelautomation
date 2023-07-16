package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public WebDriver driver;
	public Properties prop;
	

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions(); // for headless runing browser open nai hoga

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
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}


}
