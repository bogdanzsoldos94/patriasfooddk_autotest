package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set a sensible wait time
        PageFactory.initElements(driver, this);
    }

    // Navigate to the product page
    public void goTo(String productUrl) {
        driver.get(productUrl);
    }


    // Add a product to the basket
    public void addToBasket() {
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#page > div.nine-high-padding > div > div > div > ul > li.col-md-4.first.post-1992.product.type-product.status-publish.has-post-thumbnail.product_cat-cornuri.instock.shipping-taxable.purchasable.product-type-simple > div > div > div > div.desc-title-price > div.woocommerce-product--list-meta > div > a"))); // Use the actual selector
        addToCartButton.click();
    }

    // Proceed to the cart page
    public void openCart() {
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#navbar > div"))); // Use the actual selector
        cartButton.click();
    }
}