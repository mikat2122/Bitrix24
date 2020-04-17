package com.nextbasecrm.tests;

import com.nextbasecrm.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ConfigurationReader;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MessageTabLinkTest extends TestBase {

/*
1. As a user, I should be able to send messages by clicking on Message tab under Active Stream.
AC-3  User should be able to attach link by clicking on the link icon.
 */

//  login2.nextbasecrm.com

    @Test
    public void test() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String username = ConfigurationReader.getProperty("help_desk_username");
        String password = ConfigurationReader.getProperty("help_desk_password");
        loginPage.login(username, password);

        messageTab.messageIcon.click();
        messageTab.linkIcon.click();


        Random number = new Random();  // I need random number because text that I write need be different every time
        int randomNumber = number.nextInt(1000);

        String textExpected = "click this link number "+randomNumber; 

        wait.until(ExpectedConditions.elementToBeClickable(messageTab.textInput));  // solved with help of Irma
        messageTab.textInput.sendKeys(textExpected);

        String linkExpected = "www.google.com";
        messageTab.linkInput.sendKeys(linkExpected);

        messageTab.saveButton.click();

        messageTab.sendButton.click();

        WebElement afterSend = driver.findElement(By.xpath("//div[@class='feed-post-text-block-inner-inner'][.='"+textExpected+"']/a"));

        System.out.println(afterSend.getText());
        Assert.assertEquals(afterSend.getText(),textExpected);


    }


}
