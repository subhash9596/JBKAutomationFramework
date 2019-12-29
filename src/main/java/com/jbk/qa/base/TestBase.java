package com.jbk.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public  class TestBase {
	public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extend ;
    public static ExtentTest logger ;
    public static WebDriver  driver;
	@BeforeSuite
	public static WebDriver setup_Browser(){
		Reporter.log("=====Application Session Started========",true);
		driver = new FirefoxDriver();
		driver.manage().window().maximize(); // Maximize the window 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("file:///E:/Offline%20Website/index.html");
		Reporter.log("=====Application Started ========",true);
		return driver;		
	}
	@AfterSuite
	public void CloseApplication(){
		driver.quit();
		Reporter.log("===== Browser Session End  ========",true);
	}
	
	//Report Generate 
	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/extendReport.html");
		extend = new ExtentReports();
		extend.attachReporter(htmlReporter);
	}
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE){
			logger.fail(MarkupHelper.createLabel(result.getName()+"  Test Case Failed", ExtentColor.RED));
			logger.fail(result.getThrowable());
		}else if (result.getStatus()==ITestResult.SUCCESS){
			logger.pass(MarkupHelper.createLabel(result.getName()+"  Test Case Passed", ExtentColor.GREEN));	
		}else
		{
			logger.skip(MarkupHelper.createLabel(result.getName()+"  Test Case Skiped", ExtentColor.YELLOW));
			logger.skip(result.getThrowable());
		}
	}
      @AfterSuite
	public void tearDown(){
		extend.flush();
		
	}   
}

