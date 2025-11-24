package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	static ExtentReports extent;

	public static ExtentReports getReporterNG() {
		String path = System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Provident Insurance");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setTimelineEnabled(true);

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Kural", "Tester");
		return extent;

	}

}
