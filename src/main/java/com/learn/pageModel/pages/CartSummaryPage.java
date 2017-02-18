package com.learn.pageModel.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by chandrad on 2/14/17.
 */
public class CartSummaryPage extends BasePage {


    WebDriverWait wait ;

    private static final Logger LOGGER = LogManager.getLogger(CartSummaryPage.class) ;


    public CartSummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        waitForPageLoad();
    }


    @FindBy(id = "cart_title")
    private WebElement cartSummaryHeader ;


    @FindBy(xpath = "//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']")
    private WebElement proceedToCheckoutBtton ;


//    public void waitForElement(WebElement element){
//        wait = new WebDriverWait(driver,10) ;
//        wait.until(ExpectedConditions.visibilityOf(element)) ;
//    }

    // mon navigational method
    private void waitForPageLoad(){
        LOGGER.info(" << waiting for cartsummaryPage up to load successfully >>");
        waitForElement(cartSummaryHeader);
    }


    public AuthenticationPage navToAuthentiation(){

        LOGGER.info(" << clicked on proceed to navigate to Authentication Page >>");
        proceedToCheckoutBtton.click();

        return new AuthenticationPage(driver);

    }
}
