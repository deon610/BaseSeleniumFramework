package utility;

import java.io.File;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is used to initialize the WebDriver
 * 
 * @author deon6
 *
 */
public class DriverFactoryUtility
{
	private static final Logger LOG = LoggerFactory.getLogger(DriverFactoryUtility.class);

	// private final static String IE_DRIVER_PATH =
	// PropertyUtility.getProperty("webdriver.ie.driver", null);
	private final static String CHROME_DRIVER_PATH = getPath(
			PropertyUtility.getProperty("webdriver.chrome.driver", null));
	private final static String GECKO_DRIVER_PATH = getPath(
			PropertyUtility.getProperty("webdriver.gecko.driver", null));

	/**
	 * This method sets the driver based on the 'browser' specified in
	 * config.properties file
	 * 
	 * @return	driver which is used across the framework
	 */
	public WebDriver getDriver()
	{
		WebDriver driver = null;
		String browserName = PropertyUtility.getProperty("browser");
		if (browserName.equals("Chrome"))
		{
			String chromeDriverPath = CHROME_DRIVER_PATH;
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
		} else if (browserName.equals("Chrome-headless"))
		{
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			driver = new ChromeDriver();
			String chromeDriverPath = CHROME_DRIVER_PATH;
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
		} else if (browserName.equals("FireFox"))
		{
			String fireFoxPath = GECKO_DRIVER_PATH;
			System.setProperty("webdriver.gecko.driver", fireFoxPath);
			driver = new FirefoxDriver();
		}
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		LOG.info("Browser : {}", cap.getBrowserName().toLowerCase());
		LOG.info("Version : {}",cap.getVersion().toLowerCase());
		LOG.info("OS: {}",cap.getPlatform().name().toString());
		return driver;
	}

	/**
	 * The method is used to get the absolute path of the application
	 * 
	 * @param appRelativePath
	 * @return
	 */
	private static String getPath(String appRelativePath)
	{
		File file = null;
		try
		{
			file = new File(appRelativePath);

		} catch (Exception e)
		{
			LOG.error("Path not found: {}",e);
		}
		return file.getAbsolutePath();
	}
}
