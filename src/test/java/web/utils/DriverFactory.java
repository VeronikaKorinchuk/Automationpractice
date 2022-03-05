package web.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
        WebDriver driver  = new ChromeDriver(new ChromeOptions().addArguments("start-maximized"));
        return driver;
    }

    public void removeDriver() {
        drivers.get().quit();
    }

    public static ThreadLocal<WebDriver> getDrivers() {
        return drivers;
    }
}
