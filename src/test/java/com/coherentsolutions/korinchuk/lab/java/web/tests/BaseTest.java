package com.coherentsolutions.korinchuk.lab.java.web.tests;

import com.coherentsolutions.korinchuk.lab.java.web.utils.PropertyReader;
import com.coherentsolutions.korinchuk.lab.java.web.utils.TestListener;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.coherentsolutions.korinchuk.lab.java.web.utils.DriverFactory;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class BaseTest {

    protected  DriverFactory driverFactory;
    protected WebDriver driver;
    public static final String EMAIL = PropertyReader.getInstance().getProperty("base.email");
    public static final String PASSWORD = PropertyReader.getInstance().getProperty("base.password");

    @Step(value = "Init browser")
    @BeforeClass
    public void setUp() {
        driverFactory = new DriverFactory();
        driver = driverFactory.getDriver();
    }

    @Step(value = "Close browser")
    @AfterClass
    public void tearDown() {
        driverFactory.removeDriver();
    }

}
