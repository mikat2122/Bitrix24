package com.nextbasecrm.tests;

import com.nextbasecrm.base.TestBase;
import com.nextbasecrm.pages.AppreciationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ConfigurationReader;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.testng.Assert.assertTrue;

public class AppreciationPageTests extends TestBase {
    @BeforeMethod
    public void setUpTests(){
        appreciationPage= new AppreciationPage();
    }

    @Test
    public void CreateQuote() throws InterruptedException {
        loginPage.login(ConfigurationReader.getProperty("help_desk_username"), ConfigurationReader.getProperty("help_desk_password"));
        WebDriverWait wait=new WebDriverWait(driver,20);

        wait.until(visibilityOf(appreciationPage.moreMenu));
        appreciationPage.ClickMoreTab();

        wait.until(visibilityOf(appreciationPage.appreciationTab));
        appreciationPage.ClickAppreciationTab();

        wait.until(visibilityOf(appreciationPage.quoteIcon));
        appreciationPage.ClickQuoteIcon();

        wait.until(visibilityOf(appreciationPage.quoteIframe));

        appreciationPage.SendQuote(driver,"Test quote message");

        wait.until(visibilityOf(appreciationPage.sendButton));
        appreciationPage.ClickSendButton();
        
        
        mkmkmk
    }
}
