package com.learn.pageModel.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by chandrad on 2/14/17.
 */
public class BillingAddressPage extends BasePage {

    Logger LOGGER = LogManager.getLogger(BillingAddressPage.class);


    public BillingAddressPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        waitForPageLoad();
    }

    @FindBy(id = "uniform-id_address_delivery")
    private WebElement addressSelect ;

    @FindBy(name = "processAddress")
    private WebElement checkoutStep3 ;

    private void waitForPageLoad(){
        LOGGER.info(" << waiting for Billing Address Page to load successfully >>");
        waitForElement(addressSelect);
    }


}
