package com.coherentsolutions.korinchuk.lab.java.web.tests;

import com.coherentsolutions.korinchuk.lab.java.web.models.AccountFormFactory;
import org.testng.annotations.Test;
import com.coherentsolutions.korinchuk.lab.java.web.pages.CreateAccountPage;
import static org.testng.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

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
