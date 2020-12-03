package designBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utility.DriverFactoryUtility;

public class BaseTest
{
	private static WebDriver driver;
	private static final Logger LOG = LoggerFactory.getLogger(DriverFactoryUtility.class);

	@BeforeSuite
	/**
	 * This method is used to initialize the instance of Driver
	 * and set up waits for the page elements and page loading
	 * @throws IOException
	 */
	public void initialize() throws IOException
	{
		DriverFactoryUtility driverFactory = new DriverFactoryUtility();
		LOG.info("Driver Initialized");
		driver=driverFactory.getDriver();
		LOG.info("Driver Initialized");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterSuite
	public void terminate()
	{
		if (driver != null)
		{
			driver.close();
			driver.quit();
		}
	}
	
	/**
	 * Returning a driver instance in order to take screenshots
	 * @return
	 */
	public static WebDriver getDriverForScreenShot()
	{
		final WebDriver augmentedDriver = new Augmenter().augment(driver);
		return augmentedDriver;
	}

	public WebDriver getDriver()
	{
		return driver;
	}
}
