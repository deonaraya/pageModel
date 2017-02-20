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
public class ShippingPage extends BasePage {

    Logger LOGGER = LogManager.getLogger(ShippingPage.class);

    public ShippingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        //waitForPageLoad();
    }

    @FindBy(id = "HOOK_BEFORECARRIER")
    private WebElement shippingSection;

    @FindBy(id = "cgv")
    private WebElement tncCheckbox;

    @FindBy(name = "processCarrier")
    private WebElement checkoutStep4;


    public PaymentPage shipping() {

        LOGGER.info("<< select checkbox of terms and conditions and proceed checkout >>");
        tncCheckbox.click();
        checkoutStep4.click();
        return new PaymentPage(driver);

    }

}
