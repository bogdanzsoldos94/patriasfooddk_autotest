package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogoutPage;

public class LogoutTest extends BaseTest {
    @Test
    public void logoutTest() {
        setUp(); // Initialize the WebDriver and other settings
        driver.navigate().to(baseURL); // Navigate to the base URL
        LogoutPage logoutPage = new LogoutPage(driver); // Initialize the LogoutPage
        logoutPage.logout(); // Perform the logout action
        Assert.assertTrue(logoutPage.verifyLogoutSuccessful(), "Logout was not successful."); // Verify logout success
    }
}