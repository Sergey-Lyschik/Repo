package com.gmail.qa.base;

import com.gmail.qa.util.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    public static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null){
            initDriver();
            return driver;
        } else {
            return driver;
        }
    }

    private static void initDriver(){
        switch (ConfigReader.getProp("browser")){
            case "chrome" :
                System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "FF" :
                System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                try {
                    throw new Exception("Invaild driver");
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }

    public static void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public static void setImplicityWait(Long timeout){
        driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);
    }
    public static void goToURL(String url){
        driver.get(url);
    }

    public static void closeDriver(){
        driver.quit();
    }

    public static void waitForElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
