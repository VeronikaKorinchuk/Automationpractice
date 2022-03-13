package com.coherentsolutions.korinchuk.lab.java.web.utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    protected static ThreadLocal<WebDriver> drivers;

    public WebDriver getDriver() {
        drivers = new ThreadLocal<>();
        if (drivers.get() == null) {
            drivers.set(createDriver());
        }
        drivers.get().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return drivers.get();
    }

    public WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("start-maximized"));
        return driver;
    }

    public static Capabilities getDriverCapabilities() {
        return ((RemoteWebDriver) drivers.get()).getCapabilities();
    }

    public static String getBrowserVersion(){
        return (String)getDriverCapabilities().getCapability("browserVersion");
    }

    public static String getBrowserName(){
        return getDriverCapabilities().getBrowserName();
    }

    public static String getPlatform() {
        return (String)getDriverCapabilities().getCapability("platform");
    }

    public void removeDriver() {
        if (drivers.get() != null) {
            drivers.get().close();
            drivers.remove();
        }
    }
}
