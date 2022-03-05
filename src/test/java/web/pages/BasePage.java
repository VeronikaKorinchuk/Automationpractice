package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.utils.PropertyReader;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final String BASE_URL = new PropertyReader().getProperty("base.url");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }
    public BasePage open(String url) {
        driver.get(BASE_URL + url);
        return this;
    }

    public abstract BasePage open();
}
