package com.learn.pageModel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by chandrad on 2/17/17.
 */
public class BasePage {

    WebDriver driver ;
    WebDriverWait wait ;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public void waitForElement(WebElement element){
        wait = new WebDriverWait(driver,10) ;
        wait.until(ExpectedConditions.visibilityOf(element)) ;
    }

    // 1 st approach to handle Header and Footers
    // Define everything on header and footer on BasePage ..
    // so that all these methods are accessible from child pages


    // 2nd Approach to handle headers and Footers
    // We create seperate individual pages fro header and footer..
    //


}
