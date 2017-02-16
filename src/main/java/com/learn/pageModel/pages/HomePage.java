package com.learn.pageModel.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by chandrad on 2/14/17.
 */
public class HomePage {

    WebDriver driver ;
    WebDriverWait wait ;

    public HomePage(WebDriver driver) {     // below actions needs to be executed immediately after the object is created so inside constructor .
        this.driver = driver;               // a value of driver from testClass (where the object was created ) is propogating here ...
        PageFactory.initElements(driver,this);     // This line initializes all the @FindBy annotated WebElements ...
                                                    // WebEleemts get initilaized with a LAZY PROXY .. .and they get actual value when a method called upon them .
    }

    /*content of this JAVA class should be :
       1. All the webElements on the homepage
       2. (All the actions that we will perform on these webelemnts) as Merhods

       Never ever Write a test in Pages ...
       Never ever have a WebElement defines in Tests .....

       What makes you belive that page has rendered completely ..
       We identify a webelement that can confirm that the page has loaded

       */

    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    @FindBy(className = "dummy")
    private WebElement firstLocator ;  // we will follow the same syntax and store all the possible webElements on homePage

    @FindBy(id = "home-page-tabs")
    private WebElement cataogHeader ;   // $("#home-page-tabs")

    @FindBy(className = "homefeatured")
    private WebElement popularCatalog ;   // test in browsers console tab usng $(".homefeatured")

    @FindBy(className = "blockbestsellers")
    private WebElement bestSellerCatalog ;

    // xpath syntax : $x("//h5[@itemprop='name']")

    // xpath to locate all the popluLR CATALOG : $x("//ul[@id='homefeatured']")
    // then we navigate to li's which were directly under ul ... (syntax of single /) :  $x("//ul[@id='homefeatured']/li")
    // and located the 3rd li  using index of 3 : $x("//ul[@id='homefeatured']/li[3]")

    // from 3rd Li we directly navigated to right block using syntax of // : $x("//ul[@id='homefeatured']/li[3]//div[@class='right-block']")

    // observe the diference of passing [] index inside and outsdie the block :
 //   $x("//ul[@id='homefeatured']//div[@class='right-block']")
 //   $x("//ul[@id='homefeatured']//div[@class='right-block']")[3]

  //  $x(" XPATH  ")  basic syntax


    // your methods should always return a page..
    // if Navigational Method : return the page you are navigating to ..
    // if non navigational return yourself ....


    @FindBy(xpath = "//ul[@id='homefeatured']/li[1]//div[@class='right-block']//a[@class='product-name']")
    private WebElement productName1 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[2]//div[@class='right-block']//a[@class='product-name']")
    private WebElement productName2 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[3]//div[@class='right-block']//a[@class='product-name']")
    private WebElement productName3 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[4]//div[@class='right-block']//a[@class='product-name']")
    private WebElement productName4 ;

    //storing the webelements as List
    @FindBy(xpath = "//ul[@id='homefeatured']/li//div[@class='right-block']//a[@class='product-name']")
    private List<WebElement> productNameList ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li//div[@class='right-block']//a[@title='Add to cart']")
    private List<WebElement> addToCartButtonList ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li//div[@class='product-container']")
    private WebElement productContainerList ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[3]//div[@class='right-block']//a[@title='Add to cart']")
    private WebElement addToCartButton3 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[3]/div[@class='product-container']")
    private WebElement productContainer3 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[4]/div[@class='product-container']")
    private WebElement productContainer4 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[4]//div[@class='right-block']//a[@title='Add to cart']")
    private WebElement addToCartButton4 ;


    // spare this method as this is a common method used in  the interaction ...
    // this method will never be called from out tests...
    // This is a page level method only
    public void waitForElement(WebElement element){
        wait = new WebDriverWait(driver,10) ;
        wait.until(ExpectedConditions.visibilityOf(element)) ;
    }


// since the method is navigational in nature and taking us to AddToCartPopUp Page we are retruning the same
    public AddToCartPopUp addProductToCart(){
        LOGGER.info("<< Mouse Hover to be performed before clicking on Add To Cart Button >>");
        LOGGER.info("<< Performing Mouse Hover  >>");


        Actions action = new Actions(driver);
        action.moveToElement(productContainer3).build().perform();

        LOGGER.info("<< Mouse Hover done , waiting for AddToCartButton to appear  >>");

        waitForElement(addToCartButton3);

        LOGGER.info("<< clicking on AddToCart Button  >>");

        addToCartButton3.click();

        return new AddToCartPopUp(driver);
    }

    public HomePage getProductNames(){
        LOGGER.info("<< Printing the name of Product Names >>");
        
        System.out.println(productName1.getText());
        System.out.println(productName2.getText());
        System.out.println(productName3.getText());
        System.out.println(productName4.getText());
        
        LOGGER.info("<< product names are successfully printed >>");

     // return new HomePage(driver);
        return this;  // this is the keyword in JAVA to refer to current instance of class
    }
    
    
    public HomePage getProductNamesFromList(){
        LOGGER.info("<< Printing the name of Product Names by accessing the list >>");

        for ( WebElement name: productNameList) {
            System.out.println(name.getText());
        }
        LOGGER.info("<< product names are successfully printed by acessing the list >>");

        return this ;
    }

















}
