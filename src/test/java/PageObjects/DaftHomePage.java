package PageObjects;

import DriverManagement.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Log;

public class DaftHomePage {

	 WebDriver driver = DriverManager.getWebDriver();
	 WebDriverWait wait = new WebDriverWait(driver,10);
	 //constructor
	public DaftHomePage() {
		// Accessing WebDriver from DriverManager.java
		PageFactory.initElements(DriverManager.getWebDriver(), this);
		Log.info("Daft page");
	}
	// In the FindBy section there are accessors for the elements on the page
	@FindBy(id= "search-box-input")
	private WebElement searchBar;

	//@FindBy(xpath= "//li[@id='search-box-item-0']/div/span/span")
	@FindBy(xpath= "//li[@id='search-box-item-0']")
	private WebElement dropDown;

	@FindBy(xpath= "//button[@data-testid='open-filters-modal']")
	private WebElement filter;

	//Methods to call the elements on this page / or waiting for the elements

	//getters
	public WebElement GetSearchBar() {
		return searchBar;
	}

	public WebElement GetDropDown() {
		return dropDown;
	}
	//waiting methods
	public DaftHomePage WaitForSearchBar()
	{
		Log.info("Waiting for the Search Bar");
		wait.until(ExpectedConditions.visibilityOf(searchBar));
		return this;
	}

	public void WaitingForSearchDropDown () {

		wait.until(ExpectedConditions.visibilityOf(dropDown));
	}

	public void enterSearchedLocation()  {

		searchBar.click();
		searchBar.clear();
		searchBar.sendKeys("Dublin");
		WaitingForSearchDropDown();
		dropDown.click();
	}
	public void clickFilter()
	{
		filter.click();
	}

}
