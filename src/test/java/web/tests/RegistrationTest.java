package web.tests;

import org.testng.annotations.Test;
import web.models.AccountFormFactory;
import web.pages.CreateAccountPage;
import static org.testng.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    public static final String EMAIL = "testAccount2302@yandex.by";

    @Test
    public void testCreateAccountSucceeded() {
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        boolean isVisible = createAccountPage.
                                            open().
                                            fillEmail(EMAIL).
                                            clickCreateAccount().
                                            fillNecessaryRegistrationInformation(AccountFormFactory.get()).
                                            registerNewAccount().
                                            isAccountIconVisible();
        assertTrue(isVisible, "Account creation is failed");
    }
}
