package web.tests;

import org.testng.annotations.Test;
import web.models.AccountFormFactory;
import web.pages.AuthenticationPage;
import static org.testng.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    public static final String EMAIL = "testAccount2302@yandex.by";

    @Test
    public void testCreateAccountSucceeded() {
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        boolean isVisible = authenticationPage.
                                            open().
                                            fillEmail(EMAIL).
                                            clickCreateAccount().
                                            fillNecessaryRegistrationInformation(AccountFormFactory.get()).
                                            registerNewAccount().
                                            isAccountIconVisible();
        assertTrue(isVisible, "Account creation is failed");
    }
}
