package com.nextbasecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class LoginPage {
    public LoginPage(){
        // page object classes need constructor. here we have to call the  PageFactory.initElements()
        // from selenium and pass a web driver object and this class as a parameter
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "USER_LOGIN")
    public WebElement username;

    @FindBy(name = "USER_PASSWORD")
    public WebElement password;

    @FindBy(className = "login-btn")
    public WebElement login;


    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        login.click();
    }
}
