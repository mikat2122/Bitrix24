package com.nextbasecrm.tests;

import com.nextbasecrm.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.BrowserUtils;
import utility.ConfigurationReader;
import static org.testng.Assert.assertEquals;
import java.util.List;
import static org.testng.Assert.assertTrue;

public class EventTabTests extends TestBase {

    @BeforeMethod
    public void setUpMethod(){
        loginPage.login(ConfigurationReader.getProperty("help_desk_username"), ConfigurationReader.getProperty("help_desk_password"));
    }
    @Test (description = "User should be able to attach link by clicking on the link icon",
            dataProvider = "links")
    public void linkTest(String linkText, String linkUrl) throws InterruptedException {
        eventTabPage.attachLink(linkText, linkUrl);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.textToBePresentInElement(eventTabPage.savedLinkWithText, linkText));
        driver.switchTo().defaultContent();
        eventTabPage.sendButton.click();
        List<String> listOfLinks = BrowserUtils.getElementsText(eventTabPage.listOfAllLinksAttachments);
        wait.until(ExpectedConditions.visibilityOfAllElements(eventTabPage.listOfAllLinksAttachments));
        assertTrue(listOfLinks.contains(linkText));

        //Assert.assertTrue(eventTabPage.savedLinkWithText.getAttribute("innerHTML").equals(linkText));
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

    @Test
    public void uploadFileIconTest(){
        eventTabPage.eventTab.click();
        eventTabPage.uploadFileIcon.click();
        assertTrue(eventTabPage.uploadFileMenu.isDisplayed());
    }

    @Test
    public void uploadFilesAndImagesFromLocalTest() throws InterruptedException {
        eventTabPage.eventTab.click();
        eventTabPage.uploadFileIcon.click();

        eventTabPage.uploadFilesAndImagesFromLocal.sendKeys("src/test/resources/my_file.txt");
        assertTrue(eventTabPage.fileName.getText().startsWith("my_file"));
        String expectedFileName = eventTabPage.fileName.getText();
        eventTabPage.sendButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(activityStreamPage.firstPostAddedFile));
        String actualFileName = activityStreamPage.firstPostAddedFile.getText();
        assertEquals(actualFileName, expectedFileName);
    }

}
