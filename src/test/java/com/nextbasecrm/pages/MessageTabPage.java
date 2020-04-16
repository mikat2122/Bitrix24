package com.nextbasecrm.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class MessageTabPage {

    // page object classes need constructor. here we have to call the  PageFactory.initElements()
    // from selenium and pass a web driver object and this class as a parameter

    public MessageTabPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "feed-add-post-form-tab-message")
    public WebElement messageIcon;  // message icon location


    @FindBy(css = "span[title='Link']")
    public WebElement linkIcon;  // link icon location

    @FindBy(id = "linkidPostFormLHE_blogPostForm-text")
    public WebElement textInput;  // text box location

    @FindBy(id = "linkidPostFormLHE_blogPostForm-href")
    public WebElement linkInput; // link box location

    @FindBy(id = "undefined")
    public WebElement saveButton; // save button location

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton; // Send button location





}
