package PageObjects;

import DriverManagement.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Log;

public class PopUpPage {

	WebDriver driver = DriverManager.getWebDriver();
	WebDriverWait wait = new WebDriverWait(driver,10);
	 //constructor
	public PopUpPage() {
		// Accessing WebDriver from DriverManager.java
		PageFactory.initElements(DriverManager.getWebDriver(), this);
		wait.until(ExpectedConditions.visibilityOf(popupClose));
		Log.info("PopUp page");
	}
	// In the FindBy section there are accessors for the elements on the page
	@FindBy(xpath= "//button[@class='styles__CloseContainer-qea560-4 cbFYJA']")
	private WebElement popupClose;


	//Methods to call the elements on this page / or waiting for the elements

	//getters
	public WebElement GetPopUp() {
		return popupClose;
	}




}
