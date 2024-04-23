package pageobject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class KorzinaPage {
    private String summaZakaza = "body > div:nth-child(52) > div > div.sc-7pyz9m-1.bMdtwU > div > div > div.scroll__view > main > div > div.sc-22nn4s-0.bKDVMt > section > div.info > span";


    private Page page;

    public KorzinaPage (Page page) {
        this.page = page;
    }
    public Locator locator(String xPath) {
        return page.locator(xPath);
    }
    public KorzinaPage summaVivod(){
        String summaZakazaVivod = locator(summaZakaza).innerText();//вытаскиваем сумму из корзины
        System.out.println(summaZakazaVivod);//выводим ее
        return  this;
    }


}
