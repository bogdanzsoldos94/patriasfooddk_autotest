package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {
    @FindBy(id = "user-account")
    private WebElement authenticationHoverButton;

    @FindBy(id = "username")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath= "//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")
    private WebElement submitButton;

    @FindBy(css= "#post-23 > div > div > div.woocommerce-notices-wrapper > ul > li")
    private WebElement errorMessageElement;

    Actions action;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Method to perform login
    public void login(String usernameOrEmail, String password) {
        System.out.println("Waiting for the login page to load");
        waitUntilElementVisible(emailInput);
        enterUsernameOrEmail(usernameOrEmail);
        enterPassword(password);
        submit();
    }


    // Enter username or email into the input field
    public void enterUsernameOrEmail(String usernameOrEmail) {
        waitUntilElementVisible(emailInput);
        System.out.println("Enter username/email: " + usernameOrEmail);
        emailInput.clear();
        emailInput.sendKeys(usernameOrEmail);
    }

    // Enter password into the password field
    public void enterPassword(String password) {
        waitUntilElementVisible(passwordInput);
        System.out.println("Enter password: " + password);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    // Submit the login form
    public void submit() {
        waitUntilElementClickable((WebElement) submitButton);
        System.out.println("Clicking the submit button");
        submitButton.click();  // Click the submit button
    }

    public boolean verifyLoginSuccessful(String username) {
        String css = "#post-23 > div > div > div > p:nth-child(2)";
        WebElement welcomeMessage = waitUntilElementVisible(By.cssSelector(css));
        System.out.println("Welcome message displayed: " + welcomeMessage.getText());
        return welcomeMessage.isDisplayed();
    }


}
