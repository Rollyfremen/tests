package pageobject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;

public class PizzaOkno {

    private String simplButton = "body > div:nth-child(53) > div > div.popup-padding > div > div > div.sc-1r4m23d-7.dlYEuz > div.sc-1r4m23d-8.BudjO > div > div > div.scroll__view > div > div.sc-1r4m23d-16.bQiWtQ > div:nth-child(1) > label:nth-child(3)";
    //селектор кнопки маленькая

    private String addButton = "body > div:nth-child(53) > div > div.popup-padding > div > div > div.sc-1r4m23d-7.dlYEuz > div.sc-1r4m23d-17.fvLrvW > button";
    //селектор кнопки добавить
    private Page page;

    public PizzaOkno (Page page) {
        this.page = page;
    }
    public Locator locator(String xPath) {
        return page.locator(xPath);
    }
    public PizzaOkno clicSimplButton(){
        Allure.step("нажимаем на кнопку маленькая");
        page.waitForSelector(simplButton).click();
        return  this;
    }
    public PizzaOkno clicAddButton() {
        Allure.step("нажимаем на кнопку маленькая");
        page.waitForSelector(addButton).click();
        return this;
    }
}
