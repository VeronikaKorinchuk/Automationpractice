package com.coherentsolutions.korinchuk.lab.java.web.pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends BasePage{

    static Logger logger = Logger.getLogger(AuthenticationPage.class);
    public static String LOGIN_URL = "index.php?controller=authentication&back=my-account";

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step(value = "Open authentication page")
    @Override
    public AuthenticationPage open() {
        super.open(LOGIN_URL);
        logger.info("Open page");
        return this;
    }

    public AuthenticationPage fillEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public AuthenticationPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public AccountPage signIn() {
        signInButton.click();
        return new AccountPage(driver);
    }

    @Step(value = "Login")
    public AccountPage login(String email, String password) {
        logger.info("Login");
        return fillEmail(email).
                fillPassword(password).
                signIn();
    }
}
