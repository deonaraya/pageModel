package com.learn.pageModel.common;

import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.IOException;

/**
 * Created by chandrad on 2/19/17.
 */
public class TestListener implements IExecutionListener, ITestListener, IInvokedMethodListener {

    long testStartTime ;
    WebDriver driver ;



    public void onExecutionStart() {
        testStartTime = System.currentTimeMillis();
        System.out.println("tests have started at a time stamp of " + testStartTime);

    }

    public void onExecutionFinish() {
        System.out.println("total time taken by tests to complete is " + (System.currentTimeMillis() - testStartTime)) ;
    }

    public void onTestStart(ITestResult result) {

        System.out.println("tests have started with name : " + result.getMethod().getMethodName() );
    }

    public void onTestSuccess(ITestResult result) {

        System.out.println("tests have passed with name : " + result.getMethod().getMethodName() );

    }

    public void onTestFailure(ITestResult result) {
        System.out.println("tests have failed with name : " + result.getMethod().getMethodName() );


    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }


    // before method
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {


        // we will try to put our before method logic here ..
        // we need to instantiate driver based on Browser value from XML ....

        // not using the @parameter annotation here

        String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browser");

        driver = CommonMethods.getDriverInstance(browserName) ;
        DriverManager.setWebDriver(driver);

        driver.get("http://automationpractice.com/index.php");

    }


    // after method
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

        if (testResult.getStatus()==ITestResult.FAILURE)
        {
            try {
                CommonMethods.captureScreenshot();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if (DriverManager.getDriver() != null) {

            DriverManager.getDriver().quit();
        }
    }


}
