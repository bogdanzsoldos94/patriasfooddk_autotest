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

        productPage.goToSecondPage();

        // Add product to basket
        System.out.println("Attempting to add product to the basket...");
        productPage.addToBasket();

        CartPage cartPage = new CartPage(getDriver());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // View the cart
        cartPage.viewCart();

        // Increase the quantity to 200
        cartPage.increaseQuantityBy(10);
        System.out.println("Added 10 to quantity");

        productPage.updateBasket();


    }
}