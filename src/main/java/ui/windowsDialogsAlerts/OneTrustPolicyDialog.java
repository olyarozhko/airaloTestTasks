package ui.windowsDialogsAlerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.pages.BasePage;

import java.time.Duration;

public class OneTrustPolicyDialog extends BasePage {

    @FindBy(id = "onetrust-policy-title")
    private WebElement trustPolicyDialog;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptButton;

    public OneTrustPolicyDialog(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.timeout = timeout;
        PageFactory.initElements(driver, this);
    }

    public void acceptButtonClick() {
        acceptButton.click();
        waitDialogNotToBeDisplayed();
    }

    public void waitDialogNotToBeDisplayed() {
        waitElementNotToBeDisplayed(trustPolicyDialog, timeout);
    }

    public void waitDialogToBeDisplayed() {
        waitElementToBeDisplayed(trustPolicyDialog, timeout);
    }


}
