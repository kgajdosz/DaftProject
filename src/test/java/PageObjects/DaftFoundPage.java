package PageObjects;

import DriverManagement.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Log;

import java.util.List;
import java.util.Random;

public class DaftFoundPage {

	WebDriver driver = DriverManager.getWebDriver();
	WebDriverWait wait = new WebDriverWait(driver,10);
	 //constructor
	public DaftFoundPage() {
		// Accessing WebDriver from DriverManager.java
		PageFactory.initElements(DriverManager.getWebDriver(), this);
		wait.until(ExpectedConditions.visibilityOf(foundPanel));
		Log.info("Daft Found page");


	}
	// In the FindBy section there are accessors for the elements on the page
	@FindBy(id= "premier-partner-srp-panel")
	private WebElement foundPanel;

	@FindBy(xpath= "//*[contains(@data-testid, 'agent-branding-top')]")
	private List<WebElement> SearchedProperties;


	//getters
	public WebElement GetFoundPanel() {
		return foundPanel;
	}

	public int GetNumElementsFound() {
		return SearchedProperties.size();
	}

	public void clickRandomProperty(int size)
	{
		Random rn = new Random();
		int number = rn.nextInt(size);
		SearchedProperties.get(number).click(); // code need to be changed for selecting random add
	}

}
