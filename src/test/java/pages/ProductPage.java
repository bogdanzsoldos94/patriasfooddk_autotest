package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private final WebDriver driver;
   // private final WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    //    this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    // Navigate to the product page
    public void goTo(String productUrl) {
        driver.get(productUrl);
    }

    public String getSuccessMessage() {
        WebElement successMessageElement = driver.findElement(By.cssSelector("selector-for-success-message")); // Replace with the actual selector
        return successMessageElement.getText();
    }

    // Add a product to the basket
    public void addToBasket() {
        try {
            Thread.sleep(3000); // Wait for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement addToCartButton = driver.findElement(By.cssSelector("#page > div.nine-high-padding > div > div > div > ul > li.col-md-4.first.post-1992.product.type-product.status-publish.has-post-thumbnail.product_cat-cornuri.instock.shipping-taxable.purchasable.product-type-simple > div > div > div > div.desc-title-price > div.woocommerce-product--list-meta > div > a"));
        addToCartButton.click();
    }

    // Proceed to the cart page
    public void openCart() {
        try {
            Thread.sleep(2000); // Wait for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement cartButton = driver.findElement(By.cssSelector("#navbar > div"));
        cartButton.click();
    }}


  /*  public WebDriverWait getWait() {
        return wait;
    }
}

   */
