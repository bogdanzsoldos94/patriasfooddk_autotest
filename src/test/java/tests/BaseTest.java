/* package tests;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.BasePage;
import utils.BrowserUtils;
import utils.ConfigUtils;
import utils.ConstantUtils;

public class BaseTest {
    protected WebDriver driver;
    protected String baseURL;
    protected BasePage basePage;
    protected Alert alert;

    public void getBrowser(String browserName) {
        driver = BrowserUtils.getDriver(browserName);
    }

    public void getBrowser() {
        String browserName = ConfigUtils.readGenericElementFromConfig(ConstantUtils.DEFAULT_CONFIG_FILE,
                "browser", "chrome");
        System.out.println("Load browser type: " + browserName);
        driver = BrowserUtils.getDriver(browserName);
        basePage = new BasePage(driver);
    }

    public void getBrowserWithEnv() {
        String browserName = ConfigUtils.readGenericElementFromConfig(ConstantUtils.DEFAULT_CONFIG_FILE,
                "browser", "chrome");
        String environment = ConfigUtils.readGenericElementFromConfig(ConstantUtils.DEFAULT_CONFIG_FILE,
                "environment", "local");
        System.out.println("Load browser type: " + browserName);
        driver = BrowserUtils.getDriver(browserName, environment);
        basePage = new BasePage(driver);
    }




    @BeforeMethod
    public void setUp() {
        getBaseURL();
        getBrowser();
    }


    private void closeBrowserAtEnd() {
        if (driver != null) {
            System.out.println("Close browser at the end of test");
            driver.quit();
        } else System.out.println("Driver is null canot be closed.");
    }







     @AfterMethod
    public void cleanUpAfterMethod() {
         closeBrowserAtEnd();
    }



    public void getBaseURL() {
        getBaseURL(ConstantUtils.DEFAULT_CONFIG_FILE);
    }

    public void getBaseURL(String configFileName) {
        baseURL = ConfigUtils.readGenericElementFromConfig(configFileName, "base.url");
    }

    public void navigateToURL(String path) {
        System.out.println("Open next url:" + baseURL + path);
        driver.navigate().to(baseURL + path);
    }

    public void verifyAlertIsClosed() {
        Assert.assertTrue(basePage.isAlertClosed());
        System.out.println("Alert was closed successfully");
    }

    public void verifyAlertText(String expectedText) {
        System.out.println("Get alert text");
        alert = basePage.waitUntilAlertIsPresent();
        System.out.println(basePage.getAlertText(alert));
        Assert.assertEquals(basePage.getAlertText(alert), expectedText);
    }

}

 */

/* package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import utils.ConfigUtils;
import utils.ConstantUtils;
import utils.BrowserUtils;

public class BaseTest {

    protected WebDriver driver;
    protected String baseURL;

    public void getBrowser(String browserName) {
        driver = BrowserUtils.getDriver(browserName);
    }

    public void getBrowser() {
        String browserName = ConfigUtils.readGenericElementFromConfig(ConstantUtils.DEFAULT_CONFIG_FILE,
                "browser", "chrome");
        System.out.println("Load browser type: " + browserName);
        driver = BrowserUtils.getDriver(browserName);
    }

    public void setUP() {
        getBaseURL();
        getBrowser();
    }

    private void closeBrowserAtEnd() {
        if (driver != null) {
            System.out.println("Close browser at end");
            driver.quit();
        }
    }

    @AfterTest
    public void cleanUp() {
        closeBrowserAtEnd();
    }

    @AfterMethod
    public void cleanAfterMethod() {
        closeBrowserAtEnd();
    }

    public void getBaseURL() {
        getBaseURL(ConstantUtils.DEFAULT_CONFIG_FILE);
    }

    public void getBaseURL(String configFileName) {
        baseURL = ConfigUtils.readGenericElementFromConfig(configFileName, "base.url");
    }

    public void navigateToURL(String path) {
        System.out.println("Open next URL: " + baseURL + path);
        driver.navigate().to(baseURL + path);
    }
}

BASE TEST IOANA!!!
 */

package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.ConfigUtils;
import utils.ConstantUtils;

public class BaseTest {
    protected WebDriver driver;
    protected String baseURL;

    @BeforeMethod
    public void setUp() {
        String browserName = ConfigUtils.readGenericElementFromConfig(ConstantUtils.DEFAULT_CONFIG_FILE, "browser", "chrome");
        driver = BrowserUtils.getDriver(browserName);
        baseURL = ConfigUtils.readGenericElementFromConfig(ConstantUtils.DEFAULT_CONFIG_FILE, "base.url");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void navigateToURL(String path) {
        driver.navigate().to(baseURL + path);
    }
}
