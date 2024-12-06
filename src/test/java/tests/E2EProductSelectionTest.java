package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import pages.LogoutPage;

import java.time.Duration;

public class E2EProductSelectionTest extends BaseTest {

    @Test
    public void productSelectionAndLogoutTest() {
        // Step 1: Navigate to the base URL
        navigateToURL("/");

        // Step 2: Go to the "Contul Meu" page
        navigateToURL("/contul-meu/");

        // Step 3: Log in with valid credentials
        LoginPage loginPage = new LoginPage(getDriver());
        String username = "tradeandfacts";
        String password = "testez1122";
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.verifyLoginSuccessful(username), "Login was not successful!");

        // Step 4: Hover over the "Products" menu and select an option from the dropdown
        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);

        // Locator for the "Products" menu item
        By productsMenu = By.cssSelector("#menu-item-122 > a");
        By dropdownOption = By.xpath("//*[@id=\"menu-item-1703\"]/a[contains(text(), 'LACTATE')]");

        actions.moveToElement(driver.findElement(productsMenu)).perform();
        driver.findElement(dropdownOption).click();

        // Selector for the specific product
        By productSelector = By.cssSelector("li.col-md-4.first.post-2212");
        try {
            // Wait until the product is visible
            waitUntilElementVisible(productSelector);
            driver.findElement(productSelector).click();
        } catch (Exception e) {
            System.out.println("Could not find the product element: " + e.getMessage());
        }

        // Selector for the basket button
        By basketButtonSelector = By.cssSelector("a.added_to_cart.wc-forward");
        try {
            // Wait until the basket button is clickable
            waitUntilElementClickable(basketButtonSelector);
            driver.findElement(basketButtonSelector).click();
        } catch (Exception e) {
            System.out.println("Could not find the basket button: " + e.getMessage());
        }

        // Step 6: Navigate back to the "Contul Meu" page
        navigateToURL("/contul-meu/");

        // Step 7: Logout
        LogoutPage logoutPage = new LogoutPage(getDriver());
        logoutPage.logout();
        Assert.assertTrue(logoutPage.verifyLogoutSuccessful(), "Logout was not successful!");
    }

    private void waitUntilElementVisible(By locator) {
        // Implement an explicit wait logic here
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void waitUntilElementClickable(By locator) {
        // Implement an explicit wait logic here
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}