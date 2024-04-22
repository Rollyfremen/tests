package pageobject;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class MainPage {

    private Page page;


    private String buttPizza = "//*[@id=\"react-app\"]/nav/div/nav/ul[1]/li[1]";

    private String pizza = "//*[@id=\"guzhy\"]/article";
    private String region = "//*[@id=\"react-app\"]/header/div[1]/div/span/a";

    public MainPage(Page page){
        this.page = page;
    }

    public Locator locator(String xPath) {
        return page.locator(xPath);
    }

    public MainPage cliclpizza() {
        Allure.step("Переходим в раздел пицца");
        locator(buttPizza).click();
        return this;
    }

    public MainPage kolpizza() {
        Allure.step("Считаем кол-во товара в разделе пицца выводим и проверяем кол-во");
        var pizzas = locator(pizza);
        System.out.println("Общее количество пицц на странице: " + pizzas.count());
        return this;
    }
    public MainPage reg() {
    ElementHandle regionElement = locator("//*[@id=\"react-app\"]/header/div[1]/div/span/a").first().elementHandle();
    String regionName = regionElement.innerText();
    Assertions.assertEquals("Москва", regionName, "Наименование региона не соответствует Москве");
    return this;
     }
}

