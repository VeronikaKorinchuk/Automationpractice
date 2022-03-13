package com.coherentsolutions.korinchuk.lab.java.web.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot {

    @Attachment(value = "Test failure {0}", type = "image/png")
    public byte[] getScreenshotBytes(String name) {
        return ((TakesScreenshot) DriverFactory.getDrivers().get()).getScreenshotAs(OutputType.BYTES);
    }
}