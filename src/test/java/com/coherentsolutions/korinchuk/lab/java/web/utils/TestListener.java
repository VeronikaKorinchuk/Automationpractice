package com.coherentsolutions.korinchuk.lab.java.web.utils;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class TestListener implements IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        IInvokedMethodListener.super.afterInvocation(method, testResult);
        if (testResult.getStatus() == ITestResult.FAILURE) {
            DriverFactory.browserInformation();
            new Screenshot().getScreenshotBytes(testResult.getName());
        }
    }
}