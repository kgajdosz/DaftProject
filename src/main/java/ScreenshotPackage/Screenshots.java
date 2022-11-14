package ScreenshotPackage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {

	WebDriver driver;
    //Creating a screenshot for failed tests in Extent Report
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "./screenshots/ "+ getDateAndTimeReport() + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

	public static String getDateAndTimeReport() {
     //Getting the current date and time method
		String str = null;
		try {
			Date date = new Date();
			//String timeStamp = new SimpleDateFormat("dd.MMMM.yyyy/HH.mm.ss").format(new Date());
			//str = timeStamp.formatted(date);
			SimpleDateFormat formatter = new SimpleDateFormat("dd.MMMM.yyyy/HH.mm.ss");
			str = formatter.format(date);
			

		} catch (Exception e) {
		}
		return str;
	}
	

}
