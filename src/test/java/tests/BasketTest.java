package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

public class BasketTest extends BaseTest {

    @Test
    public void testAddToBasketAndAdjustQuantity() {
        navigateToURL("magazin/");
        ProductPage productPage = new ProductPage(getDriver());

        // Add product to basket
        System.out.println("Attempting to add product to the basket...");
        productPage.addToBasket();

        // Create an instance of CartPage to check the cart
        CartPage cartPage = new CartPage(getDriver());

        // Wait for a moment if necessary to ensure the cart updates
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // View the cart
        cartPage.viewCart();

        // Increase the quantity to 200
        cartPage.increaseQuantityBy(100);

        // Proceed to checkout
        cartPage.proceedToCheckout();
        System.out.println("Proceeded to checkout.");
    }
}