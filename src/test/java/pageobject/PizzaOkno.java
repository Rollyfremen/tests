package pageobject;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PizzaOkno {
    private String pizaprov = "body > div:nth-child(49) > div > div.popup-padding > div > div > div.sc-1r4m23d-7.dlYEuz > div.sc-1r4m23d-8.BudjO > div > div > div.scroll__view > div > div.sc-1r4m23d-10.cqGCBA > h1";
    //селектор названия пиццы
    private String cena = "body > div:nth-child(49) > div > div.popup-padding > div > div > div.sc-1r4m23d-7.dlYEuz > div.sc-1r4m23d-17.fvLrvW > button > span > span.money__value";
    //селектор цены

    private String simplButton = "body > div:nth-child(49) > div > div.popup-padding > div > div > div.sc-1r4m23d-7.dlYEuz > div.sc-1r4m23d-8.BudjO > div > div > div.scroll__view > div > div.sc-1r4m23d-16.bQiWtQ > div:nth-child(1) > label:nth-child(3)";
    //селектор кнопки маленькая

    private String addButton = "body > div:nth-child(49) > div > div.popup-padding > div > div > div.sc-1r4m23d-7.dlYEuz > div.sc-1r4m23d-17.fvLrvW > button";
    //селектор кнопки добавить
    private Page page;
    private String preis;
    public PizzaOkno (Page page) {
        this.page = page;
    }
    public void setPreis(String preis){
        this.preis = preis;

    }
    public Locator locator(String xPath) {
        return page.locator(xPath);
    }
    public PizzaOkno clicSimplButton(){
        Allure.step("нажимаем на кнопку маленькая");
        locator(simplButton).click();
        String nor = locator(pizaprov).innerText();
        System.out.println(nor);
        assertTrue(preis.contains(nor), "название пиццы совпадает");
        return  this;
    }
    public PizzaOkno clicSimplButtonmnog() {
        Allure.step("нажимаем на кнопку маленькая");
        locator(simplButton).click();
        return this;
    }
    public PizzaOkno clicAddButton() {
        Allure.step("Нажимаем на кнопку добавить и проверяем соответсвие цены");
        locator(addButton).click();
        String norOn = locator(cena).innerText();
        System.out.println(norOn);
        assertTrue(preis.contains(norOn), "Цена соответсвует ");
        return this;
    }
    public PizzaOkno clicAddButtonmnog() {
        Allure.step("Нажимаем на кнопку добавить и проверяем соответсвие цены");
        locator(addButton).click();
        return this;
    }
}
