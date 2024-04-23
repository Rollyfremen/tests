package pageobject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;

public class KontacPage {

    private String phoneNumber = "#react-app > div.page > div.page__wrapper > div > div > div:nth-child(1) > div.d4-4 > div > div:nth-child(1) > a";
    //селектор номера телефона

    private String mail = "#react-app > div.page > div.page__wrapper > div > div > div:nth-child(1) > div.d4-4 > div > div:nth-child(2) > a";
    //селектор почты

    private Page page;

    public KontacPage(Page page) {
        this.page = page;
    }

    public Locator locator(String xPath) {
        return page.locator(xPath);
    }
    public KontacPage checkingTheNumber(){
        Allure.step("считываем телефон и сверяем его");
        String number = locator(phoneNumber).innerText();// считываем текст находящийся в данном обьекте
        Assertions.assertEquals("8 800 302-00-60", number, "Номер телефона 8 800 302-00-60");//сверяем полученные даннык с известными
        return  this;
    }

    public KontacPage checkingMail(){
        Allure.step("считываем почту и сверяем ее");
        String mailstring = locator(mail).innerText();// считываем текст находящийся в данном обьекте
        Assertions.assertEquals("feedback@dodopizza.com", mailstring, "Почта feedback@dodopizza.com");//сверяем полученные даннык с известными
        return this;
    }
}
