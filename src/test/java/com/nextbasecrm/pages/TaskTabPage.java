package com.nextbasecrm.pages;

import com.nextbasecrm.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import utility.Driver;

public class TaskTabPage {
    public TaskTabPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span/span[text()='Task']")
    public WebElement taskTab;

    @FindBy(id = "tasks-task-priority-cb")
    public WebElement highPriorityCheckBox;

    @FindBy(xpath = "(//span[@title='Quote text'])[2]")
    public WebElement quoteIcon;

    //QuoteIcon IS LOCATED WITHIN THE FRAME, SO YOU NEED TO LOCATE FRAME FIRST
    @FindBy(css = "#bx-html-editor-iframe-cnt-lifefeed_task_form>iframe")
    public WebElement iframeWithQuoteIcon;

    @FindBy(css = ".bxhtmled-quote")
    public WebElement quoteInput;


    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton;

    @FindBy(xpath = "//input[@data-bx-id='task-edit-title']")
    public WebElement taskTitle;

    @FindBy(className = "feed-create-task-popup-title")
    public WebElement taskCreated;

}
