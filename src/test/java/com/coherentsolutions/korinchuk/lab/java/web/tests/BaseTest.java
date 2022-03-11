package com.coherentsolutions.korinchuk.lab.java.web.tests;

import com.coherentsolutions.korinchuk.lab.java.web.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.coherentsolutions.korinchuk.lab.java.web.utils.DriverFactory;

public class BaseTest {

    protected  DriverFactory driverFactory;
    protected WebDriver driver;
    public static final String EMAIL = new PropertyReader().getProperty("base.email");
    public static final String PASSWORD = new PropertyReader().getProperty("base.password");

    @BeforeClass
    public void setUp() {
        driverFactory = new DriverFactory();
        driver = driverFactory.getDriver();
    }

    @AfterClass
    public void tearDown() {
        driverFactory.removeDriver();
    }

}
