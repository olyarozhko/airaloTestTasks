package ui.windowsDialogsAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.pages.BasePage;

import java.time.Duration;

public class ModalWindow extends BasePage {

    protected By modalWindowBy = By.className("modal-content");
    @FindBy(className = "modal-content")
    protected WebElement modalWindow;

    public ModalWindow(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitModalToBeDisplayed(Duration timeout) {
        waitElementToBeDisplayed(modalWindow, timeout);
    }

    public boolean isModalOpened() {
        return isElementDisplayed(modalWindowBy);
    }

    public void closeModalIfOpened() {
        if (isModalOpened()) {
            modalWindow.sendKeys(Keys.ESCAPE);
        }
    }

}
