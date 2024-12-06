package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ProductPage;

public class E2ELoginBasketLogout extends BaseTest {

    @Test
    public void loginAddToBasketLogoutTest() {
        // Step 1: Navigate to Login Page
        navigateToURL("/contul-meu/");

        // Step 2: Login
        LoginPage loginPage = new LoginPage(getDriver());
        String username = "tradeandfacts";
        String password = "testez1122";
        loginPage.login(username, password);

        // Verify successful login
        Assert.assertTrue(loginPage.verifyLoginSuccessful(username), "Login was not successful!");

        // Step 3: Navigate to Product Page
        ProductPage productPage = new ProductPage(getDriver());
        productPage.goTo("https://www.patriasfood.dk/magazin/");

        // Step 4: Go to second page
        productPage.goToSecondPage();

        // Step 5: Add a product to the basket
        productPage.addToBasket();

        // Step 6: Create an instance of CartPage to check the cart
        CartPage cartPage = new CartPage(getDriver());

        // Step 7: View the cart
        cartPage.viewCart();

        // Step 8: Increase the quantity by 10
        cartPage.increaseQuantityBy(10);
        System.out.println("Added 10 to quantity");

        // Step 9: Update the cart
        productPage.updateBasket();

        // Step 10: Navigate back to My Account page
        navigateToURL("contul-meu/");

        // Step 11: Logout
        LogoutPage logoutPage = new LogoutPage(getDriver());
        logoutPage.logout();

        // Verify successful logout
        Assert.assertTrue(logoutPage.verifyLogoutSuccessful(), "Logout was not successful!");
    }
}