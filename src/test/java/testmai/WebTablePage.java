package testmai;


import org.junit.jupiter.api.Test;
import pageobject.PizzaOkno;


public class WebTablePage extends Logic {

        @Test
        public void case0() {
           searchPage
                   .cliclpizza()//переходим в раздел пиццы
                   .kolpizza()// считаем кол-во
                   .reg();// сверяем регион
        }
       @Test
        public void case1() {
           searchPage
                   .cliclpizza()
                   .dobpiz();//выбираем случайную пиццу
           pizzaOkno
                   .clicSimplButton()//выбираем маленькая
                   .clicAddButton();//нажимаем добавить
           dopPage
                   .samovivoz()
                   .vibormesta()
                   .samovivozbut();
       }
        @Test
                public  void case2(){
            for (int i = 0; i < 5; i++) {
                searchPage
                        .cliclpizza()
                        .dobpiz();
                pizzaOkno
                        .clicSimplButton()
                        .clicAddButton();
            }//добавляем случайные 5 пицц
            searchPage
                    .cliclKorzina();//переходим в корзину
            korzinaPage
                    .summaVivod();//выводим общую сумму
            }
            @Test
    public void case3() {

            searchPage
                    .konTact();//переходим в контакты
            kontacPage
                    .sravTel().sravPoch();//сверяем телефон и почту

            }

}















