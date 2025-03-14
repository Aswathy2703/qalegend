package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	static ExtentReports extent;
	public static ExtentReports getReportObject() {
		String path=System.getProperty("user.dir")+"\\test-output\\report.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setDocumentTitle("Test Results");
		extent= new ExtentReports();
		extent.attachReporter(reporter);//reporter knows where to create file , name an
		extent.setSystemInfo("Tester", "Aswathy S Kumar");
		return extent;
		
	}
	
	

}
//ExtentSparkReporter- use all methods to costomization of file
//ExtentReports