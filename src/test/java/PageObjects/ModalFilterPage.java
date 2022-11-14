package PageObjects;

import DriverManagement.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Log;

public class ModalFilterPage {

	WebDriver driver = DriverManager.getWebDriver();
	WebDriverWait wait = new WebDriverWait(driver,10);
	 //constructor
	public ModalFilterPage() {
		// Accessing WebDriver from DriverManager.java
		PageFactory.initElements(DriverManager.getWebDriver(), this);
		wait.until(ExpectedConditions.visibilityOf(filterSearch));
		Log.info("Modal page");
	}
	// In the FindBy section there are accessors for the elements on the page
	@FindBy(id= "keywordtermsModal")
	private WebElement searchedKeyword;

	@FindBy(xpath= "//div[contains(@aria-label,'Filter Search')]")
	private WebElement filterSearch;

	@FindBy(xpath= "//button[@class='NewButton__StyledButton-yem86a-2 klRAtd']")
	private WebElement showButton;
	//getters
	public WebElement GetSearchedKeyword() {
		return searchedKeyword;
	}

	public WebElement GetFilterSearch() {
		return filterSearch;
	}

	//waiting methods
	public ModalFilterPage WaitForSearchBar()
	{
		Log.info("Waiting for the Searched Keyword Section Bar");
		wait.until(ExpectedConditions.visibilityOf(searchedKeyword));
		return this;
	}

	public void WaitingForSearchDropDown () {

		wait.until(ExpectedConditions.visibilityOf(searchedKeyword));
	}

	public void enterSearchedFilterWord(String word)
	{
		searchedKeyword.click();
		searchedKeyword.clear();
		searchedKeyword.sendKeys(word);
	}
	public void clickShowResults()
	{
		showButton.click();
	}

}
