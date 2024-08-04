package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.windowsDialogsAlerts.Alert;
import ui.windowsDialogsAlerts.ModalWindow;
import ui.windowsDialogsAlerts.OneTrustPolicyDialog;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {
    protected ModalWindow modal;
    protected OneTrustPolicyDialog oneTrustPolicyDialog;
    protected Alert alert;

    @FindBy(css = "[data-testid = 'search-input']")
    private WebElement search;

    @FindBy(className = "countries-list-segment-container")
    private WebElement searchResult;

    @FindAll(
            @FindBy(className = "country-name")
    )
    private List<WebElement> countries;

    public HomePage(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.timeout = timeout;
        PageFactory.initElements(driver, this);
        modal = new ModalWindow(driver);
        oneTrustPolicyDialog = new OneTrustPolicyDialog(driver, timeout);
        alert = new Alert(driver, timeout);

    }

    public void closeModalsAndDialogs() {
        modal.waitModalToBeDisplayed(timeout);
        modal.closeModalIfOpened();
        oneTrustPolicyDialog.waitDialogToBeDisplayed();
        oneTrustPolicyDialog.acceptButtonClick();
        alert.closeAlertIfDisplayed();
    }

    public void specifySearchField(String searchString) {
        search.sendKeys(searchString);
        waitElementToBeDisplayed(searchResult, timeout);
    }

    public LocalESimsPage selectCountryFromSearchResult(String country) {
        countries.stream().filter(element -> element.getText().contains(country))
                .findFirst().get().click();
        return new LocalESimsPage(driver, timeout);
    }
}
