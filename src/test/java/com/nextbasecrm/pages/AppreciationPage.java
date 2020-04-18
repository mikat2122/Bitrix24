package com.nextbasecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class AppreciationPage {
    public AppreciationPage(){
        // page object classes need constructor. here we have to call the  PageFactory.initElements()
        // from selenium and pass a web driver object and this class as a parameter
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='feed-add-post-form-link-more']")
    public WebElement moreMenu;

    @FindBy(xpath = "//span[@class='menu-popup-item menu-popup-no-icon feed-add-post-form-grat feed-add-post-form-grat-more ']")
    public WebElement appreciationTab;

    @FindBy(xpath = "//span[@class='bxhtmled-top-bar-btn bxhtmled-button-link']")
    public WebElement linkIcon;

    @FindBy(xpath = "//input[@id='linkidPostFormLHE_blogPostForm-text']")
    public WebElement linkText;

    @FindBy(xpath = "//input[@id='linkidPostFormLHE_blogPostForm-href']")
    public WebElement linkURL;

    @FindBy(xpath = "//input[@id='undefined']")
    public WebElement saveButton;


    public void ClickMoreTab(){
        moreMenu.click();
    }

    public void ClickAppreciationTab(){
        appreciationTab.click();
    }

    public void ClickLinkIcon(){
        linkIcon.click();

    }
    public void SendLinkText(WebDriver driver,String text){
        linkText.sendKeys(text);

    }
    public void SendLinkURL(WebDriver driver,String URL){
        linkURL.sendKeys(URL);
    }
    public void ClickSaveButton(){
        saveButton.click();
    }
}