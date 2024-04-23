package pageobject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PizzaPage {
    private String pizaprov = "body > div:nth-child(49) > div > div.popup-padding > div > div > div.sc-1r4m23d-7.dlYEuz > div.sc-1r4m23d-8.BudjO > div > div > div.scroll__view > div > div.sc-1r4m23d-10.cqGCBA > h1";
    //селектор названия пиццы
    private String value = "body > div:nth-child(49) > div > div.popup-padding > div > div > div.sc-1r4m23d-7.dlYEuz > div.sc-1r4m23d-17.fvLrvW > button > span > span.money__value";
    //селектор цены

    private String simplButton = "body > div:nth-child(49) > div > div.popup-padding > div > div > div.sc-1r4m23d-7.dlYEuz > div.sc-1r4m23d-8.BudjO > div > div > div.scroll__view > div > div.sc-1r4m23d-16.bQiWtQ > div:nth-child(1) > label:nth-child(3)";
    //селектор кнопки маленькая

    private String addButton = "body > div:nth-child(49) > div > div.popup-padding > div > div > div.sc-1r4m23d-7.dlYEuz > div.sc-1r4m23d-17.fvLrvW > button";
    //селектор кнопки добавить
    private Page page;
    private String price;
    public PizzaPage(Page page) {
        this.page = page;
    }
    public void setPrice(String price){
        this.price = price;

    }
    public Locator locator(String xPath) {
        return page.locator(xPath);
    }
    public PizzaPage clicSimplButton(){
        Allure.step("нажимаем на кнопку маленькая");
        locator(simplButton).click();
        String nor = locator(pizaprov).innerText();
        System.out.println(nor);
        assertTrue(price.contains(nor), "название пиццы совпадает");
        return  this;
    }
    public PizzaPage clicSimplButtonLoop() {
        Allure.step("нажимаем на кнопку маленькая");
        locator(simplButton).click();
        System.out.println("нажимаем на кнопку маленькая");
        return this;
    }
    public PizzaPage clicAddButton() {
        Allure.step("Нажимаем на кнопку добавить и проверяем соответсвие цены");
        locator(addButton).click();
        String pizzaName = locator(value).innerText();
        System.out.println(pizzaName);
        assertTrue(price.contains(pizzaName), "Цена соответсвует ");
        return this;
    }
    public PizzaPage clicAddButtonLoop() {
        Allure.step("Нажимаем на кнопку добавить и проверяем соответсвие цены");
        locator(addButton).click();
        System.out.println("нажимаем на кнопку добавить");
        return this;
    }
}
