package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import pages.LogoutPage;
import pages.CartPage;

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
        productPage.goTo("https://www.patriasfood.dk/magazin/"); // replace with your product page URL

        // Step 4: Add a product to the basket
        productPage.addToBasket();

        // Step 5: View the cart
        CartPage cartPage = new CartPage(getDriver());
        cartPage.viewCart(); // Navigate to the cart

        // Step 6: Increase the quantity by 200
        cartPage.increaseQuantityBy(999);

        // Step 7: Proceed to checkout
        cartPage.proceedToCheckout();

        // Step 8: Navigate back to My Account page (optional if needed)
        navigateToURL("/contul-meu/"); // Navigate back to the account page

        // Step 9: Logout
        LogoutPage logoutPage = new LogoutPage(getDriver());
        logoutPage.logout();

        // Verify successful logout
        Assert.assertEquals(logoutPage.verifyLogoutSuccessful(), "Autentificare", "Logout was not successful!");
    }
}