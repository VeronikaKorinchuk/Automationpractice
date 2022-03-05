package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.models.AccountForm;

public class RegistrationPage extends BasePage{

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastNameInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "firstname")
    private WebElement firstNameInput;

    @FindBy(id = "lastname")
    private WebElement lastNameInput;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "id_state")
    private WebElement stateInput;

    @FindBy(id = "postcode")
    private WebElement zipCodeInput;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneInput;

    @FindBy(id = "alias")
    private WebElement addressAliasInput;

    @FindBy(id = "submitAccount")
    private WebElement submitRegisterFormButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public BasePage open() {
        return null;
    }

    public RegistrationPage fillNecessaryRegistrationInformation(AccountForm accountForm) {
        customerFirstNameInput.sendKeys(accountForm.getCustomerFirstName());
        customerLastNameInput.sendKeys(accountForm.getCustomerLastName());
        passwordInput.sendKeys(accountForm.getPassword());
        firstNameInput.sendKeys(accountForm.getOfficialFirstName());
        lastNameInput.sendKeys(accountForm.getOfficialLastName());
        addressInput.sendKeys(accountForm.getAddress());
        cityInput.sendKeys(accountForm.getCity());
        stateInput.sendKeys(accountForm.getState());
        zipCodeInput.sendKeys(accountForm.getZipCode());
        mobilePhoneInput.sendKeys(accountForm.getMobilePhone());
        addressAliasInput.sendKeys(accountForm.getAddressAlias());
        return this;
    }

    public AccountPage registerNewAccount() {
        submitRegisterFormButton.click();
        return new AccountPage(driver);
    }
}
