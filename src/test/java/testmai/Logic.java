package testmai;


import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pageobject.*;

import java.nio.file.Paths;


public class Logic {
    protected MainPage searchPage;
    protected PizzaOkno pizzaOkno;
    protected KorzinaPage korzinaPage;
    protected KontacPage kontacPage;
    protected DopPage dopPage;
    Page page;
    Playwright playwright;


    @BeforeEach
    public void setUp() {
        playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        page = browserContext.newPage();
        searchPage = new MainPage(page);
        pizzaOkno = new PizzaOkno(page);
        korzinaPage = new KorzinaPage(page);
        kontacPage = new KontacPage(page);
        dopPage = new DopPage(page);
        page.navigate("https://dodopizza.ru/moscow/");
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        // перед началом теста запускаем браузер хром переходим на сайт додо
    }

    @AfterEach
    public void setDown() {
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));// создаем скриншот
        page.close();
        playwright.close();
    }
}

