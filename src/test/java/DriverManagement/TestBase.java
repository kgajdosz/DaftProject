package DriverManagement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

	protected WebDriver driver;
	protected static BrowserType BROWSER_TYPE ;
	@BeforeClass
	@Parameters("browser")
	public static BrowserType setWebDriver(@Optional BrowserType browser)  
	{
	 if(browser == null) 
	 {
		 System.out.println("NULL test");
		 BROWSER_TYPE = BrowserType.CHROME;
		 return BROWSER_TYPE ;
	 }
	 else
	 {
		 BROWSER_TYPE = browser;
		 return  BROWSER_TYPE ;
	 }
	}
	
   //Before each test always runs
	@BeforeMethod
	public void before() {
		// line below switches off all the debug logs from the console
		System.setProperty("org.freemarker.loggerLibrary", "none");
		//start the WebDriver before the method
		driver = DriverManager.getWebDriver();
		// Maximize the window
		driver.manage().window().maximize();
		// navigate to URL
		driver.get("http://www.daft.ie");
		// delete cookies
		driver.manage().deleteAllCookies();

	}
	//After each test always runs
	@AfterMethod
	//Stop the WebDriver after the method
	public void after() throws Exception {
		DriverManager.killDriver();

	}

}
