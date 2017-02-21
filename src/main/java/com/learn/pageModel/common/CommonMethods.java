package com.learn.pageModel.common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;
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

    public static void captureScreenshot() throws IOException {

        //syntax for taking screenshot
        TakesScreenshot ts = (TakesScreenshot)DriverManager.getDriver() ;

        File src = ts.getScreenshotAs(OutputType.FILE) ; // converts the bibary of screenshot in a file and store it in the variable called src
        String dest = "./screen/" + System.currentTimeMillis() +".png" ;


        File destination = new File(dest) ;
        FileUtils.copyFile(src,destination ) ;
    }
}
