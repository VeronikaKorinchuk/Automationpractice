package com.coherentsolutions.korinchuk.lab.java.web.pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAccountPage extends BasePage {

    static Logger logger = Logger.getLogger(CreateAccountPage.class);
    public static String LOGIN_URL = "index.php?controller=authentication&back=my-account";

    @FindBy(id = "email_create")
    private WebElement emailInput;

    @FindBy(id = "SubmitCreate")
    private WebElement createButton;

    @FindBy(id = "account-creation_form")
    private WebElement registrationForm;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step(value = "Open create account page")
    @Override
    public CreateAccountPage open() {
        logger.info("Open page");
        super.open(LOGIN_URL);
        return this;
    }

    @Step(value = "Fill email")
    public CreateAccountPage fillEmail(String email) {
        logger.info("Filling email");
        emailInput.sendKeys(email);
        return this;
    }

    @Step(value = "Submit account creation")
    public RegistrationPage clickCreateAccount() {
        logger.info("Create account");
        createButton.click();
        wait.until(ExpectedConditions.visibilityOf(registrationForm));
        return new RegistrationPage(driver);
    }
}
