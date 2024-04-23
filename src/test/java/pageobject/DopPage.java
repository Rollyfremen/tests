package pageobject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DopPage {


    private String pickup = "body > div:nth-child(49) > div:nth-child(2) > div.popup-padding > div > div > div:nth-child(4) > button";
    private String pickupButton = "body > div:nth-child(49) > div:nth-child(2) > div.popup-padding > div > div > form > div.inner > div.submit-button-wrapper > button";
    private Page page;

    public DopPage(Page page) {
        this.page = page;
    }

    public Locator locator(String xPath) {
        return page.locator(xPath);
    }

    public DopPage сhooseRestaurant() {
        locator(pickup).click();
        return this;

    }

    public DopPage pressPickupButton() {
        locator(pickupButton).click();
        return this;
    }
}



