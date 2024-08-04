package ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.windowsDialogsAlerts.EsimDetails;

public class TestESimPackageDetails extends BaseTests {

    String country = "Japan";
    String data = "1 GB", validity = "7 days", price = "$4.50 usd";

    @Test
    public void verificationSelectedESimPackageDetails() {
        homePage.closeModalsAndDialogs();
        homePage.specifySearchField(country);
        var localEsimPage = homePage.selectCountryFromSearchResult(country);
        Assert.assertEquals(localEsimPage.getPageTitle().toLowerCase(), country.toLowerCase(),
                "Page Title isn't correct");
        var esimDetailsPage = localEsimPage.setByNowButtonClickByIndex(1);
        Assert.assertEquals(esimDetailsPage.getEsimDetails(),
                new EsimDetails(country, data, validity, price), "eSim Package details are incorrect");
    }

}
