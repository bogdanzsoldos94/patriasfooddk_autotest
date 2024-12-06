package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;


import static utils.ConstantUtils.SCREENSHOTS_PATH;

public class BrowserUtils {

    // Correcting the static method signature
    public static WebDriver getDriver(String browser) {
        return getDriver(browser, "local");
    }

    public static WebDriver getDriver(String browser, String environment) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                if (environment.equalsIgnoreCase("headless")) {
                    options.addArguments("--headless");
                }
                return new ChromeDriver(options);
            case "edge":
                return new EdgeDriver();
            case "safari":
                return new SafariDriver();
            default:
                return new ChromeDriver();
        }
    }

    public static void generateScreenShots(String filename, WebDriver driver, boolean alertOn) throws IOException {
        if (alertOn)
            driver.switchTo().alert().accept();
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File saveFile = new File(SCREENSHOTS_PATH + "/" + filename + ".png");
        FileUtils.copyFile(screenshotFile, saveFile);
    }
}

