package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void invalidLoginTest() {
        // Step 1: Navigate to Login Page
        navigateToURL("/contul-meu/");

        // Step 2: Attempt to login with invalid credentials
        LoginPage loginPage = new LoginPage(getDriver());
        String invalidUsername = "a";
        String invalidPassword = "";
        loginPage.login(invalidUsername, invalidPassword);

        // Step 3: Verify error message
        String expectedErrorMessage = "Eroare: câmpul parolă este gol.";
        Assert.assertEquals(loginPage.getErrorMessage(), expectedErrorMessage, "Eroare: câmpul parolă este gol.");
    }
}