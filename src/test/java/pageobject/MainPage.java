package pageobject;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;
import java.util.Random;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MainPage {

    private Page page;


    private String buttPizza = "//*[@id=\"react-app\"]/nav/div/nav/ul[1]/li[1]";//селектор раздела пиццы

    private String piZza = "//*[@id=\"guzhy\"]/article";//селектор обьекта с пиццей
    private String region = "//*[@id=\"react-app\"]/header/div[1]/div/span/a";//селектор нахождения региона
    private String korzina = "#react-app > nav > div > div.sc-1uavg9b-5.gGtIbB > button";//селектор корзины
    private String kontacti = "#react-app > div.sc-1h8wv3w-0.iuAXwo > div > a:nth-child(4)";//селектор кнопки контакты
    private String chetchicKorzina = "#react-app > nav > div > div.sc-1uavg9b-5.gGtIbB > button > div.sc-1uavg9b-9.iykVRb";//селектор обозначения товаров в корзине

    //селектор контактов
 private String price;
 public String getPrice(){
     return this.price;
 }
    public MainPage(Page page) {
        this.page = page;
    }

    public Locator locator(String xPath) {
        return page.locator(xPath);
    }

    public MainPage cliclpizza() {
        Allure.step("Переходим в раздел пицца");
        locator(buttPizza).click();//нажимаем на кнопку пицца
        return this;
    }

    public MainPage kolpizza() {
        Allure.step("Считаем кол-во товара в разделе пицца выводим и проверяем кол-во");
        Assertions.assertFalse(piZza.isEmpty(), "Товары в разделе 'Пицца' не отображаются");// проверяем что в разделе  пицца есть товары
        var pizzas = locator(piZza);//неявно обьявляем переменную pizzas присваеваем ей локатор обьекта с пиццей
        System.out.println("Общее количество пицц на странице: " + pizzas.count());// выводим сообщение с пересчитаной переменной pizzas
        return this;
    }

    public MainPage reg() {
        Allure.step("определяем регион и выводим его");
        String regionName = locator(region).innerText();// вытаскиваем название региона из обьекта
        System.out.println("Наименование региона: " + regionName);//выводим название регион
        return this;
    }

    public void dobpiz() {
        Allure.step("выбираем случайную пиццу");
        ElementHandle[] pizzas = page.querySelectorAll(piZza).toArray(new ElementHandle[0]);//создаем массив из товаров в разделе пицца
        Random random = new Random();
        int randomIndex = random.nextInt(pizzas.length);// генерируем случайное число и присваиваем его индексу
        ElementHandle randomPizza = pizzas[randomIndex];// выбираем рандомный эллемент
        String xpaz = randomPizza.innerText();//достаем текст из обьекта случайно выбраного обьекта
        this.price = xpaz;
        System.out.println(xpaz);
        randomPizza.click();

    }
    public MainPage dobavMnog() {
        Allure.step("выбираем случайную пиццу");
        ElementHandle[] pizzas = page.querySelectorAll(piZza).toArray(new ElementHandle[0]);//создаем массив из товаров в разделе пицца
        Random random = new Random();
        int randomIndex = random.nextInt(pizzas.length);// генерируем случайное число и присваиваем его индексу
        ElementHandle randomPizza = pizzas[randomIndex];// выбираем рандомный эллемент
        String xpaz = randomPizza.innerText();//достаем текст из обьекта случайно выбраного обьекта
        System.out.println(xpaz);
        randomPizza.click();
        return this;
    }
    public  MainPage cliclKorzina(){
        Allure.step("переходим в вкладку корзины");
        locator(korzina).click();
        return this;
    }
    public MainPage konTact(){
        Allure.step("Переходим в вкладку контакты");
        locator(kontacti).click();
        return this;

    }
    public MainPage kolvoVkorzine(){
     Allure.step("Проверяем что товар добавлен в корзину и на кнопке появилась единица");
     String chec = locator(chetchicKorzina).innerText();
     System.out.println(chec);
     assertTrue(chec.contains("1"), "товар добавлен ");
     return this;

    }
    public MainPage kolvoVkorzinemnoga() {
        Allure.step("Проверяем что товар добавлен в корзину и на кнопке появилась единица");
        String chec = locator(chetchicKorzina).innerText();
        System.out.println(chec);
        assertTrue(chec.contains("5"), "товар добавлен ");
        return this;
    }
}



