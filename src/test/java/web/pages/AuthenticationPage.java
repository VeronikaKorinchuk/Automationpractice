package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthenticationPage extends BasePage {

    public static String LOGIN_URL = "index.php?controller=authentication&back=my-account";

    @FindBy(id = "email_create")
    private WebElement emailInput;

    @FindBy(id = "SubmitCreate")
    private WebElement createButton;

    @FindBy(id = "account-creation_form")
    private WebElement registrationForm;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public AuthenticationPage open() {
        super.open(LOGIN_URL);
        return this;
    }

    public AuthenticationPage fillEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public RegistrationPage clickCreateAccount() {
        createButton.click();
        wait.until(ExpectedConditions.visibilityOf(registrationForm));
        return new RegistrationPage(driver);
    }
}
