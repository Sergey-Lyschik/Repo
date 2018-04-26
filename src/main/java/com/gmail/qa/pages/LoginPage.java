package com.gmail.qa.pages;

import com.gmail.qa.base.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{

    @FindBy(xpath = "//input[@type='email']")
    private WebElement textFieldUser;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement textFieldPass;


    @FindBy(xpath="//div[@id = 'identifierNext']")
    private WebElement btnNextLogin;

    @FindBy(xpath="//div[@id = 'passwordNext']")
    private WebElement btnNextPass;


    public LoginPage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }


    public void login(String email, String pass){
        textFieldUser.sendKeys(email);
        btnNextLogin.click();
        textFieldPass.sendKeys(pass);
        DriverManager.waitForElementToBeClickable(btnNextPass);
        btnNextPass.click();
    }

}
