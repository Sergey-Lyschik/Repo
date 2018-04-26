package com.gmail.qa.base;


import com.gmail.qa.util.ConfigReader;
import com.gmail.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod
    public void setUp(){
        ConfigReader.initProp();
        DriverManager.getDriver();
        DriverManager.maximizeWindow();
        DriverManager.setImplicityWait(TestUtil.IMPLICIT_WAIT);
        DriverManager.goToURL(ConfigReader.getProp("url"));

    }

    @AfterMethod
    public void tearDown(){
        DriverManager.closeDriver();
    }

}
