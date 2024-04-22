package testmai;


import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pageobject.MainPage;

import java.nio.file.Paths;


public class Logic {
    protected MainPage searchPage;
    Page page;
    Playwright playwright;


    @BeforeEach
    public void setUp() {
        System.setProperty("console.encoding", "UTF-8");
        playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        page = browserContext.newPage();
        searchPage = new MainPage(page);
        page.navigate("https://dodopizza.ru/moscow/");
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        // перед началом теста запускаем браузер хром переходим на сайт додо
    }

    @AfterEach
    public void setDown() {
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
        page.close();
        playwright.close();
    }
}

