package com.gmail.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    public static void initProp(){
        try {
            prop = new Properties();
            FileInputStream inputStream = new FileInputStream("src\\main\\java\\com\\gmail\\qa\\config\\config.properties");
            prop.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getProp(String key) {
        return prop.getProperty(key);
    }
}
