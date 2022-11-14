package DriverManagement;

public enum BrowserType {
	
	
	CHROME("chrome"),
	FIREFOX("firefox"),
	EDGE("edge");
	//static fild - we have a access to that field only by calling contructor
	private final String browser;
	
	//construktor
	BrowserType(String browser)
	{
		this.browser=browser;
	}
	
	

	
	
	
	
}
