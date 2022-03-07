package web.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import web.utils.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

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
