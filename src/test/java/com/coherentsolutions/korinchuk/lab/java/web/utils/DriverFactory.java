package com.coherentsolutions.korinchuk.lab.java.web.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    protected static ThreadLocal<WebDriver> drivers;
    private DesiredCapabilities capabilities;

    public WebDriver getDriver() throws MalformedURLException {
        drivers = new ThreadLocal<>();
        if (drivers.get() == null) {
            drivers.set(createDriver("Saucelabs", "chrome"));
        }
        drivers.get().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return drivers.get();
    }

    public WebDriver createDriver(String testRunner, String browserName) throws MalformedURLException {
        WebDriver driver = null;
        setCapabilities(browserName);
        switch (testRunner) {
            case "Run locally":
                if (browserName.equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                } else if (browserName.equals("firefox")) {
                    System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
                    driver = new FirefoxDriver();
                }
                break;
            case "Selenium grid":
                driver = new RemoteWebDriver(new URL(PropertyReader.getInstance().getProperty("selenium.grid.url")), capabilities);
                break;
            case "Saucelabs":
                driver = new RemoteWebDriver(new URL(PropertyReader.getInstance().getProperty("saucelabs.url")), capabilities);
                break;
        }
        return driver;
    }

    public void setCapabilities(String browserName) {
        capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browserName);
    }

    public static ThreadLocal<WebDriver> getDrivers() {
        return drivers;
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
        return getDriverCapabilities().getCapability("platform").toString();
    }

    @Attachment(value = "Browser information", type = "txt")
    public static String browserInformation() {
        return new Date() + "\n" + "Platform name: " + getPlatform() + "\n" + "Browser name: " +  getBrowserName() +
                "\n" + "Browser version: " + getBrowserVersion();
    }

    public void removeDriver() {
        if (drivers.get() != null) {
            drivers.get().close();
            drivers.remove();
        }
    }
}
