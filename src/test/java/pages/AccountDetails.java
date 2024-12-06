package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountDetails extends BasePage {

    @FindBy(css= "#account_first_name") // Update with the actual ID for First Name input
    private WebElement firstNameInput;

    @FindBy(css= "#account_last_name") // Update with the actual ID for Last Name input
    private WebElement lastNameInput;

    @FindBy(css = "#post-23 > div > div > div > form > p:nth-child(9) > button") // Update with the actual ID for Display Name input
    private WebElement displayNameInput;

    @FindBy(css = "#post-23 > div > div > div > form > p:nth-child(9) > button") // Update with the actual XPath for the Save Changes button
    private WebElement saveChangesButton;

    @FindBy(css = "#post-23 > div > div > nav > ul > li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--edit-account > a") // Update with correct selector for Account Details link
    private WebElement accountDetailsLink;

    public AccountDetails(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToAccountDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(accountDetailsLink)).click(); // Click the Account Details link
    }

    public void updateAccountDetails(String firstName, String lastName, String displayName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the first name input to be visible and clear it using JavaScript
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        clearInputUsingJavaScript(firstNameInput);
        firstNameInput.sendKeys(firstName);

        // Wait for the last name input to be visible and clear it using JavaScript
        wait.until(ExpectedConditions.visibilityOf(lastNameInput));
        clearInputUsingJavaScript(lastNameInput);
        lastNameInput.sendKeys(lastName);

        // Wait for the display name input to be visible and clear it using JavaScript
        wait.until(ExpectedConditions.visibilityOf(displayNameInput));
        clearInputUsingJavaScript(displayNameInput);
        displayNameInput.sendKeys(displayName);

        // Wait for the save changes button to be clickable and click it
        wait.until(ExpectedConditions.elementToBeClickable(saveChangesButton));
        saveChangesButton.click();
    }

    private void clearInputUsingJavaScript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '';", element); // Clear the input field using JavaScript
    }
}