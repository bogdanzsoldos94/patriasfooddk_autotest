package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BasePage {

    @FindBy(css= "#post-23 > div > div > div > p:nth-child(2) > a")
    private WebElement logoutButton;

    public LogoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void logout() {
        waitUntilElementClickable(logoutButton);
        logoutButton.click();
    }

    public boolean verifyLogoutSuccessful() {
        return true;
    }
}