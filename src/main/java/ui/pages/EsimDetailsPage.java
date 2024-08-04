package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.windowsDialogsAlerts.EsimDetails;

import java.time.Duration;

public class EsimDetailsPage extends BasePage {

    @FindBy(css = "[data-testid = 'sim-detail-header']")
    private WebElement simDetails;

    private By coverage = By.cssSelector("[data-testid='COVERAGE-value']");
    private By data = By.cssSelector("[data-testid='DATA-value']");
    private By validity = By.cssSelector("[data-testid='VALIDITY-value']");
    private By price = By.cssSelector("[data-testid='PRICE-value']");


    public EsimDetailsPage(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.timeout = timeout;
        PageFactory.initElements(driver, this);
        waitDetailsToBeDisplayed();
    }

    public String coverageGetValue() {
        return simDetails.findElement(coverage).getText();
    }

    public String dataGetValue() {
        return simDetails.findElement(data).getText();
    }

    public String validityGetValue() {
        return simDetails.findElement(validity).getText();
    }

    public String priceGetValue() {
        return simDetails.findElement(price).getText();
    }

    public EsimDetails getEsimDetails() {
        return new EsimDetails(coverageGetValue(), dataGetValue(), validityGetValue(), priceGetValue());
    }

    public void waitDetailsToBeDisplayed() {
        waitElementToBeDisplayed(simDetails, timeout);
    }


}
