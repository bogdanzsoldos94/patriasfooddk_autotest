/* package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @DataProvider
    public Object[][] loginDataProvider() {
        return new Object[][]{
//          username, password, browser
                {"tradeandfacts", "testez1122"},
                {"tradeandfacts", "testez1122"},
                {"tradeandfacts", "testez1122"},
        };
    }

    @Test(dataProvider = "loginDataProvider")
    public void testLogin(String username, String password) {


        navigateToURL("/contul-meu/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        System.out.println("Verify login successful");
        Assert.assertTrue(loginPage.verifyLoginSuccessful(username));



        }

        }

 */

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        navigateToURL("/contul-meu/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tradeandfacts", "testez1122");
        Assert.assertTrue(loginPage.verifyLoginSuccessful("tradeandfacts"));
    }
}






