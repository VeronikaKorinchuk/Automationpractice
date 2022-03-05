package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends BasePage{

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

    @Override
    public AuthenticationPage open() {
        super.open(LOGIN_URL);
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

    public AccountPage login(String email, String password) {
        return fillEmail(email).
                fillPassword(password).
                signIn();
    }
}
