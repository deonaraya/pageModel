package com.learn.pageModel.tests;

import com.learn.pageModel.common.DriverManager;
import com.learn.pageModel.pages.HomePage;
import org.testng.annotations.Test;

/**
 * Created by chandrad on 2/15/17.
 */
public class HomePageTests {

//    WebDriver driver ;

//    int i;
//    String qty ;
//    WebElement element ;

//    @FindBy(name = "btnK")
//    private WebElement elementFIndBy ;


//    @Parameters("browser")
//    @BeforeMethod
//    public void setUp1(String browser){
//        driver = CommonMethods.getDriverInstance(browser);
//        driver.get("http://automationpractice.com/index.php");
//    }

//    @Parameters("browser")
//    @BeforeMethod
//    public void setUp(String browser){
//
//        if (browser.equalsIgnoreCase("firefox"))
//        {
//            driver = new FirefoxDriver();
//            driver.manage().window().maximize();
//        }
//        else if (browser.equalsIgnoreCase("chrome"))
//        {
//           // System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Downloads\\chromedriver_win32\\chromedriver.exe");
//            driver = new ChromeDriver();
//            Toolkit toolkit = Toolkit.getDefaultToolkit();
//        int Width = (int) toolkit.getScreenSize().getWidth();
//        int Height = (int) toolkit.getScreenSize().getHeight();
//        driver.manage().window().setSize(new org.openqa.selenium.Dimension(Width, Height));
//
//        }
//
//        driver.get("http://automationpractice.com/index.php");
//    }

//    @BeforeMethod
//    public void setUp(){
//        driver = new ChromeDriver() ;
//      //  driver.get("http://google.com");
//        driver.get("http://automationpractice.com/index.php");
//
//        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        int Width = (int) toolkit.getScreenSize().getWidth();
//        int Height = (int) toolkit.getScreenSize().getHeight();
//        driver.manage().window().setSize(new org.openqa.selenium.Dimension(Width, Height));
//    }




//    @Test
//    public void test(){
//        System.out.println(i);
//        System.out.println(qty);
//        System.out.println(element) ;
//        System.out.println(driver.findElement(By.id("lst-ib")));
//
//        PageFactory.initElements(driver,this);
//        System.out.println(elementFIndBy);
//
//    }

   // @Test
    public void getNameTest(){

//        HomePage page1 = new HomePage(driver);
//        page1.getProductNames();
//        page1.getProductNamesFromList();
//        page1.addProductToCart();   // new AddToCartPopUp(driver);
//
//        AddToCartPopUp page2 = new AddToCartPopUp(driver);
//        page2.waitForPageLoad();
//        page2.verifyProductAdded();
//        page2.navToCartSummary();
//
//        CartSummaryPage page3 = new CartSummaryPage(driver);
//        page3.waitForPageLoad();
//        page3.navToAuthentiation();



        // Method Chaining .....

        HomePage page = new HomePage(DriverManager.getDriver());
        page.addProductToCart()
                .verifyProductAdded().navToCartSummary().navToAuthentiation().signIn("unique1Email@mailinator.com","anirudh10");
    }

    @Test
    public void testTwo(){
        HomePage page = new HomePage(DriverManager.getDriver());
        page.getProductNamesFromList().addProductToCart().navToCartSummary().navToAuthentiation().
                signIn("unique1Email@mailinator.com","anirudh10").address().shipping().paymethod();
    }


//    @AfterMethod
//    public void tearDown(ITestResult result){
//
//        if (result.getStatus()==ITestResult.FAILURE)
//        {
//            try {
//                captureScreenshot();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//    //    driver.quit();
//    }
}
