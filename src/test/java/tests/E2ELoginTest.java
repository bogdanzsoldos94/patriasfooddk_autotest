/*package tests;

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


 */
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;
import POJO.LoginModel;
import POJO.AccountModel;

public class E2ELoginTest extends BaseTest {

    @Test
    public void testUserLogin() {
        // Step 1: Create a LoginModel instance with valid credentials
        AccountModel account = new AccountModel("tradeandfacts", "testez1122");
        LoginModel loginModel = new LoginModel();
        loginModel.setAccount(account);

        // Step 2: Navigate to the login page
        navigateToURL("/contul-meu/");

        // Step 3: Log in using the LoginModel
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(loginModel.getAccount().getUsername(), loginModel.getAccount().getPassword());

        // Step 4: Verify if the login was successful
        Assert.assertTrue(loginPage.verifyLoginSuccessful(loginModel.getAccount().getUsername()),
                "Login was not successful!");


        // Step 5: Logout after the test
        LogoutPage logoutPage = new LogoutPage(getDriver());
        logoutPage.logout();
        Assert.assertTrue(logoutPage.verifyLogoutSuccessful(), "Logout was not successful!");
    }
}




