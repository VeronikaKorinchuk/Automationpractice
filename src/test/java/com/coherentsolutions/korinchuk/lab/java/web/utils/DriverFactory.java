package com.coherentsolutions.korinchuk.lab.java.web.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import java.util.Optional;
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

    @Parameters("browser")
    public WebDriver createDriver() {
        Optional <String> browser = Optional.of("firefox");
        WebDriver driver = null;
        if (browser.get().equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        } if (browser.get().equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver(new ChromeOptions().addArguments("start-maximized"));
        }
        return driver;
    }

    public void removeDriver() {
        if (drivers.get() != null) {
            drivers.get().close();
            drivers.remove();
        }
    }
}
