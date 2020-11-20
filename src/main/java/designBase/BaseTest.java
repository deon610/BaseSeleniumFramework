package designBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utility.DriverFactoryUtility;

public class BaseTest
{
	private WebDriver driver;

	@BeforeSuite
	public void initialize() throws IOException
	{
		DriverFactoryUtility driverFactory = new DriverFactoryUtility();
		driver=driverFactory.getDriver();
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

	public WebDriver getDriver()
	{
		return driver;
	}
}
