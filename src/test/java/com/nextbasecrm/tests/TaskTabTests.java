package com.nextbasecrm.tests;

import com.nextbasecrm.base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ConfigurationReader;
import utility.Driver;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TaskTabTests extends TestBase {

    @BeforeMethod
    public void setUp() {
        driver.get(ConfigurationReader.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String username = ConfigurationReader.getProperty("help_desk_username");
        String password = ConfigurationReader.getProperty("help_desk_password");
        loginPage.login(username, password);

        taskTabPage.taskTab.click();
    }

    @Test
    public void highPriorityCheckboxTest() {
        taskTabPage.highPriorityCheckBox.click();
        assertTrue(taskTabPage.highPriorityCheckBox.isSelected());
    }

    @Test
    public void quoteIconTest() {
        taskTabPage.taskTitle.sendKeys("US2 Quote Test");
        taskTabPage.quoteIcon.click();
        Driver.getDriver().switchTo().frame(taskTabPage.iframeWithQuoteIcon);
        taskTabPage.quoteInput.sendKeys("Test for US2 4. User should be able to create a quote by clicking on the Comma icon.");
        Driver.getDriver().switchTo().parentFrame();
        taskTabPage.sendButton.click();
        wait.until(ExpectedConditions.visibilityOf(taskTabPage.taskCreated));
        String expectedTaskCreated = "Task has been created";
        String actualTaskCreated =taskTabPage.taskCreated.getText();
        assertEquals(actualTaskCreated, expectedTaskCreated);

    }
}
