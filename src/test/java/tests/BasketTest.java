package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;
import utils.BrowserUtils;

public class BasketTest {
    private WebDriver driver;
    private ProductPage productPage;

    @BeforeEach
    void setup() {
        // Properly invoke getDriver() method with browser type
        driver = BrowserUtils.getDriver("chrome"); // Or use any browser of your choice (e.g., "edge")
        productPage = new ProductPage(driver);
    }

    @Test
    void testAddToBasketAndCheckout() {
        // Navigate to product page
        productPage.goTo("https://www.patriasfood.dk/magazin/");

        // Add product to basket
        productPage.addToBasket();

        // Open the cart
        productPage.openCart();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


/*package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.ProductPage;
import utils.BrowserUtils;

public class BasketTest {
    private WebDriver driver;
    private ProductPage productPage;

    @BeforeEach
    void setup() {
        driver = BrowserUtils.getDriver(); // Fix this line by calling the method correctly
        productPage = new ProductPage(driver); // Properly initialize productPage
    }

    @Test
    void testAddToBasketAndCheckout() {
        // Navigate to product page
        productPage.goTo("/magazin/");

        // Add product to basket
        productPage.addToBasket();

        // Open the cart
        productPage.openCart();


    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

 */
