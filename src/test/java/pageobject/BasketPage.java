package pageobject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasketPage {
    private String orderAmount = "body > div:nth-child(49) > div > div.sc-7pyz9m-1.bMdtwU > div > div > div.scroll__view > main > div > div.sc-22nn4s-0.bKDVMt > section > div.info > span";


    private Page page;

    public BasketPage(Page page) {
        this.page = page;
    }
    public Locator locator(String xPath) {
        return page.locator(xPath);
    }
    public BasketPage theAmountIsVisible(){
        String amountIsVisible = locator(orderAmount).innerText();//вытаскиваем сумму из корзины
        System.out.println(amountIsVisible);//выводим ее
        return  this;
    }


}
