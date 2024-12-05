package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    @FindBy(css = "#post-21 > div > div > strong > strong > form > table > tbody > tr.woocommerce-cart-form__cart-item.cart_item > td.product-quantity > div > input.qty_button.plus")
    private WebElement increaseQuantityButton;

    @FindBy(css = "#post-21 > div > div > strong > strong > form > table > tbody > tr:nth-child(2) > td > button")
    private WebElement proceedToCheckoutButton;

    @FindBy(css = "#navbar > div > div.shop_cart_div > a")
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