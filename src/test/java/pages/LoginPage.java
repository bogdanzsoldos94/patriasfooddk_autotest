package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class LoginPage extends BasePage {
    @FindBy(id = "user-account")
    private WebElement authenticationHoverButton;

    // Username or email input field using a CSS selector (you can use ID, class, or name)
    @FindBy(id = "username")  // Assuming the username field has the ID "username"
    private WebElement emailInput;

    // Password input field
    @FindBy(id = "password")
    private WebElement passwordInput;

    // Submit button (if the login form has a button to submit)
    @FindBy(xpath= "//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")  // Assuming the submit button has the ID "submitButton"
    private WebElement submitButton;

    // Error message element
    @FindBy(css= "#post-23 > div > div > div.woocommerce-notices-wrapper > ul > li")
    private WebElement errorMessageElement;

    Actions action;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


  /*  // Constructor to initialize elements
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


   */

    // Method to perform login
    public void login(String usernameOrEmail, String password) {
        System.out.println("Waiting for the login page to load");
        waitUntilElementVisible(emailInput);  // Wait for the username/email input to be visible
        enterUsernameOrEmail(usernameOrEmail);  // Enter the username or email
        enterPassword(password);  // Enter the password
        submit();  // Submit the form
    }

    // Enter username or email into the input field
    public void enterUsernameOrEmail(String usernameOrEmail) {
        waitUntilElementVisible(emailInput);  // Wait until the username/email field is visible
        System.out.println("Enter username/email: " + usernameOrEmail);
        emailInput.clear();  // Clear any pre-filled data
        emailInput.sendKeys(usernameOrEmail);  // Enter the username/email
    }

    // Enter password into the password field
    public void enterPassword(String password) {
        waitUntilElementVisible(passwordInput);  // Wait until the password field is visible
        System.out.println("Enter password: " + password);
        passwordInput.clear();  // Clear any pre-filled data
        passwordInput.sendKeys(password);  // Enter the password
    }

    // Submit the login form
    public void submit() {
        waitUntilElementClickable((By) submitButton);  // Wait until the submit button is clickable
        System.out.println("Clicking the submit button");
        submitButton.click();  // Click the submit button
    }

    public boolean verifyLoginSuccessful(String username) {
        String css = "#post-23 > div > div > div > p:nth-child(2)";
        WebElement welcomeMessage = waitUntilElementVisible(By.cssSelector(css));
        System.out.println("Welcome message displayed: " + welcomeMessage.getText());
        return welcomeMessage.isDisplayed();
    }

    public void moveToAuthenticationButton() {
        waitUntilElementVisible(authenticationHoverButton); // Ensure the button is visible
        // Use JavaScript to perform the hover action
        String script = "var event = new MouseEvent('mouseover', { bubbles: true }); " +
                "arguments[0].dispatchEvent(event);";
        ((JavascriptExecutor) driver).executeScript(script, authenticationHoverButton);
        System.out.println("Moved to authentication button");
    }

    public WebElement getAuthenticationHoverButton() {
        return authenticationHoverButton; // Ensure this returns the correct element
    }


    public boolean authenticationButtonDisplayed() {
        waitUntilElementVisible(authenticationHoverButton);
        return authenticationHoverButton.isDisplayed();
    }


    // Verify if login failed by checking the error message text
    public boolean verifyLoginFailed(String errorMessage) {
        //waitUntilElementVisible(errorMessageElement);  // Wait for the error message to be visible
        String css = "#post-23 > div > div > div.woocommerce-notices-wrapper > ul > li";
        WebElement welcomeMessage = waitUntilElementVisible(By.cssSelector(css));
        System.out.println("Error message displayed: " + errorMessageElement.getText());
        return errorMessageElement.getText().equalsIgnoreCase(errorMessage);  // Compare error message text
    }

    public void setErrorMessageElement(WebElement errorMessageElement) {
        this.errorMessageElement = errorMessageElement;
    }
}
