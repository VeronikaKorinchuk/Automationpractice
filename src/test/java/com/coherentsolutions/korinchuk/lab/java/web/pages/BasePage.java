package com.coherentsolutions.korinchuk.lab.java.web.pages;

import com.coherentsolutions.korinchuk.lab.java.web.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final String BASE_URL = PropertyReader.getInstance().getProperty("base.url");

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
