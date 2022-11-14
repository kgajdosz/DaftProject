package ExtentReport;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ScreenshotPackage.Screenshots;

public class ExtentReporterNG {
	//Extent Report creation class
	static ExtentReports extent;
	public static ExtentReports getReport()
	{
		//LocalDate
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy/HH.mm.ss");
		String str = formatter.format(date);
		
		String reportLocation =  System.getProperty("user.dir")+"./reports/ "+ Screenshots.getDateAndTimeReport()+ ".html";
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(reportLocation);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Santhosh");
		return extent;
	}

}
