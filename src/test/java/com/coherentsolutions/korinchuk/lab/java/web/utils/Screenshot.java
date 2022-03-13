package com.coherentsolutions.korinchuk.lab.java.web.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot {

    public byte[] getScreenshotBytes(String name) {
        return ((TakesScreenshot) DriverFactory.getDrivers().get()).getScreenshotAs(OutputType.BYTES);
    }
}