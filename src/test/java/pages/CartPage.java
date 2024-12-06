/* package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class CartPage extends BasePage {

    @FindBy(css = "#post-21 > div > div > strong > strong > form > table > tbody > tr.woocommerce-cart-form__cart-item.cart_item > td.product-quantity > div > input.qty_button.plus")
    private WebElement increaseQuantityButton;

    @FindBy(css = "#post-21 > div > div > strong > strong > form > table > tbody > tr:nth-child(2) > td > button")
    private WebElement proceedToCheckoutButton;

    @FindBy(css = "#navbar > div > div.shop_cart_div > a > span")
    private WebElement basketButton;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void viewCart() {
        System.out.println("Clicking on the basket button to view the cart...");
        basketButton.click(); // Ensure this is the correct element to view the cart
    }

    // Method to increase the quantity by the specified amount
    public void increaseQuantityBy(int amount) {
        for (int i = 0; i < amount; i++) {
            increaseQuantityButton.click(); // Click the increase button
        }
    }

    // Method to proceed to checkout
    public void proceedToCheckout() {
        proceedToCheckoutButton.click();
    }
}

 */
/*package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    @FindBy(css = "#page > div.nine-high-padding > div > div > div > ul > li.col-md-4.post-1802.product.type-product.status-publish.has-post-thumbnail.product_cat-pasare.last.instock.shipping-taxable.purchasable.product-type-simple > div > div > div > div.desc-title-price > div.woocommerce-product--list-meta > div > a.added_to_cart.wc-forward")
    private WebElement basketButton;

    @FindBy(css = "#post-21 > div > div > strong > strong > form > table > tbody > tr:nth-child(2) > td > button")
    private WebElement proceedToCheckoutButton;

    @FindBy(css = "#post-21 > div > div > strong > strong > form > table > tbody > tr.woocommerce-cart-form__cart-item.cart_item > td.product-quantity > div > input.qty_button.plus")
    private WebElement increaseQuantityButton;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void proceedToCheckout() {
        proceedToCheckoutButton.click();
    }

    public void increaseQuantityBy(int amount) {
        for (int i = 0; i < amount; i++) {
            increaseQuantityButton.click(); // Click the increase button
        }
    }

    public void viewCart() {
        waitUntilElementVisible(basketButton); // Ensure the button is visible
        if (basketButton.isDisplayed() && basketButton.isEnabled()) {
            System.out.println("Clicking on the basket button to view the cart...");
            basketButton.click(); // Click the basket button
        } else {
            System.out.println("Basket button not interactable, trying to click with JavaScript...");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", basketButton); // Use JavaScript to click
        }


    }
}

 */

package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage {

    @FindBy(css = "#page > div.nine-high-padding > div > div > div > ul > li.col-md-4.post-1802.product.type-product.status-publish.has-post-thumbnail.product_cat-pasare.last.instock.shipping-taxable.purchasable.product-type-simple > div > div > div > div.desc-title-price > div.woocommerce-product--list-meta > div > a.added_to_cart.wc-forward")
    private WebElement basketButton;

    @FindBy(css = "#post-21 > div > div > strong > strong > div > div > div")
    private WebElement proceedToCheckoutButton;

    @FindBy(css = "#post-21 > div > div > strong > strong > form > table > tbody > tr.woocommerce-cart-form__cart-item.cart_item > td.product-quantity > div > input.qty_button.plus")
    private WebElement increaseQuantityButton;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void viewCart() {
        waitUntilElementVisible(basketButton);
        if (basketButton.isDisplayed() && basketButton.isEnabled()) {
            System.out.println("Clicking on the basket button to view the cart...");
            basketButton.click(); // Click the basket button
        } else {
            System.out.println("Basket button not interactable, trying to click with JavaScript...");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", basketButton);
        }
    }

    public void proceedToCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
            proceedToCheckoutButton.click(); // Click the button
        } catch (TimeoutException e) {
            System.out.println("Timeout while waiting for proceed to checkout button to be clickable.");
            throw e;
        }
    }

    public void increaseQuantityBy(int amount) {
        for (int i = 0; i < amount; i++) {
            increaseQuantityButton.click();
            System.out.println("Increasing quantity, current attempt: " + (i + 1));
        }
    }
}