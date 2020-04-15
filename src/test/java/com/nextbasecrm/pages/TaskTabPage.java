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




}
