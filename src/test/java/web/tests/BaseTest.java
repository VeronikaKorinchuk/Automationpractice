package web.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import web.utils.DriverFactory;
import web.utils.PropertyReader;

public class BaseTest {

    protected WebDriver driver;
    public static final String EMAIL = new PropertyReader().getProperty("base.email");
    public static final String PASSWORD = new PropertyReader().getProperty("base.password");

    @BeforeClass
    public void setUp() {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getDriver();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

}
