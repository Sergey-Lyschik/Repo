package com.gmail.qa.tests;

import com.gmail.qa.base.BaseTest;
import com.gmail.qa.pages.LoginPage;
import com.gmail.qa.pages.MailboxPage;
import com.gmail.qa.util.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GmailTest extends BaseTest {
    private String message = "Hello, world!";

    @Test
    public void sendMailTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigReader.getProp("email"),
                        ConfigReader.getProp("password"));

        MailboxPage mailboxPage = new MailboxPage();
        mailboxPage.sendMail(ConfigReader.getProp("email"), message);
        String textFromInboxMessage = mailboxPage.verifyDeliveredMessage();
        Assert.assertEquals(textFromInboxMessage,message, "Text doesn't match");


    }
}
