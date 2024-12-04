package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections; // Ensure this import is present
import java.util.List; // Ensure this import is present
import java.util.Objects; // Ensure this import is present

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//*[@id = 'template-register']//h1[contains(text(), 'Contul meu')]")
    private WebElement pageIdentifier;

    @FindBy(id = "reg_email")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/p[3]/button")
    private WebElement registrationButton;

    @FindBy(xpath = "//*[@class='jquery-lightbox-html']//h5[contains(text(), 'Actiune nereusita!')]")
    private WebElement registrationError;

    @FindBy(xpath = "/html/body/div[1]/div/a[contains(text(), 'Am inteles!')]")
    private WebElement dismissCookies;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void register(String email) {
        // Locate the email input field and submit the form
        emailInput.sendKeys(email);
        registrationButton.click(); // Simulate registration
    }

    public void enterEmail(String email) {
        waitUntilElementVisible((By) emailInput);
        System.out.println("Enter email: " + email);
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void submit() {
        waitUntilElementVisible((By) registrationButton);
        System.out.println("Click on registration button");
        registrationButton.click();
    }

    // Validate that an element has the required attribute
    private boolean verifyElementIsRequired(WebElement element) {
        String accessibleName = element.getAttribute("name"); // Assuming 'name' for accessibility
        String requiredAttribute = element.getAttribute("required");

        System.out.println("Field: " + accessibleName + " => required attribute value: " + requiredAttribute);

        return "true".equals(requiredAttribute); // Checking if the required attribute is "true"
    }

    // Check if all required fields are present
    public boolean verifyElementsAreRequired() {
        List<WebElement> requiredFields = Collections.singletonList(emailInput); // Add other required fields if necessary
        for (WebElement element : requiredFields) {
            if (!verifyElementIsRequired(element)) {
                return false; // Return false if any required field is not correctly set
            }
        }
        return true; // All required fields are valid
    }

    public boolean successfulLandingURL() {
        String registrationSuccessfulURL = "https://www.patriasfood.dk/contul-meu/";
        return registrationSuccessfulURL.equals(driver.getCurrentUrl());
    }

    public boolean verifyRegistrationSuccessful(String firstname) {
        String xpath = "//p[contains(text(), 'Esti logat ca " + firstname + "')]"; // Removed lastname
        WebElement welcomeMessage = waitUntilElementVisible(By.xpath(xpath));
        System.out.println("Welcome message is displayed: " + welcomeMessage.getText());
        return welcomeMessage.isDisplayed();
    }

    // Other existing methods...
}