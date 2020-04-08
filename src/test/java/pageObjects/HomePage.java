package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import designBase.BasePage;

public class HomePage  extends BasePage
{
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.XPATH, using ="//input[@title='Search']")
	private WebElement googleSearch;
	
	public void SearchForText(String text) {
		driver.get("http://www.google.com");
		Actions action = new Actions(driver);
		action.sendKeys(text).sendKeys(Keys.ENTER).build().perform();
		
	}
}
