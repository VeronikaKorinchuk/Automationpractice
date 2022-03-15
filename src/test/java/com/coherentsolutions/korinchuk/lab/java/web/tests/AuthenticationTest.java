package com.coherentsolutions.korinchuk.lab.java.web.tests;

import org.testng.annotations.Test;
import com.coherentsolutions.korinchuk.lab.java.web.pages.AuthenticationPage;
import static org.testng.Assert.assertTrue;

public class AuthenticationTest extends BaseTest{

    @Test(description = "Test that login with right credentials succeeded")
    public void testLoginSucceeded() {
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        boolean isVisible = authenticationPage.
                open().
                login(EMAIL, PASSWORD).
                isAccountIconVisible();
        assertTrue(isVisible, "Login is failed");
    }
}
