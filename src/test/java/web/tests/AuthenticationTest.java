package web.tests;

import org.testng.annotations.Test;
import web.pages.AuthenticationPage;
import static org.testng.Assert.assertTrue;

public class AuthenticationTest extends BaseTest{

    @Test
    public void testLoginSucceeded() {
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        boolean isVisible = authenticationPage.
                open().
                login(EMAIL, PASSWORD).
                isAccountIconVisible();
        assertTrue(isVisible, "Login is failed");
    }
}
