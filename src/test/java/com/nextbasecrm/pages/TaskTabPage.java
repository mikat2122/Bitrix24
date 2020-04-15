package com.nextbasecrm.pages;

import com.nextbasecrm.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;

public class TaskTabPage {

    @FindBy(xpath = "//span/span[text()='Task']")
    WebElement taskTab;

    @FindBy(id = "tasks-task-priority-cb")
    WebElement highPriorityCheckBox;

    @FindBy(id = "bx-b-uploadfile-task-form-lifefeed_task_form")
    WebElement uploadFileIcon;



}
