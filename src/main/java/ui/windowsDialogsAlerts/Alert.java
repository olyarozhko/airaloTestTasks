package ui.windowsDialogsAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.pages.BasePage;

import java.time.Duration;

public class Alert extends BasePage {
    @FindBy(className = "wzrk-alert")
    private WebElement alert;
    private By alertBy = By.className("wzrk-alert");

    @FindBy(id = "wzrk-cancel")
    private WebElement cancelButton;

    public Alert(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.timeout = timeout;
        PageFactory.initElements(driver, this);
    }

    public void cancelButtonClick() {
        cancelButton.click();
        waitAlertNotToBeDisplayed();
    }

    public void waitAlertToBeDisplayed() {
        waitElementToBeDisplayed(alert, timeout);
    }

    public void waitAlertNotToBeDisplayed() {
        waitElementNotToBeDisplayed(alert, timeout);
    }

    public void closeAlertIfDisplayed() {
        if (isElementDisplayed(alertBy)) {
            cancelButtonClick();
        }
    }

}
