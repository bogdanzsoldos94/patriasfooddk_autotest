package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import POJO.RegistrationModel;
import data.RegistrationDP;
import pages.LoginPage;
import pages.RegistrationPage;

public class E2ELoginLogout extends BaseTest {

    @Test(dataProvider = "registrationValidDataProvider", dataProviderClass = RegistrationDP.class)
    public void testUserRegistrationAndLogin(RegistrationModel registrationModel) {
        // Debugging: Print the email to ensure it's not null
        String email = registrationModel.getRegistrationDetailsModel().getEmail();
        System.out.println("Email for registration: " + email);

        // Step 1: Navigate to the registration page
        navigateToURL("/contul-meu");

        // Step 2: Fill in the registration form
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.enterEmail(email); // Pass the email to the method
        registrationPage.submit(); // Submit the registration form

        // Step 3: Verify registration success
        Assert.assertTrue(registrationPage.successfulLandingURL(), "User should be redirected to the account page.");

        // Step 4: Navigate to the login page
        navigateToURL("/contul-meu/");

        // Step 5: Log in with the newly registered credentials
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(email, "testez1122"); // Use the actual password

        // Step 6: Verify login success
        Assert.assertTrue(loginPage.verifyLoginSuccessful(email), "User should be logged in successfully.");
    }
}