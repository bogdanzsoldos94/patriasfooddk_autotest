package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {
        navigateToURL("/contul-meu/");

        // Initialize the LoginPage and perform login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("tradeandfacts", "testez1122");

        // Now that the user is logged in, proceed to log out
        LogoutPage logoutPage = new LogoutPage(getDriver()); 
        logoutPage.logout();

        // Verify logout success
        Assert.assertTrue(logoutPage.verifyLogoutSuccessful(), "Logout was not successful.");
    }
}