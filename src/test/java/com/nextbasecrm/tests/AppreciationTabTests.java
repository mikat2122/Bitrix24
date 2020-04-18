package com.nextbasecrm.tests;

import com.nextbasecrm.base.TestBase;
import com.nextbasecrm.pages.AppreciationPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ConfigurationReader;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class AppreciationTabTests extends TestBase {
    @BeforeMethod
    public void setUpTests(){
        appreciationPage= new AppreciationPage();
    }

    @Test
    public void loginAsHelpDesk()  {
        loginPage.login(ConfigurationReader.getProperty("help_desk_username"), ConfigurationReader.getProperty("help_desk_password"));
        WebDriverWait wait = new WebDriverWait(driver,20);

        wait.until(visibilityOf(appreciationPage.moreMenu));
        appreciationPage.ClickMoreTab();

        wait.until(visibilityOf(appreciationPage.appreciationTab));
        appreciationPage.ClickAppreciationTab();

        wait.until(visibilityOf(appreciationPage.linkIcon));
        appreciationPage.ClickLinkIcon();

        wait.until(visibilityOf(appreciationPage.linkText));
        appreciationPage.SendLinkText(driver, "Music video test");

        wait.until(visibilityOf(appreciationPage.linkURL));
        appreciationPage.SendLinkURL(driver,"https://www.youtube.com/watch?v=RrZHOh77F3Q");

        wait.until(visibilityOf(appreciationPage.saveButton));
        appreciationPage.ClickSaveButton();

    }



}