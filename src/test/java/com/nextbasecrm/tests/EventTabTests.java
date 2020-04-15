package com.nextbasecrm.tests;
import com.nextbasecrm.base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.ConfigurationReader;

public class EventTabTests extends TestBase {

    @BeforeMethod
    public void setUpMethod(){
        loginPage.login(ConfigurationReader.getProperty("help_desk_username"), ConfigurationReader.getProperty("help_desk_password"));
    }
    @Test (description = "User should be able to attach link by clicking on the link icon",
    dataProvider = "links")
    public void linkTest(String linkText, String linkUrl) {
      eventTabPage.attachLink(linkText, linkUrl);
      wait.until(ExpectedConditions.textToBePresentInElement(eventTabPage.savedLinkWithText, linkText));
      Assert.assertTrue(eventTabPage.savedLinkWithText.getAttribute("innerHTML").equals(linkText));
    }

    @DataProvider (name = "links")
    public Object[][] getLinks(){
        return new Object [][]
                {
                        {"NY Times", "https://www.nytimes.com/"},
                        {"Washington Post","https://www.washingtonpost.com/regional/"},
                        {"Economist","https://www.economist.com/"}
                };
    }

}
