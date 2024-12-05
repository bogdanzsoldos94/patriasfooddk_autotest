package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

public class BasketTest extends BaseTest {

    @Test
    public void testAddToBasket() {
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

        // Check the item count in the cart
        int itemCount = cartPage.getItemCount();
        System.out.println("Item Count in Cart: " + itemCount);
        Assert.assertTrue(itemCount > 0, "The cart should not be empty after adding a product.");

        // Check that the cart count reflects the added product
        Assert.assertEquals(itemCount, 1, "The cart should contain exactly one item.");
    }
}