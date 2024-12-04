/* package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BasePage{

    @FindBy(xpath = "//*[@class='user-action']//a[contains(text(), 'Logout')]")
    private WebElement logoutButton;

    LoginPage loginPage = new LoginPage(driver);

    public LogoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void logout() {
        loginPage.login("ioanacorinaoancea@gmail.com", "SnoopyDog12!");
        loginPage.authenticationButtonDisplayed();
        loginPage.moveToAuthenticationButton();
        System.out.println("Logout button is visible");
        waitUntilElementIsClickable(logoutButton);
        System.out.println("Click Logout button");
        logoutButton.click();
    }

    public String verifyLogoutSuccessful() {
        logout();
        return loginPage.getAuthenticationHoverButton().getText();
    }
}


 */

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BasePage {

    @FindBy(xpath = "//*[@class='user-action']//a[contains(text(), 'Logout')]")
    private WebElement logoutButton;

    public LogoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void logout() {
        // Create an instance of LoginPage using the current driver
        LoginPage loginPage = new LoginPage(driver);
        // Perform login
        loginPage.login("tradeandfacts", "testez1122");

        // Move to the authentication button
        loginPage.moveToAuthenticationButton(); // Ensure this method is public in LoginPage

        System.out.println("Logout button is visible");

        // Wait until the logout button is clickable
        waitUntilElementClickable((By) logoutButton); // Clickable WebElement reference

        System.out.println("Click Logout button");
        logoutButton.click(); // Click the logout button
    }

    public boolean verifyLogoutSuccessful() {
        // Ensure you do not call logout again here
        // Check if the login button or the authentication hover button is displayed
        return new LoginPage(driver).getAuthenticationHoverButton().isDisplayed(); // Check visibility
    }
}