package com.nextbasecrm.tests;

import com.nextbasecrm.base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ConfigurationReader;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPageTests extends TestBase {

    @BeforeMethod
    public void setUpTests(){
        driver.get(ConfigurationReader.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void loginAsHelpDesk(){
        String username = ConfigurationReader.getProperty("help_desk_username");
        String password = ConfigurationReader.getProperty("help_desk_password");
        loginPage.login(username,password);


        String actualTitle = driver.getTitle();
        assertTrue(actualTitle.contains("Portal"));
    }
}
