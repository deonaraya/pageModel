package com.learn.pageModel.common;

import org.testng.*;

/**
 * Created by chandrad on 2/19/17.
 */
public class TestListener implements IExecutionListener, ITestListener {

    long testStartTime ;



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
}
