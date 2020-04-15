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

    @FindBy(xpath = "//table//tr[1]/td/input[@placeholder='Link text']")
    public WebElement linkText;

    @FindBy (xpath = "//table//tr[3]/td/input[@placeholder='Link URL']")
    public WebElement linkUrl;

    @FindBy (xpath = "//input[@value='Save']")
    public WebElement saveBtn;

    //LINK IS LOCATED WITHIN THE FRAME, SO YOU NEED TO LOCATE FRAME FIRST
    @FindBy(xpath = "(//iframe[@class='bx-editor-iframe'])[2]")
    public WebElement iframeWithLink;

    //MY LINK
    @FindBy(xpath ="//body/a" )
    public WebElement savedLinkWithText;

    public void attachLink(String linkText, String linkUrl){
        //click on Event tab
    eventTab.click();
        //click on link symbol
    link.click();
        //enter name of link
        this.linkText.sendKeys(linkText);
        //enter actual url
        this.linkUrl.sendKeys(linkUrl);
        //save my link
       saveBtn.click();
        //switch to iframe where our saved link is displayed
        Driver.getDriver().switchTo().frame(iframeWithLink);
    }
}
