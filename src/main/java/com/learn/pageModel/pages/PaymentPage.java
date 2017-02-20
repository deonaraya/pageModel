package com.learn.pageModel.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Chintala on 2/19/2017.
 */
public class PaymentPage extends BasePage {
    Logger LOGGER = LogManager.getLogger(PaymentPage.class);

    public PaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "bankwire")
    private WebElement payByWire;

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']//button[@type='submit']")
    private WebElement confimWireOrder ;

    public PaymentPage paymethod() {

        LOGGER.info("<< select checkbox of terms and conditions and proceed checkout >>");
        payByWire.click();
        confimWireOrder.click();
        LOGGER.info("<< Wire oder has been placed successfully >>");

        return new PaymentPage(driver);


    }
}