/* package tests;

import POJO.RegistrationDetailsModel;
import POJO.RegistrationModel;
import data.RegistrationDP;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest {

    @Test(dataProvider = "registrationValidDataProvider", dataProviderClass = RegistrationDP.class)
    public void registrationValidTest(RegistrationModel registrationModel) {
        registerWithRegisterModel(registrationModel);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        System.out.println("Verify registration successful");
            Assert.assertTrue(registrationPage.successfulLandingURL());
            Assert.assertTrue(registrationPage.verifyRegistrationSuccessful(registrationModel.getRegistrationDetailsModel().getEmail()));
    }

    private void registerWithRegisterModel(RegistrationModel registrationModel) {
    }

    @Test(dataProvider = "registrationNegativeDataProvider", dataProviderClass = RegistrationDP.class)
    public void registrationNegativeTest(RegistrationModel registrationModel) {
        registerWithRegisterModel(registrationModel);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        System.out.println("Verify registration failed message");
        Assert.assertEquals(registrationPage.getRegistrationError(), registrationModel.getRegisterError());
    }

    @Test
    public void requiredAttributePresent() {
        setUP();
        navigateToURL("cont-nou");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        System.out.println("Verify that required attribute is present");
        Assert.assertTrue(registrationPage.verifyElementsAreRequired());
    }

    @Test(dataProvider = "emailFormatDataProvider", dataProviderClass = RegistrationDP.class)
    public void verifyEmailFormat(RegistrationModel registrationModel) {
        setUP();
        navigateToURL("cont-nou");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        System.out.println(registrationModel);

        RegistrationDetailsModel registrationForm = registrationModel.getRegistrationDetailsModel();

        registrationPage.register(registrationForm.getEmail()); // Single parameter method for email format validation
        System.out.println("Verify email format");
        Assert.assertTrue(registrationPage.verifyEmailFormatValidation(registrationModel.getRegisterError()));

        private void registerWithRegisterModel(RegistrationModel registrationModel) {
            RegistrationPage RegistrationPage = new RegistrationPage(driver);
            System.out.println(registrationModel);

            // Use the email from RegistrationModel for registration
            RegistrationPage.register(registrationModel.getRegistrationDetailsModel().getEmail());
        }
}
}

 */

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest {

    @Test
    public void testRegistration() {
        navigateToURL("/contul-meu/");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.register("test@example.com");
        Assert.assertTrue(registrationPage.successfulLandingURL());
    }
}