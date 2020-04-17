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

    @FindBy(xpath = "//span[@class='bxhtmled-top-bar-btn bxhtmled-button-quote']")
    public WebElement quoteIcon;

    @FindBy(xpath = "//blockquote[@class='bxhtmled-quote']")
    public WebElement blockQuote;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement quoteIframe;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton;

    public void ClickMoreTab(){
        moreMenu.click();
    }

    public void ClickAppreciationTab(){
        appreciationTab.click();
    }

    public void ClickQuoteIcon(){
        quoteIcon.click();
    }

    public void SendQuote(WebDriver driver, String quote){
        driver.switchTo().frame(quoteIframe);
        blockQuote.sendKeys(quote);
        driver.switchTo().defaultContent();
    }

    public void ClickSendButton(){
        sendButton.click();
    }
}