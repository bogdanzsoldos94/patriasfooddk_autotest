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
        driver.get(productUrl); // Ensure productUrl is a full URL
    }

    public void goToSecondPage() {
        System.out.println("Navigating to the second page...");
        WebElement nextPageButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#page > div.nine-high-padding > div > div > div > nav > ul > li:nth-child(2) > a")));
        nextPageButton.click();
        System.out.println("Successfully navigated to the second page.");
    }

    // Add a product to the basket
    public void addToBasket() {
        System.out.println("Attempting to add product to the basket...");
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#page > div.nine-high-padding > div > div > div > ul > li.col-md-4.post-1802.product.type-product.status-publish.has-post-thumbnail.product_cat-pasare.last.instock.shipping-taxable.purchasable.product-type-simple > div > div > div > div.desc-title-price > div.woocommerce-product--list-meta > div > a")));

        addToCartButton.click();
        System.out.println("Product successfully added to the basket.");
    }

    // Update the basket
    public void updateBasket() {
        WebElement updateCartButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#post-21 > div > div > strong > strong > form > table > tbody > tr:nth-child(2) > td > button")));

        updateCartButton.click();
        System.out.println("Basket updated successfully.");
    }
}