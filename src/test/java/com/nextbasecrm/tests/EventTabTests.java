package com.nextbasecrm.tests;

import com.nextbasecrm.base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ConfigurationReader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EventTabTests extends TestBase {

    @Test
    public void uploadFileIconTest(){
        String username = ConfigurationReader.getProperty("help_desk_username");
        String password = ConfigurationReader.getProperty("help_desk_password");
        loginPage.login(username,password);

        eventTabPage.eventTab.click();
        eventTabPage.uploadFileIcon.click();
        assertTrue(eventTabPage.uploadFileMenu.isDisplayed());
    }

    @Test
    public void uploadFilesAndImagesFromLocalTest() throws InterruptedException {
        String username = ConfigurationReader.getProperty("help_desk_username");
        String password = ConfigurationReader.getProperty("help_desk_password");
        loginPage.login(username,password);
        eventTabPage.eventTab.click();
        eventTabPage.uploadFileIcon.click();

        eventTabPage.uploadFilesAndImagesFromLocal.sendKeys("/Users/pryvedennyi/Desktop/my_file.txt");
        assertTrue(eventTabPage.fileName.getText().startsWith("my_file"));
        String expectedFileName = eventTabPage.fileName.getText();
        eventTabPage.sendButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(activityStreamPage.firstPostAddedFile));
        String actualFileName = activityStreamPage.firstPostAddedFile.getText();
        assertEquals(actualFileName, expectedFileName);
    }
}
