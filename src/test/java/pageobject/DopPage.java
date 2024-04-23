package pageobject;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DopPage {



    private String samo = "body > div:nth-child(48) > div:nth-child(2) > div.popup-padding > div > div > div:nth-child(4) > button";
    private String mesto = "#\\30 0000357-0000-0000-0000-000000000000";
    private String samoBut = "body > div:nth-child(56) > div:nth-child(2) > div.popup-padding > div > div > form > div.inner > div.submit-button-wrapper > button";
    private Page page;

    public DopPage(Page page) {
        this.page = page;
    }

    public Locator locator(String xPath) {
        return page.locator(xPath);
    }
    public  DopPage samovivoz(){
        locator(samo).click();
        return this;

    }
    public DopPage samovivozbut() {
        page.waitForSelector(samoBut).click();
        return this;
    }
    public DopPage vibormesta() {
        page.waitForSelector(mesto).click();
        return this;
    }

}
