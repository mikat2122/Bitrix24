package com.nextbasecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class EventTabPage {
    public EventTabPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "feed-add-post-form-tab-calendar")
    public WebElement eventTab;
    @FindBy(name = "EVENT_NAME")
    public WebElement eventName;

    @FindBy(xpath = "(//*[@title='Link'])[2]")
    public WebElement link;

    @FindBy (xpath = "//table//tr[3]/td/input[@placeholder='Link URL']")
    public WebElement linkUrl;



}
