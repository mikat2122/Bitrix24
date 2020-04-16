package com.nextbasecrm.tests;

import com.nextbasecrm.base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ConfigurationReader;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class TaskTabTests extends TestBase {

    @BeforeMethod
    public void setUp(){
        driver.get(ConfigurationReader.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String username = ConfigurationReader.getProperty("help_desk_username");
        String password = ConfigurationReader.getProperty("help_desk_password");
        loginPage.login(username,password);

        taskTabPage.taskTab.click();
    }

    @Test
    public void highPriorityCheckboxTest(){
        taskTabPage.highPriorityCheckBox.click();
        assertTrue(taskTabPage.highPriorityCheckBox.isSelected());
    }


}
