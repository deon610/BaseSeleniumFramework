package tests;

import org.testng.annotations.Test;

import designBase.BaseTest;
import pageObjects.HomePage;

public class HomePageTest extends BaseTest 
{
	
	@Test
	public void GoogleSearch() throws InterruptedException {
		HomePage hp = new HomePage(getDriver());
		hp.SearchForText("Selenium framework design");
	}
	
}
