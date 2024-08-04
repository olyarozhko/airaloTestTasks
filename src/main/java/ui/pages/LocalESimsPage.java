package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class LocalESimsPage extends BasePage {
    @FindBy(id = "store-title")
    private WebElement title;

    @FindAll(
            @FindBy(className = "sim-item-link")
    )
    private List<WebElement> eSims;

    @FindBy(className = "sim-item-link")
    private WebElement eSim;

    @FindAll(
            @FindBy(css = "[data-testid = 'esim-button']")
    )
    private List<WebElement> byNowButtons;

    private String byNowButtonsXpath = ".//*[@data-testid ='esim-button']";


    public LocalESimsPage(WebDriver driver, Duration timeot) {
        this.driver = driver;
        this.timeout = timeot;
        PageFactory.initElements(driver, this);
        waitESimToBeDisplayed();
    }

    public String getPageTitle() {
        return title.getText();
    }

    public EsimDetailsPage setByNowButtonClickByIndex(int index) {
        driver.findElement(By.xpath(
                        String.format("(%s)[%d]", byNowButtonsXpath, index)))
                .click();
        return new EsimDetailsPage(driver, timeout);
    }

    public void waitESimToBeDisplayed() {
        waitElementToBeDisplayed(eSim, timeout);
    }
}
