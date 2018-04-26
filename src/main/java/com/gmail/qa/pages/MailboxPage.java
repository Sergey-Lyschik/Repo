package com.gmail.qa.pages;

import com.gmail.qa.base.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailboxPage{


    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private WebElement composeButton;

    @FindBy(xpath = "//*[contains(@title, 'Inbox (1)')]")
    private WebElement inboxButton;

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement recepientField;

    @FindBy(xpath = "//div[@class='yW']")
    private WebElement inboxMessageField;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement messageBodyField;

    @FindBy(xpath = "//div[@style='display:']//div[contains(@dir, 'ltr')]")
    private WebElement textOfMessageField;


    @FindBy(xpath = "//div[contains(@data-tooltip, 'Send')]")
    private WebElement sendMessageButton;

    public MailboxPage (){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }



    public void sendMail(String recepient, String messageBody){
        composeButton.click();
        recepientField.sendKeys(recepient);
        messageBodyField.sendKeys(messageBody);
        sendMessageButton.click();
    }

    public String verifyDeliveredMessage(){
        inboxButton.click();
        DriverManager.waitForElementToBeClickable(inboxMessageField);
        inboxMessageField.click();
        return textOfMessageField.getText();
    }


}
