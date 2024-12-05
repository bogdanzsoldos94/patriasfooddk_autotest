package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.ConfigUtils;
import utils.ConstantUtils;

public class BaseTest {

    private static WebDriver driver;
    protected String baseURL;

    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            getBaseURL();
            getBrowser();
        }
    }

    public void getBrowser() {
        String browserName = ConfigUtils.readGenericElementFromConfig(ConstantUtils.DEFAULT_CONFIG_FILE,
                "browser", "chrome");
        System.out.println("Load browser type: " + browserName);
        driver = BrowserUtils.getDriver(browserName);
    }

    public void getBaseURL() {
        baseURL = ConfigUtils.readGenericElementFromConfig(ConstantUtils.DEFAULT_CONFIG_FILE, "base.url");
    }

    @AfterMethod
    public void cleanUp() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public void navigateToURL(String path) {
        System.out.println("Open next URL: " + baseURL + path);
        driver.navigate().to(baseURL + path);
    }

    public static WebDriver getDriver() {
        return driver;
    }
}