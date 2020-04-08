package designBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest
{
	private WebDriver driver;

	@BeforeSuite
	public void initialize() throws IOException
	{
		String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
		String propertiesPath = currentPath + "\\src\\main\\java\\designBase\\data.properties";
		FileInputStream fis = new FileInputStream(propertiesPath);
		Properties prop = new Properties();
		String chromDriverPath = currentPath + "\\chromedriver.exe";
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver", chromDriverPath);
		String headless = prop.getProperty("headless");
		if (headless.equals("true"))
		{
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			driver = new ChromeDriver();
		} else
		{
			driver = new ChromeDriver();
		}
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
