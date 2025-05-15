package PageModules;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportNG {

	public static ExtentReports getExtentReportObject() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "\\Reports\\index.html");
		reporter.config().setReportName("WebTestReport");
		reporter.config().setDocumentTitle("test report");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Nihar");
		return extent;
	}

}
