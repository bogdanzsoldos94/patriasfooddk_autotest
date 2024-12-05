package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        navigateToURL("/contul-meu/");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("tradeandfacts", "testez1122");
        Assert.assertTrue(loginPage.verifyLoginSuccessful("tradeandfacts"));
    }
}






