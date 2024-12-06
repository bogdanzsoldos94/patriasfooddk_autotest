package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;
import pages.AccountDetails;

public class E2EChangePasswordTest extends BaseTest {

    @Test
    public void changePasswordTest() {
        // Step 1: Navigate to the base URL
        navigateToURL("/");

        // Step 2: Go to the "Contul Meu" page
        navigateToURL("/contul-meu/");

        // Step 3: Log in with valid credentials
        LoginPage loginPage = new LoginPage(getDriver());
        String username = "tradeandfacts";
        String password = "testez1122";
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.verifyLoginSuccessful(username), "Login was not successful!");

        // Step 4: Navigate to account details
        AccountDetails accountDetailsPage = new AccountDetails(getDriver());
        accountDetailsPage.navigateToAccountDetails(); // Navigate to account details

        // Step 5: Fill in the password fields
        String actualPassword = "testez1122";
        String newPassword = "testez1122";
        String confirmNewPassword = "testez1122";

        accountDetailsPage.changePassword(actualPassword, newPassword, confirmNewPassword);


        // Step 7: Navigate back to the "Contul Meu" page
        navigateToURL("/contul-meu/");

        // Step 8: Logout
        LogoutPage logoutPage = new LogoutPage(getDriver());
        logoutPage.logout();
        Assert.assertTrue(logoutPage.verifyLogoutSuccessful(), "Logout was not successful!");
    }
}