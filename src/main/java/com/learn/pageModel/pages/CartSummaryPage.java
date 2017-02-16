package com.learn.pageModel.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by chandrad on 2/14/17.
 */
public class CartSummaryPage {


    WebDriver driver ;
    WebDriverWait wait ;

    private static final Logger LOGGER = LogManager.getLogger(CartSummaryPage.class) ;


    public CartSummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "cart_title")
    private WebElement cartSummaryHeader ;


    @FindBy(xpath = "//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']")
    private WebElement proceedToCheckoutBtton ;


    private void waitForElement(WebElement element){
        wait = new WebDriverWait(driver,10) ;
        wait.until(ExpectedConditions.visibilityOf(element)) ;
    }

    // mon navigational method
    public CartSummaryPage waitForPageLoad(){
        LOGGER.info(" << waiting for cartsummaryPage up to load successfully >>");
        waitForElement(cartSummaryHeader);
        return new CartSummaryPage(driver);
        // return this ;
    }


    public void navToAuthentiation(){

        LOGGER.info(" << clicked on proceed to navigate to Authentication Page >>");
        proceedToCheckoutBtton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}