package com.amazon.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting implements ITestListener{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentTest logger;
	public ExtentReports extent;

	public void onStart(ITestContext testcontext) {
		String timestamp = new SimpleDateFormat ("yyyy-MM-dd-HH-mm-ss").format(new Date());
		String repName = "Test-Report-"+ timestamp+".html";
		
		htmlReporter = new ExtentHtmlReporter (System.getProperty("user.dir")+"/TestReport/"+repName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("environment", "QA");
		extent.setSystemInfo("user", "AMIT");
		
		htmlReporter.config().setDocumentTitle("Amazon");
		htmlReporter.config().setReportName("Framework_Amazon");
		//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
	
	public void onTestSuccess(ITestResult Tr) {
		logger = extent.createTest(Tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(Tr.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult Tr) {
		logger = extent.createTest(Tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(Tr.getName(), ExtentColor.RED));
		
		String ScreenShotPath = System.getProperty("user.dir")+"/Screensorts"+Tr.getName()+".png";
		
		File f = new File(ScreenShotPath);
		
		if(f.exists())
		{
			try {
				logger.fail("screensort is below"+ logger.addScreenCaptureFromPath(ScreenShotPath));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void onFinish(ITestContext testcontext) {
		extent.flush();
	}
	
	
}
