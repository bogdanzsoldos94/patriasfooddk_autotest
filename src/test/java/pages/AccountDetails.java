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

    @FindBy(css= "#account_first_name")
    private WebElement firstNameInput;

    @FindBy(css= "#account_last_name")
    private WebElement lastNameInput;

    @FindBy(css = "#post-23 > div > div > div > form > p:nth-child(9) > button")
    private WebElement displayNameInput;

    @FindBy(css = "#post-23 > div > div > div > form > p:nth-child(9) > button")
    private WebElement saveChangesButton;

    @FindBy(css = "#post-23 > div > div > nav > ul > li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--edit-account > a")
    private WebElement accountDetailsLink;

    // Password fields
    @FindBy(css = "#password_current")
    private WebElement actualPasswordField;

    @FindBy(css= "#password_1")
    private WebElement newPasswordField;

    @FindBy(css= "#password_2")
    private WebElement confirmNewPasswordField;


    public AccountDetails(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToAccountDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(accountDetailsLink)).click();
    }

    public void updateAccountDetails(String firstName, String lastName, String displayName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        clearInputUsingJavaScript(firstNameInput);
        firstNameInput.sendKeys(firstName);

        wait.until(ExpectedConditions.visibilityOf(lastNameInput));
        clearInputUsingJavaScript(lastNameInput);
        lastNameInput.sendKeys(lastName);

        wait.until(ExpectedConditions.visibilityOf(displayNameInput));
        clearInputUsingJavaScript(displayNameInput);
        displayNameInput.sendKeys(displayName);

        wait.until(ExpectedConditions.elementToBeClickable(saveChangesButton));
        saveChangesButton.click();
    }

    public void changePassword(String actualPassword, String newPassword, String confirmNewPassword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait and fill Actual Password
        wait.until(ExpectedConditions.visibilityOf(actualPasswordField));
        actualPasswordField.clear();
        actualPasswordField.sendKeys(actualPassword);

        // Wait and fill New Password
        wait.until(ExpectedConditions.visibilityOf(newPasswordField));
        newPasswordField.clear();
        newPasswordField.sendKeys(newPassword);

        // Wait and fill Confirm New Password
        wait.until(ExpectedConditions.visibilityOf(confirmNewPasswordField));
        confirmNewPasswordField.clear();
        confirmNewPasswordField.sendKeys(confirmNewPassword);



    }

    private void clearInputUsingJavaScript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '';", element);
    }
}