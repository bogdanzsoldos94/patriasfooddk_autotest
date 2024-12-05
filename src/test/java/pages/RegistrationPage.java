package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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
        registrationButton.click();
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



    public boolean successfulLandingURL() {
        String registrationSuccessfulURL = "https://www.patriasfood.dk/contul-meu/";
        return registrationSuccessfulURL.equals(driver.getCurrentUrl());
    }


}