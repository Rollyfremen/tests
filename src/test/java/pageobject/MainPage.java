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


    private String pizzaSectionButton = "//*[@id=\"react-app\"]/nav/div/nav/ul[1]/li[1]";//селектор раздела пиццы

    private String pizzaObject = "//*[@id=\"guzhy\"]/article";//селектор обьекта с пиццей
    private String region = "//*[@id=\"react-app\"]/header/div[1]/div/span/a";//селектор нахождения региона
    private String basketButton = "#react-app > nav > div > div.sc-1uavg9b-5.gGtIbB > button";//селектор корзины
    private String contactButton = "#react-app > div.sc-1h8wv3w-0.iuAXwo > div > a:nth-child(4)";//селектор кнопки контакты
    private String shoppingCartCounter = "#react-app > nav > div > div.sc-1uavg9b-5.gGtIbB > button > div.sc-1uavg9b-9.iykVRb";//селектор обозначения товаров в корзине

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

    public MainPage goToPizzaSection() {
        Allure.step("Переходим в раздел пицца");
        locator(pizzaSectionButton).click();//нажимаем на кнопку пицца
        System.out.println("переходим в раздел пицца");
        return this;
    }

    public MainPage countProducts() {
        Allure.step("Считаем кол-во товара в разделе пицца выводим и проверяем кол-во");
        Assertions.assertFalse(pizzaObject.isEmpty(), "Товары в разделе 'Пицца' не отображаются");// проверяем что в разделе  пицца есть товары
        var pizzas = locator(pizzaObject);//неявно обьявляем переменную pizzas присваеваем ей локатор обьекта с пиццей
        System.out.println("Общее количество пицц на странице: " + pizzas.count());// выводим сообщение с пересчитаной переменной pizzas
        return this;
    }

    public MainPage definingRegion() {
        Allure.step("определяем регион и выводим его");
        String regionName = locator(region).innerText();// вытаскиваем название региона из обьекта
        System.out.println("Наименование региона: " + regionName);//выводим название регион
        return this;
    }

    public void addRandomItem() {
        Allure.step("выбираем случайную пиццу");
        ElementHandle[] pizzas = page.querySelectorAll(pizzaObject).toArray(new ElementHandle[0]);//создаем массив из товаров в разделе пицца
        Random random = new Random();
        int randomIndex = random.nextInt(pizzas.length);// генерируем случайное число и присваиваем его индексу
        ElementHandle randomPizza = pizzas[randomIndex];// выбираем рандомный эллемент
        String pizzaText = randomPizza.innerText();//достаем текст из обьекта случайно выбраного обьекта
        this.price = pizzaText;
        randomPizza.click();
        System.out.println("выбрали случайную пиццу и запоминаем ее название");

    }
    public MainPage addRandomItemLoop() {
        Allure.step("выбираем случайную пиццу");
        ElementHandle[] pizzas = page.querySelectorAll(pizzaObject).toArray(new ElementHandle[0]);//создаем массив из товаров в разделе пицца
        Random random = new Random();
        int randomIndex = random.nextInt(pizzas.length);// генерируем случайное число и присваиваем его индексу
        ElementHandle randomPizza = pizzas[randomIndex];// выбираем рандомный эллемент
        randomPizza.click();
        System.out.println("выбрали случайную пиццу");
        return this;
    }
    public  MainPage basketClicl(){
        Allure.step("переходим в вкладку корзины");
        locator(basketButton).click();
        System.out.println("переходим в вкладку корзины");
        return this;
    }
    public MainPage contactClicl(){
        Allure.step("Переходим в вкладку контакты");
        locator(contactButton).click();
        System.out.println("переходим в вкладку контакты");
        return this;

    }
    public MainPage checkingTheShoppingCart(){
     Allure.step("Проверяем что товар добавлен в корзину и на кнопке появилась единица");
     String chec = locator(shoppingCartCounter).innerText();
     System.out.println(chec);
     assertTrue(chec.contains("1"), "товар добавлен ");
        System.out.println("Проверяем что товар добавлен");
     return this;

    }
    public MainPage carcheckingTheShoppingCartLopp() {
        Allure.step("Проверяем что товар добавлен в корзину и на кнопке появилась 5");
        String chec = locator(shoppingCartCounter).innerText();
        System.out.println(chec);
        assertTrue(chec.contains("5"), "товар добавлен ");
        System.out.println("проверяем что товар добавлен в корзину");
        return this;
    }
}



