package com.nextbasecrm.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.nextbasecrm.pages.EventTabPage;
import com.nextbasecrm.pages.LoginPage;
import com.nextbasecrm.pages.TaskTabPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import utility.ConfigurationReader;
import utility.Driver;


import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected EventTabPage eventTabPage;
    protected TaskTabPage taskTabPage;
    protected SoftAssert softAssert;
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReport;
    protected ExtentTest test;

    @Parameters("url")
    @BeforeMethod
    public void setUpMethod(@Optional String url){
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        softAssert = new SoftAssert();
        if(url == null){
            driver.get(ConfigurationReader.getProperty("url"));
        } else {
            driver.get(url);
        }
        loginPage = new LoginPage();
        eventTabPage=new EventTabPage();

        taskTabPage=new TaskTabPage();
    }
    @AfterMethod
    public void tearDownMethod() {
        Driver.closeDriver();
    }
}
