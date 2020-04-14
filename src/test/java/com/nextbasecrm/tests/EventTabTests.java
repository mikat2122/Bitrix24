package com.nextbasecrm.tests;

import com.nextbasecrm.base.TestBase;
import com.nextbasecrm.pages.EventTabPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ConfigurationReader;

public class EventTabTests extends TestBase {

    EventTabPage eventTabPage;

    @BeforeMethod
    public void setUpMethod(){
        eventTabPage=new EventTabPage();
    }
    @Test
    public void linkTest() throws InterruptedException {
        loginPage.login(ConfigurationReader.getProperty("help_desk_username"), ConfigurationReader.getProperty("help_desk_password"));
        eventTabPage.eventTab.click();
        eventTabPage.eventName.sendKeys("Stand-up meeting");
        eventTabPage.link.click();
        Thread.sleep(2000);
        eventTabPage.linkUrl.sendKeys("https://testng.org/doc/documentation-main.html");
        Thread.sleep(2000);
    }
}
