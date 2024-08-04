package ui;

import com.google.common.io.Files;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ui.pages.HomePage;
import utils.ReadProperties;

import java.io.File;
import java.time.Duration;

public class BaseTests extends ReadProperties {
    private WebDriver driver;
    protected HomePage homePage;
    protected static long timeout;
    protected static String browser, url, firefoxBinaryFileLocation;
    protected static Boolean headless;

    @BeforeClass
    public void setUp() {
        readPropFile();
        specifyProps();
        browserDriverConfig(browser, headless);
        goHome();

        homePage = new HomePage(driver, Duration.ofSeconds(timeout));

    }

    @BeforeMethod
    public void goHome() {
        driver.get(url);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    @SneakyThrows
    public void takeScreenshotIfTestFailed(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            var camera = (TakesScreenshot) driver;
            File screenshot = ((TakesScreenshot) camera).getScreenshotAs(OutputType.FILE);
            Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
        }
    }

    @SneakyThrows
    protected void browserDriverConfig(String browser, Boolean headless) {
        switch (browser) {
            case "chrome" -> configChromeBrowser(headless);
            case "firefox" -> configFirefoxBrowser(headless);
            default -> throw new Exception("Unknown browser");
        }
    }

    private void specifyProps() {
        timeout = Long.parseLong(props.getProperty("timeout"));
        browser = props.getProperty("browser");
        url = props.getProperty("uiUrl");
        headless = Boolean.valueOf(props.getProperty("headless"));
        firefoxBinaryFileLocation = props.getProperty("firefoxBinaryFileLocation");
    }

    private void configChromeBrowser(Boolean headless) {
        ChromeOptions chromeOptions = new ChromeOptions();
        if (headless) {
            chromeOptions.addArguments("--headless");
        }
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
    }

    private void configFirefoxBrowser(Boolean headless) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (headless) {
            firefoxOptions.addArguments("--headless");
        }
        firefoxOptions.setBinary(firefoxBinaryFileLocation);
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
        driver = new FirefoxDriver(firefoxOptions);
    }


}
