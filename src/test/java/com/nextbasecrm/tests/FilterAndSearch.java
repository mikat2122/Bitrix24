package com.nextbasecrm.tests;

import com.nextbasecrm.base.TestBase;
import org.testng.annotations.Test;
import utility.ConfigurationReader;

import java.util.concurrent.TimeUnit;

public class FilterAndSearch extends TestBase {

    /*
    . As a user, I should be able to use "Filter
    and search" functionality on Active Stream.
     */

    @Test
    public void setUpMethod() throws InterruptedException {
        driver.get(ConfigurationReader.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String username = ConfigurationReader.getProperty("help_desk_username");
        String password = ConfigurationReader.getProperty("help_desk_password");
        loginPage.login(username, password);

        filterAndSearch.searchIcon.click();
        Thread.sleep(3000);
        filterAndSearch.dateIcon.click();
        Thread.sleep(3000);



    }

}
