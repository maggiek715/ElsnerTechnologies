package com.golden.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
//WebDriver
public static WebDriver driver ;
public static Logger log= Logger.getLogger("BaseClass");
public Properties prop=new Properties();
public static ExtentReports extent;
public static ExtentHtmlReporter htmlReporter;
public static ExtentTest test;

@BeforeClass
public void setup() throws IOException {
FileInputStream log_file=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Log4j.properties");
prop.load(log_file);
PropertyConfigurator.configure(prop);
extent = new ExtentReports();
htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/testreports.html");
extent.attachReporter(htmlReporter);
//work with chrome
System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/Chrome/chromedriver.exe");
driver = new ChromeDriver();
log.info("Chrome browser is opened");

//maximize
driver.manage().window().maximize();
log.info("Chrome browser maximized");

//navigate
driver.get("https://magento.fmv.cc/goldenaromatherapy/");
System.out.println("launched successfuly");
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

@AfterClass
public void completeclose() {
//driver.close();
log.info("Not Closing Browser");

//log.info("Closing Browser");
extent.flush();
}


@AfterMethod
public void getResult(ITestResult result) {
if(result.getStatus()==ITestResult.FAILURE) {
test.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+"Failed", ExtentColor.RED));
test.fail(result.getThrowable());
}
else if (result.getStatus()==ITestResult.SUCCESS) {
test.log(Status.PASS,MarkupHelper.createLabel(result.getName()+"Passed", ExtentColor.GREEN));
}
else {
test.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+"Skipped", ExtentColor.ORANGE));
test.skip(result.getThrowable());
}
}

}