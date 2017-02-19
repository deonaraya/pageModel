package com.learn.pageModel.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by chandrad on 2/14/17.
 */
public class AddToCartPopUp extends BasePage {

    // since this a balnk page and we have a opportunity to indetify what we need here in a sequence ...
    // webElements , Methods , Constructors , Instance Variables .

    // logger instance

    WebDriverWait wait ;

    private static final Logger LOGGER = LogManager.getLogger(AddToCartPopUp.class) ;


    public AddToCartPopUp(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        waitForPageLoad();
    }

    // locator to demonstrate how we navigate backwards in the dom ... child to direct parent ..
    //  //i[@class='icon-ok']/parent::h2
    // sibling::
    // ancestor::
    // following-sibling::   next in the DOM
    // preceding-sibling::   previous in the DOM

    @FindBy(xpath = "//i[@class='icon-ok']/parent::h2")
    private WebElement cartSuccessMessage ;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton ;

    @FindBy(id = "layer_cart_product_title")
    private WebElement productTitle ;

    @FindBy(id = "layer_cart_product_price")
    private WebElement productPrice ;


//    public void waitForElement(WebElement element){
//        wait = new WebDriverWait(driver,10) ;
//        wait.until(ExpectedConditions.visibilityOf(element)) ;
//    }

// mon navigational method

    // i do not want this method to be called from outside class , hence private..
    // I do not want chaining on this method so void ///
    private void waitForPageLoad() {
        LOGGER.info(" << waiting for addtocartPop up to load successfully >>");
        waitForElement(cartSuccessMessage);
        //  return new AddToCartPopUp(driver);
    }

    public AddToCartPopUp verifyProductAdded(){

        LOGGER.info(" << verify if the cart success message is as per expected  >>");
        Assert.assertEquals(cartSuccessMessage.getText(),"Product successfully added to your shopping cart to error");
        return this;
    }


//  navigational in nature ....
    public CartSummaryPage navToCartSummary(){

        LOGGER.info(" << clicked on proceed to checkout button to navigate to cart summary page  >>");
        proceedToCheckoutButton.click();


        return new CartSummaryPage(driver);
    }


}
