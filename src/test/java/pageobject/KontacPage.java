package pageobject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;

public class KontacPage {

    private String nomertel = "#react-app > div.page > div.page__wrapper > div > div > div:nth-child(1) > div.d4-4 > div > div:nth-child(1) > a";
    //селектор номера телефона

    private String pochta = "#react-app > div.page > div.page__wrapper > div > div > div:nth-child(1) > div.d4-4 > div > div:nth-child(2) > a";
    //селектор почты

    private Page page;

    public KontacPage(Page page) {
        this.page = page;
    }

    public Locator locator(String xPath) {
        return page.locator(xPath);
    }
    public KontacPage sravTel(){
        Allure.step("считываем телефон и сверяем его");
        String nomer = locator(nomertel).innerText();// считываем текст находящийся в данном обьекте
        Assertions.assertEquals("8 800 302-00-60", nomer, "Номер телефона 8 800 302-00-60");//сверяем полученные даннык с известными
        return  this;
    }

    public KontacPage sravPoch(){
        Allure.step("считываем почту и сверяем ее");
        String pocht = locator(pochta).innerText();// считываем текст находящийся в данном обьекте
        Assertions.assertEquals("feedback@dodopizza.com", pocht, "Почта feedback@dodopizza.com");//сверяем полученные даннык с известными
        return this;
    }
}
