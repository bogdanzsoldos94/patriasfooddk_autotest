package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountDetails;
import pages.LoginPage;

public class E2EUpdateAccountDetails extends BaseTest {

    @Test
    public void updateAccountDetailsTest() {
        // Step 1: Navigate to Login Page
        navigateToURL("/contul-meu/");

        // Step 2: Login
        LoginPage loginPage = new LoginPage(getDriver());
        String username = "tradeandfacts";
        String password = "testez1122";
        loginPage.login(username, password);

        // Verify successful login
        Assert.assertTrue(loginPage.verifyLoginSuccessful(username), "Login was not successful!");

        // Step 3: Navigate to Account Details Page
        AccountDetails accountDetailsPage = new AccountDetails(getDriver());
        accountDetailsPage.navigateToAccountDetails(); // Navigate to Account Details

        // Step 4: Update account details
        accountDetailsPage.updateAccountDetails("John", "Doe", "tradeandfacts");
        System.out.println("Account details changed");

    }
}