package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest {

    @Test
    public void testRegistration() {
        navigateToURL("/contul-meu/");
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.register("test@gmail.com");
        Assert.assertTrue(registrationPage.successfulLandingURL());
    }
}