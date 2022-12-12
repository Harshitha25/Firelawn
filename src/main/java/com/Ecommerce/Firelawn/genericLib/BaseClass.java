package com.Ecommerce.Firelawn.genericLib;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Connection con;
	public FileUtilies fu=new FileUtilies();
	public WebDriver driver;
	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports reports;
	public static ExtentTest test;
	public WebdriverUtilies webutilies= new WebdriverUtilies();
	
	@BeforeSuite //execute only once in program
	public void configBS() throws SQLException {
		System.out.println("connect to database");
		con=fu.getDataDb();
		
		htmlreport= new ExtentHtmlReporter(AutoConstant.reportsPath);
		htmlreport.config().setDocumentTitle("FireflawnReport");
		htmlreport.config().setTheme(Theme.DARK);
		reports=new ExtentReports(); //generate and capture data
		reports.attachReporter(htmlreport);
		
	}
	
	@BeforeMethod
	public void openApp() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(fu.getPropertydata("url"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	@AfterMethod
	public void closeApp(ITestResult res) throws IOException {
		int result =res.getStatus();
		if (result== ITestResult.FAILURE) {
			test.log(Status.FAIL,res.getName()+"Test case is failed");
			test.log(Status.FAIL,res.getThrowable()+"testcase is failed exception");
		}
		else if(result==ITestResult.SUCCESS) {
			test.log(Status.PASS,res.getName()+"Test case is passed");
		}
		else if(result==ITestResult.SKIP) {
			test.log(Status.SKIP,res.getName()+"testcase is skipped");
		}
		
		String name=res.getName();
		if(result==2) { // ==2 is for fail, 1 is for pass and 3 for skipped
			Screenshot s =new Screenshot();
			s.getPhoto(driver,name);
		}
		driver.quit();
	}
	
	@AfterSuite
	public void  configAs() throws SQLException {
		reports.flush();
		fu.closedb();
		Reporter.log("DataBase is closed");
	}
}
