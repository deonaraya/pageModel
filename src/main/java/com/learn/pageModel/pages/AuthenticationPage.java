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
public class AuthenticationPage extends BasePage {

    Logger LOGGER = LogManager.getLogger(AuthenticationPage.class);

    public AuthenticationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        waitForPageLoad();

    }

    @FindBy(xpath = "//h3[text()='Already registered?']")
    private WebElement signInHeader ;

    @FindBy(id = "email_create")
    private WebElement createEmailTextField ;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccount ;

    @FindBy(id = "email")
    private WebElement emailTextField ;

    @FindBy(id = "passwd")
    private WebElement passwordTextField ;

    @FindBy(id = "SubmitLogin")
    private WebElement login ;

    @FindBy(xpath = "//li[text()='Authentication failed.']")
    private WebElement loginErrorMessage ;

    private void waitForPageLoad(){
        LOGGER.info(" << waiting for Authentication Page to load successfully >>");
        waitForElement(signInHeader);
    }

    public BillingAddressPage signIn(String email, String password){

        LOGGER.info("<< Entering email for logging in >>");
        emailTextField.sendKeys(email);

        LOGGER.info("<< Entering email for logging in >>");
        passwordTextField.sendKeys(password);

        LOGGER.info("<< clicked on submit button for logging in >>");
        login.click();

//        if (isSignInFailed())
//        {
//            LOGGER.error("Sign in has failed due to incorrect credentials");
//            return new BillingAddressPage(driver) ;
//        }
//
//        else
        return new BillingAddressPage(driver);
    }

    public RegistrationPage signUp(String createEmail){
        createEmailTextField.sendKeys(createEmail);
        createAccount.click();
        return new RegistrationPage(driver);
    }

    // to implement the sign in fail logic

    public boolean isSignInFailed(){
        return loginErrorMessage.isDisplayed();
    }



}
