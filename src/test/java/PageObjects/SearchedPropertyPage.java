package PageObjects;

import DriverManagement.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Log;

public class SearchedPropertyPage extends BaseObject{

	WebDriver driver = DriverManager.getWebDriver();
	WebDriverWait wait = new WebDriverWait(driver,10);
	 //constructor
	public SearchedPropertyPage() {
		// Accessing WebDriver from DriverManager.java
		PageFactory.initElements(DriverManager.getWebDriver(), this);
		wait.until(ExpectedConditions.visibilityOf(agencyLogo));
		Log.info("Searched Property");

	}
	// In the FindBy section there are accessors for the elements on the page
	@FindBy(xpath= "//*[contains(@data-testid,'agent-branding')]")
	private WebElement agencyLogo;





}
