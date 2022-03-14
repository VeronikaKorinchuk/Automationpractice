package com.coherentsolutions.korinchuk.lab.java.web.tests;

import com.coherentsolutions.korinchuk.lab.java.web.utils.PropertyReader;
import com.coherentsolutions.korinchuk.lab.java.web.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.coherentsolutions.korinchuk.lab.java.web.utils.DriverFactory;
import org.testng.annotations.Listeners;
import java.net.MalformedURLException;

@Listeners(TestListener.class)
public class BaseTest {

    protected  DriverFactory driverFactory;
    protected WebDriver driver;
    public static final String EMAIL = PropertyReader.getInstance().getProperty("base.email");
    public static final String PASSWORD = PropertyReader.getInstance().getProperty("base.password");

    @BeforeClass
    public void setUp() throws MalformedURLException {
        driverFactory = new DriverFactory();
        driver = driverFactory.getDriver();
    }

    @AfterClass
    public void tearDown() {
        driverFactory.removeDriver();
    }

}
