package DriverManagement;

import PageObjects.BaseObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager extends TestBase{
	//in this field we specify the browser type
	private static WebDriver driver;
//constructor
	private DriverManager() {	}
     
	//Class designed to create only one instance of the WebDriver / Singleton pattern
	//driver getter

	
	
	public static WebDriver getWebDriver() {
		if (driver == null) {
			//initiating driver using WebDriverManager
			
			// Initiate chrome driver
			driver = BrowserFactory.getBrowser(BROWSER_TYPE);
			 

		}
		return driver;

	}
       //Stopping the WebDriver method
	public static void killDriver(){
		driver.close();
		//that if statement is presented only to make sure that browser is killed
		// if (!BROWSER_TYPE.equals(BrowserType.FIREFOX))
			 driver.quit();
         
		driver = null;

	}

}
