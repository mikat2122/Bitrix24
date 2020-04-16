package com.nextbasecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class ActivityStreamPage {
    public ActivityStreamPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='feed-com-file-wrap']/span[2]/a")
    public WebElement firstPostAddedFile;

    @FindBy(xpath = "//*[starts-with(@id, 'disk-attach-image')]")
    public WebElement firstPostAddedPicture;

    @FindBy(className = "feed-com-files-title")
    public WebElement firstPostFileType;
}
