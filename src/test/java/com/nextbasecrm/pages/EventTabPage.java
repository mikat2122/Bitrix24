package com.nextbasecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Driver;

import java.util.List;

public class EventTabPage {
    @FindBy(id = "feed-add-post-form-tab-calendar")
    public WebElement eventTab;
    @FindBy(name = "EVENT_NAME")
    public WebElement eventName;
    @FindBy(xpath = "(//*[@title='Link'])[2]")
    public WebElement link;
    @FindBy(xpath = "//table//tr[1]/td/input[@placeholder='Link text']")
    public WebElement linkText;
    @FindBy(xpath = "//table//tr[3]/td/input[@placeholder='Link URL']")
    public WebElement linkUrl;
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement saveButton;
    //LINK IS LOCATED WITHIN THE FRAME, SO YOU NEED TO LOCATE FRAME FIRST
    @FindBy(xpath = "(//iframe[@class='bx-editor-iframe'])[2]")
    public WebElement iframeWithLink;
    //MY LINK
    @FindBy(xpath = "//body/a")
    public WebElement savedLinkWithText;
    @FindBy(css = "#blog-submit-button-save")
    public WebElement sendButton;
    @FindBy(className = "bx-layout-inner-table im-bar-mode")
    public WebElement activityStreamPostings;
    @FindBy(xpath = "(//div[@id='log_internal_container']//div//div[@class='feed-calendar-view-description']/a[@target='_blank'])")
    public List<WebElement> listOfLinks;
    @FindBy(id = "bx-b-uploadfile-blogPostForm_calendar")
    public WebElement uploadFileIcon;
    @FindBy(id = "divoCalEditorcal_3Jcl")
    public WebElement uploadFileMenu;
    @FindBy(name = "bxu_files[]")
    public WebElement uploadFilesAndImagesFromLocal;
    @FindBy(xpath = "//*[@title='Click to insert file']")
    public WebElement fileName;

    public EventTabPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /**
     * Method allows to attach link to a given pop-up.
     * Will switch to confirmation iframe at the end
     *
     * @param linkText
     * @param linkUrl
     */
    public void attachLink(String linkText, String linkUrl) {
        eventTab.click();
        link.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.linkText));
        this.linkText.sendKeys(linkText);
        wait.until(ExpectedConditions.elementToBeClickable(this.linkUrl));
        this.linkUrl.sendKeys(linkUrl);
        saveButton.click();
        Driver.getDriver().switchTo().frame(iframeWithLink);
    }
}
