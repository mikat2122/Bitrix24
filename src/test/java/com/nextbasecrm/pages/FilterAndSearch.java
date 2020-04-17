package com.nextbasecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class FilterAndSearch {

    public FilterAndSearch(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "LIVEFEED_search")
    public WebElement searchIcon;

   // @FindBy()
}
