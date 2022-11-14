package PageObjects;

import DriverManagement.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Log;

public class PolicyCookiessPage {

	WebDriver driver = DriverManager.getWebDriver();
	WebDriverWait wait = new WebDriverWait(driver, 10);

	//constructor
	public PolicyCookiessPage() {
		// Accessing WebDriver from DriverManager.java
		PageFactory.initElements(DriverManager.getWebDriver(), this);
		Log.info("Policy page");
	}

	//Elements for the page
	@FindBy(xpath = "//button[@class='cc-modal__btn cc-modal__btn--daft']")
	private WebElement Cookie_policy;

	//Method to call the elements on this page
	public WebElement GetCookies_Policy() {
		return Cookie_policy;
	}
	//waiting method
	public PolicyCookiessPage WaitForGetPolicies() {
		Log.info("Waiting Process begins here");
		wait.until(ExpectedConditions.visibilityOf(Cookie_policy));
		return this;
	}

	public PolicyCookiessPage WaitForSearchBar() {
		Log.info("Waiting Process begins here");
		wait.until(ExpectedConditions.visibilityOf(Cookie_policy));
		return this;
	}

	public void ClickCookies() {
		wait.until(ExpectedConditions.visibilityOf(Cookie_policy));
		Cookie_policy.click();
	}
}