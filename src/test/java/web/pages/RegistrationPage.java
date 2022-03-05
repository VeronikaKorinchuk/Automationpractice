package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.models.AccountForm;

public class RegistrationPage extends BasePage{

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastName;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "address1")
    private WebElement address;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement zipCode;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhone;

    @FindBy(id = "alias")
    private WebElement addressAlias;

    @FindBy(id = "submitAccount")
    private WebElement submitRegisterForm;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public BasePage open() {
        return null;
    }

    public RegistrationPage fillNecessaryRegistrationInformation(AccountForm accountForm) {
        customerFirstName.sendKeys(accountForm.getCustomerFirstName());
        customerLastName.sendKeys(accountForm.getCustomerLastName());
        password.sendKeys(accountForm.getPassword());
        firstName.sendKeys(accountForm.getOfficialFirstName());
        lastName.sendKeys(accountForm.getOfficialLastName());
        address.sendKeys(accountForm.getAddress());
        city.sendKeys(accountForm.getCity());
        state.sendKeys(accountForm.getState());
        zipCode.sendKeys(accountForm.getZipCode());
        mobilePhone.sendKeys(accountForm.getMobilePhone());
        addressAlias.sendKeys(accountForm.getAddressAlias());
        return this;
    }

    public AccountPage registerNewAccount() {
        submitRegisterForm.click();
        return new AccountPage(driver);
    }
}
