package com.learn.pageModel.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chandrad on 2/16/17.
 */
public class CommonMethods {

   static  WebDriver driver ;

    public static String getUniqueEmail(String name){
        String value = name + new SimpleDateFormat("ddMMYYhhmm").format(new Date()) + "@mailinator.com";
        return value;
    }

    public static String timeStamp(String name) {
        String value = name + new SimpleDateFormat("ddMMYYhhmmss").format(new Date());
        return value;
    }

    public static WebDriver getDriverInstance(String browser){

        if (browser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        else if (browser.equalsIgnoreCase("chrome"))
        {
            // System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            int Width = (int) toolkit.getScreenSize().getWidth();
            int Height = (int) toolkit.getScreenSize().getHeight();
            driver.manage().window().setSize(new org.openqa.selenium.Dimension(Width, Height));

        }

        return driver ;
    }
}
